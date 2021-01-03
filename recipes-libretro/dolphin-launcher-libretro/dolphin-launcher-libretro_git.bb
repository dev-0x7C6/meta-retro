DESCRIPTION = "Launch native Dolphin from RetroArch/libretro"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=9fb2db49998f52308b904afb2fa8ebfc"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/RobLoach/libretro-dolphin-launcher.git"
INFO_FILE = "dolphin_launcher_libretro.info"

RRECOMMENDS_${PN} += "dolphin-emu"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_INFO_DIR}/${INFO_FILE}"

do_install_append() {
    install -d ${D}/${RETROARCH_LIBRETRO_CORES_INFO_DIR}
    install -m 644 ${S}/${INFO_FILE} ${D}/${RETROARCH_LIBRETRO_CORES_INFO_DIR}
}