HOMEPAGE = "https://archive.org/details/system_20190220"
BUGTRACKER = "https://archive.org/details/system_20190220"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit retroarch-paths allarch

SRC_URI = "https://archive.org/download/system_20190220/system.zip"
SRC_URI[sha256sum] = "a7eedf2c0576a61b8ecd7a6ae09b367c13c4349d5cbd7f8e86c0aa4cb343ddda"
S = "${WORKDIR}/system"

PACKAGES =+ " \
    ${PN}-3do \
    ${PN}-bk \
    ${PN}-dreamcast \
    ${PN}-fba \
    ${PN}-fbneo \
    ${PN}-mame \
    ${PN}-msx \
    ${PN}-np2 \
    ${PN}-np2kai \
    ${PN}-pcsx2 \
    ${PN}-psone \
    ${PN}-psp \
    ${PN}-scummvm \
    ${PN}-vice \
"

# ${PN}-psp conflicts with ppsspp-libretro
RDEPENDS_${PN} += " \
    ${PN}-3do \
    ${PN}-bk \
    ${PN}-dreamcast \
    ${PN}-fba \
    ${PN}-fbneo \
    ${PN}-mame \
    ${PN}-msx \
    ${PN}-np2 \
    ${PN}-np2kai \
    ${PN}-pcsx2 \
    ${PN}-psone \
    ${PN}-scummvm \
    ${PN}-vice \
"

FILES_${PN} += "${RETROARCH_SYSTEM_DIR}"

FILES_${PN}-3do = "${RETROARCH_SYSTEM_DIR}/panafz*"
FILES_${PN}-bk = "${RETROARCH_SYSTEM_DIR}/bk"
FILES_${PN}-dreamcast += "${RETROARCH_SYSTEM_DIR}/dc"
FILES_${PN}-fba = "${RETROARCH_SYSTEM_DIR}/fba"
FILES_${PN}-fbneo += "${RETROARCH_SYSTEM_DIR}/fbneo"
FILES_${PN}-mame = "${RETROARCH_SYSTEM_DIR}/mame"
FILES_${PN}-msx = "${RETROARCH_SYSTEM_DIR}/MSX*"
FILES_${PN}-np2 += "${RETROARCH_SYSTEM_DIR}/np2"
FILES_${PN}-np2kai += "${RETROARCH_SYSTEM_DIR}/np2kai"
FILES_${PN}-pcsx2 = "${RETROARCH_SYSTEM_DIR}/pcsx2"
FILES_${PN}-psone = "${RETROARCH_SYSTEM_DIR}/scph* ${RETROARCH_SYSTEM_DIR}/ps*"
FILES_${PN}-psp = "${RETROARCH_SYSTEM_DIR}/PPSSPP"
FILES_${PN}-scummvm = "${RETROARCH_SYSTEM_DIR}/scummvm"
FILES_${PN}-vice = "${RETROARCH_SYSTEM_DIR}/vice"

# Skip file dependencies for prebuilt binaries
SKIP_FILEDEPS = "1"

# Firmware files are generally not ran on the CPU, so they can be
# allarch despite being architecture specific
INSANE_SKIP = "arch"

do_compile() {
	:
}

do_patch() {
# remove precompiled shaders
    [ -d "${S}/Mupen64plus/shaders" ] && rm -rf "${S}/Mupen64plus/shaders"
    [ -d "${S}/GLupeN64/shaders" ] && rm -rf "${S}/GLupeN64/shaders"
    find "${S}/openlara" -type f -name "*.xsh" -delete

# remove logs
    find ${S} -type f -name "*.log" -delete

# drop *.so and *.dynlib
    find ${S} -type f -name "*.so" -delete
    find ${S} -type f -name "*.dynlib" -delete

# flycast expects lowercase directory
    [ -d "${S}/DC" ] && mv ${S}/DC ${S}/dc

# FIXME: files with character [ or ] failing at rpm package stage
# BUG-REPORT: https://bugzilla.yoctoproject.org/show_bug.cgi?id=13746
# WORKAROUND: drop problematic files
    find ${S} -type f \( -name "*[*" -o -name "*]*" \) -delete
}

do_install() {
    install -d ${D}${RETROARCH_SYSTEM_DIR}
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${RETROARCH_SYSTEM_DIR}
}
