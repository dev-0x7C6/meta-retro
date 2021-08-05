DESCRIPTION = "Libretro GameBoy Color cores"

inherit retro-packagegroup

LIBRETRO_GBC_CORES ?= " \
  gambatte-libretro \
  tgbdual-libretro \
"

RRECOMMENDS:${PN} = "${LIBRETRO_GBC_CORES}"
