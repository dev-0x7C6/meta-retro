DESCRIPTION = "Libretro Nintendo GameCube cores"

inherit retro-packagegroup

LIBRETRO_NGC_CORES ?= " \
    dolphin-libretro \
    dolphin-launcher-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_NGC_CORES}"
