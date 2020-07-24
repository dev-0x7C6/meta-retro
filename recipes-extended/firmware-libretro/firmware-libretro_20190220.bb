inherit retroarch-paths allarch

HOMEPAGE = "https://archive.org/details/system_20190220"
BUGTRACKER = "https://archive.org/details/system_20190220"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "https://archive.org/download/system_20190220/system.zip"
SRC_URI[sha256sum] = "46e4b65ee23bf89b7b7adce349215155defb0293ea034d990f398bdbbdb1f456"

FILES_${PN} += "${RETROARCH_SYSTEM_DIR}"
S = "${WORKDIR}/system"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

PACKAGES =+ " \
    ${PN}-ppsspp \
"

FILES_${PN} += "${RETROARCH_ASSETS_DIR}"
FILES_${PN}-ppsspp += "${RETROARCH_ASSETS_DIR}/PPSSPP"

do_patch() {
# Remove architecture specific stuff
# puae
    rm -fv ${S}/capsimg.so
# dosbox
    rm -fv ${S}/libbass.dynlib
    rm -fv ${S}/libbass.so
    rm -fv ${S}/libbassmidi.dynlib
    rm -fv ${S}/libbassmidi.so
}

do_install() {
    install -d ${D}${RETROARCH_SYSTEM_DIR}
    cp -rf ${S} ${D}${RETROARCH_SYSTEM_DIR}
}
