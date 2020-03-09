DESCRIPTION = "Libretro Atari cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

LIBRETRO_ATARI_CORES ?= " \
  atari800-libretro \
  beetle-lynx-libretro \
  handy-libretro \
  hatari-libretro \
  prosystem-libretro \
  stella2014-libretro \
  virtualjaguar-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_ATARI_CORES}"
