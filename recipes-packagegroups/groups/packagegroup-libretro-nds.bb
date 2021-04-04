DESCRIPTION = "Libretro Nintendo Dual Screen (DS) cores"

inherit retro-packagegroup

LIBRETRO_NDS_CORES ?= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'desmume-libretro desmume2015-libretro', '', d)} \
"

RRECOMMENDS_${PN} = "${LIBRETRO_NDS_CORES}"
