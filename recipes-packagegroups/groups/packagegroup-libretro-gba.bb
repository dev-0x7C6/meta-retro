DESCRIPTION = "Libretro GameBoy Advanced cores"

inherit retro-packagegroup

LIBRETRO_GBA_CORES ?= " \
  beetle-gba-libretro \
  mgba-libretro \
  vba-next-libretro \
  vbam-libretro \
"

RRECOMMENDS:${PN} = "${LIBRETRO_GBA_CORES}"
