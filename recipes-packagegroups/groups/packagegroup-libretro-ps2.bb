DESCRIPTION = "Libretro PlayStation 2 cores"

inherit retro-packagegroup

LIBRETRO_PS2_CORES ?= "pcsx2-libretro"
RRECOMMENDS_${PN} = "${LIBRETRO_PS2_CORES}"
