DESCRIPTION = "Libretro GameBoy Advanced cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

LIBRETRO_GBA_CORES ?= " \
  beetle-gba-libretro \
  mgba-libretro \
  vba-next-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_GBA_CORES}"
