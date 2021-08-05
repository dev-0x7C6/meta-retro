DESCRIPTION = "Libretro PlayStation (One) cores"

inherit retro-packagegroup

LIBRETRO_PSX_CORES ?= " \
    swanstation-libretro \
    pcsx-rearmed-libretro \
"
#LIBRETRO_PSX_CORES:remove:arm64 = "beetle-psx-libretro"

RRECOMMENDS:${PN} = "${LIBRETRO_PSX_CORES}"
