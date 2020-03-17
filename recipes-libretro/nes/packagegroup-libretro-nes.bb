DESCRIPTION = "Libretro Nintendo Entertainment System cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit retro/overrides packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

LIBRETRO_NES_CORES ?= " \
  fceumm-libretro \
  nestopia-libretro \
  quicknes-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_NES_CORES}"
