DESCRIPTION = "Libretro Nintendo Dual Screen (DS) cores"

inherit retro-packagegroup

LIBRETRO_NDS_CORES_remove_arm64 = " \
  desmume-libretro \
  desmume2015-libretro \
"

LIBRETRO_NDS_CORES ?= " \
  desmume-libretro \
  desmume2015-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_NDS_CORES}"
