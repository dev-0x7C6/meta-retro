DESCRIPTION = "Libretro Atari cores"

inherit retro/packagegroup

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
