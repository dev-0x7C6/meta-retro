DESCRIPTION = "Libretro Nintendo Wii cores"

inherit retro-packagegroup

LIBRETRO_WII_CORES ?= "dolphin-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_WII_CORES}"
