DESCRIPTION = "Libretro Nintendo 64 cores"

inherit retro-packagegroup

LIBRETRO_N64_CORES ?= " \
  mupen64plus-libretro \
  parallel-n64-libretro \
"

LIBRETRO_N64_CORES_remove_arm64 = "parallel-n64-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_N64_CORES}"
