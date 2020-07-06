DESCRIPTION = "Libretro SNES cores"

inherit retro-packagegroup

LIBRETRO_SNES_CORES ?= " \
  bsnes-libretro \
  snes9x2002-libretro \
  snes9x2005-libretro \
  snes9x2010-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_SNES_CORES}"
