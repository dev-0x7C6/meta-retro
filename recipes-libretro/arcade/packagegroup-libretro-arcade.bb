DESCRIPTION = "Libretro Arcade cores"

inherit retro/packagegroup

LIBRETRO_ARCADE_CORES ?= " \
  mame2000-libretro \
  mame2003-libretro \
  mame2003-plus-libretro \
"

LIBRETRO_ARCADE_CORES_remove_arm64 = "mame2000-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_ARCADE_CORES}"
