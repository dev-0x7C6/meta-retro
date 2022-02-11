DESCRIPTION = "Libretro Dreamcast cores"

inherit retro-packagegroup

LIBRETRO_DREAMCAST_CORES ?= " \
  flycast-libretro \
  vemulator-libretro \
"

RRECOMMENDS:${PN} = "${LIBRETRO_DREAMCAST_CORES}"
