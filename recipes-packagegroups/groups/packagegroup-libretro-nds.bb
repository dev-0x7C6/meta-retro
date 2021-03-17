DESCRIPTION = "Libretro Nintendo Dual Screen (DS) cores"

inherit retro-packagegroup

LIBRETRO_NDS_CORES_ARCH_SPECIFIC = ""
LIBRETRO_NDS_CORES_ARCH_SPECIFIC_32bit += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'desmume-libretro', '', d)}"

LIBRETRO_NDS_CORES ?= "${LIBRETRO_NDS_CORES_ARCH_SPECIFIC}"

RRECOMMENDS_${PN} = "${LIBRETRO_NDS_CORES}"
