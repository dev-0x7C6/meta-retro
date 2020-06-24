DESCRIPTION = "Libretro GameBoy Color cores"

inherit retro-packagegroup

LIBRETRO_GBC_CORES ?= " \
  gambatte-libretro \
  tgbdual-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_GBC_CORES}"
