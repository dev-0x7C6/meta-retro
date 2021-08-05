DESCRIPTION = "Libretro Nintendo Wii cores"

inherit retro-packagegroup

LIBRETRO_WII_CORES ?= " \
    dolphin-libretro \
    dolphin-launcher-libretro \
"

RRECOMMENDS:${PN} = "${LIBRETRO_WII_CORES}"
