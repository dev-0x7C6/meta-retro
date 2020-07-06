DESCRIPTION = "Libretro PlayStation (One) cores"

inherit retro-packagegroup

LIBRETRO_PSX_CORES ?= " \
    duckstation-libretro \
    pcsx-rearmed-libretro \
"
#LIBRETRO_PSX_CORES_remove_arm64 = "beetle-psx-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_PSX_CORES}"
