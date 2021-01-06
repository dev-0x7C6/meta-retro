DESCRIPTION = "Libretro Nintendo 64 cores"

inherit retro-packagegroup

LIBRETRO_PC98_CORES ?= " \
    meow-pc98-libretro \
    np2kai-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_PC98_CORES}"
