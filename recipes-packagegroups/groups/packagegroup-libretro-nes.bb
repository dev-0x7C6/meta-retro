DESCRIPTION = "Libretro Nintendo Entertainment System cores"

inherit retro-packagegroup

LIBRETRO_NES_CORES ?= " \
  fceumm-libretro \
  masen-libretro \
  nestopia-libretro \
  quicknes-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_NES_CORES}"
