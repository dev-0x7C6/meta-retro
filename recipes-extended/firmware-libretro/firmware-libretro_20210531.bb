HOMEPAGE = "https://archive.org/details/system_20190220"
BUGTRACKER = "https://archive.org/details/system_20190220"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit retroarch-paths allarch

SRC_URI = "https://devwork.space/mirrors/internet-archive/system_20190220/2021-05-31/system.zip"
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
RDEPENDS:${PN} += " \
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

FILES:${PN} += "${RETROARCH_SYSTEM_DIR}"

FILES:${PN}-3do = "${RETROARCH_SYSTEM_DIR}/panafz*"
FILES:${PN}-bk = "${RETROARCH_SYSTEM_DIR}/bk"
FILES:${PN}-dreamcast += "${RETROARCH_SYSTEM_DIR}/dc"
FILES:${PN}-fba = "${RETROARCH_SYSTEM_DIR}/fba"
FILES:${PN}-fbneo += "${RETROARCH_SYSTEM_DIR}/fbneo"
FILES:${PN}-mame = "${RETROARCH_SYSTEM_DIR}/mame"
FILES:${PN}-msx = "${RETROARCH_SYSTEM_DIR}/MSX*"
FILES:${PN}-np2 += "${RETROARCH_SYSTEM_DIR}/np2"
FILES:${PN}-np2kai += "${RETROARCH_SYSTEM_DIR}/np2kai"
FILES:${PN}-pcsx2 = "${RETROARCH_SYSTEM_DIR}/pcsx2"
FILES:${PN}-psone = "${RETROARCH_SYSTEM_DIR}/scph* ${RETROARCH_SYSTEM_DIR}/ps*"
FILES:${PN}-psp = "${RETROARCH_SYSTEM_DIR}/PPSSPP"
FILES:${PN}-scummvm = "${RETROARCH_SYSTEM_DIR}/scummvm"
FILES:${PN}-vice = "${RETROARCH_SYSTEM_DIR}/vice"

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
