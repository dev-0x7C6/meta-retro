DESCRIPTION = "Libretro Sega Saturn cores"

inherit retro/packagegroup

LIBRETRO_SATURN_CORES ?= " \
    beetle-saturn-libretro \
    yabause-libretro \
"

LIBRETRO_SATURN_CORES_remove_arm64 = "yabause-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_SATURN_CORES}"
