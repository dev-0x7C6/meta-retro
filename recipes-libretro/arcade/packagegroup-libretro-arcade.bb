DESCRIPTION = "Libretro Arcade cores"

inherit retro/packagegroup

LIBRETRO_ARCADE_CORES ?= " \
  fbalpha2012-libretro \
  fbneo-libretro \
  mame2000-libretro \
  mame2003-libretro \
  mame2003-plus-libretro \
"

LIBRETRO_ARCADE_CORES_remove_arm64 = "mame2000-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_ARCADE_CORES}"
