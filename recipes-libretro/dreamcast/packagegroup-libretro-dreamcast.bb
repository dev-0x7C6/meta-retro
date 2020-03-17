DESCRIPTION = "Libretro Dreamcast cores"

inherit retro/packagegroup

LIBRETRO_DREAMCAST_CORES ?= "flycast-libretro redream-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_DREAMCAST_CORES}"
