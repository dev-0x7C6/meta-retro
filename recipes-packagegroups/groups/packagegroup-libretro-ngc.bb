DESCRIPTION = "Libretro Nintendo GameCube cores"

inherit retro-packagegroup

LIBRETRO_NGC_CORES ?= " \
    dolphin-libretro \
    dolphin-launcher-libretro \
"

RRECOMMENDS:${PN} = "${LIBRETRO_NGC_CORES}"
