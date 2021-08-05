DESCRIPTION = "Libretro Sega Saturn cores"

inherit retro-packagegroup

LIBRETRO_SATURN_CORES ?= " \
    beetle-saturn-libretro \
    kronos-libretro \
    yabause-libretro \
"

LIBRETRO_SATURN_CORES:remove:arm64 = "kronos-libretro yabause-libretro"

RRECOMMENDS:${PN} = "${LIBRETRO_SATURN_CORES}"
