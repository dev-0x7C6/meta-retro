DESCRIPTION = "Libretro SNES cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

LIBRETRO_SNES_CORES ?= " \
  bsnes-libretro \
  snes9x2002-libretro \
  snes9x2005-libretro \
  snes9x2010-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_SNES_CORES}"
