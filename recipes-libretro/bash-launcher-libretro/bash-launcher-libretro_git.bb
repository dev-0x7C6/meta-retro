DESCRIPTION = "Use bash scripts to run apps/games from RetroArch/libretro"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=5fd06b523affd2a5311a17c43665dc09"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/SwedishGojira/libretro-bash-launcher.git"

BASH_LAUNCHER_INFO_FILE = "bash_launcher_libretro.info"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_INFO_DIR}/${BASH_LAUNCHER_INFO_FILE}"

do_install_append() {
    install -d ${D}/${RETROARCH_LIBRETRO_CORES_INFO_DIR}
    install -m 644 ${S}/${BASH_LAUNCHER_INFO_FILE} ${D}/${RETROARCH_LIBRETRO_CORES_INFO_DIR}
}