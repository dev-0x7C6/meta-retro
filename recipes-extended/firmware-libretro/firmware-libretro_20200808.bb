HOMEPAGE = "https://archive.org/details/system_20190220"
BUGTRACKER = "https://archive.org/details/system_20190220"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit retroarch-paths allarch

PR = "r1"

SRC_URI = "https://archive.org/download/system_20190220/system.zip"
SRC_URI[sha256sum] = "9434c62625e3a26b439d7d1fa55e33309265117c0bb52798f5790555e26e170c"

FILES_${PN} += "${RETROARCH_SYSTEM_DIR}"
S = "${WORKDIR}/system"

PACKAGES =+ " \
    ${PN}-dreamcast \
    ${PN}-mame \
    ${PN}-psone \
    ${PN}-psp \
    ${PN}-scummvm \
"

# ${PN}-psp conflicts with ppsspp-libretro
RDEPENDS_${PN} += " \
    ${PN}-dreamcast \
    ${PN}-mame \
    ${PN}-psone \
    ${PN}-scummvm \
"

FILES_${PN} += "${RETROARCH_SYSTEM_DIR}"
FILES_${PN}-dreamcast += "${RETROARCH_SYSTEM_DIR}/dc"
FILES_${PN}-mame = "${RETROARCH_SYSTEM_DIR}/mame"
FILES_${PN}-psone = "${RETROARCH_SYSTEM_DIR}/scph* ${RETROARCH_SYSTEM_DIR}/ps*"
FILES_${PN}-psp = "${RETROARCH_SYSTEM_DIR}/ppsspp"
FILES_${PN}-scummvm = "${RETROARCH_SYSTEM_DIR}/scummvm"

do_patch() {
# Remove architecture specific stuff
# puae
    rm -fv ${S}/capsimg.so
# dosbox
    rm -fv ${S}/libbass.dynlib
    rm -fv ${S}/libbass.so
    rm -fv ${S}/libbassmidi.dynlib
    rm -fv ${S}/libbassmidi.so
# dreamcast emulators expect DC directory with lowercase encoding
    [ -d "${S}/DC" ] && mv ${S}/DC ${S}/dc

# FIXME: files with character [ or ] failing at rpm package stage
# BUG-REPORT: https://bugzilla.yoctoproject.org/show_bug.cgi?id=13746
# WORKAROUND: Replace all [] with ()
    IFS=$'\n'
    for f in $(find ${S} -type f \( -name "*[*" -o -name "*]*" \)); do
        oldpath="$f"
        newpath=`echo "$f" | sed "s#\[#\(#g;s#\]#\)#g"`
        if [ "${oldpath}" != "${newpath}" ]; then
        mv "${oldpath}" "${newpath}"
        fi
    done
}

do_install() {
    install -d ${D}${RETROARCH_SYSTEM_DIR}
    cp -R --no-dereference --preserve=mode,links -v ${S}/* ${D}${RETROARCH_SYSTEM_DIR}
}
