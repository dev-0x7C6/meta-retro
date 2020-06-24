DESCRIPTION = "Super Flappy Birds - Multiplayer Flappy Bird Clone"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d0a46c0360eccca3e48801dc2333a3c2"

inherit cmake retroarch-paths

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/IgniparousTempest/libretro-superflappybirds.git"
SRCREV = "${AUTOREV}"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_DIR} ${RETROARCH_SYSTEM_DIR}"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${B}/superflappybirds_libretro.so ${D}${RETROARCH_LIBRETRO_CORES_DIR}/superflappybirds_libretro.so

  install -d ${D}${RETROARCH_SYSTEM_DIR}/resources/
  cp -rf ${S}/resources/* ${D}${RETROARCH_SYSTEM_DIR}/resources/
}
