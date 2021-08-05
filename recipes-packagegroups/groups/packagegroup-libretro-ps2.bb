DESCRIPTION = "Libretro PlayStation 2 cores"

inherit retro-packagegroup

LIBRETRO_PS2_CORES_FOR_X86 = ""
LIBRETRO_PS2_CORES_FOR_X86_x86-common = "pcsx2-libretro"

LIBRETRO_PS2_CORES ?= "${LIBRETRO_PS2_CORES_FOR_X86}"

RRECOMMENDS:${PN} = "${LIBRETRO_PS2_CORES}"
