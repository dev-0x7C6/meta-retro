DESCRIPTION = "Libretro Nintendo 64 cores"

inherit retro-packagegroup

LIBRETRO_N64_CORES ?= " \
  mupen64plus-libretro \
  parallel-n64-libretro \
"

LIBRETRO_N64_CORES:remove:arm64 = "parallel-n64-libretro"

RRECOMMENDS:${PN} = "${LIBRETRO_N64_CORES}"
