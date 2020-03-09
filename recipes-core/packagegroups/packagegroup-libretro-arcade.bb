DESCRIPTION = "Libretro Arcade cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit common-overrides packagegroup

LIBRETRO_ARCADE_CORES ?= " \
  mame2000-libretro \
  mame2003-libretro \
  mame2003-plus-libretro \
"

LIBRETRO_ARCADE_CORES_remove_arm64 = "mame2000-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_ARCADE_CORES}"
