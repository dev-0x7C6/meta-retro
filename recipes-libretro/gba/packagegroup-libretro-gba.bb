DESCRIPTION = "Libretro GameBoy Advanced cores"

inherit retro/packagegroup

LIBRETRO_GBA_CORES ?= " \
  beetle-gba-libretro \
  mgba-libretro \
  vba-next-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_GBA_CORES}"
