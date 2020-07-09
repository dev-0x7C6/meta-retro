DESCRIPTION = "Libretro extra cores package group"

inherit retro-packagegroup

LIBRETRO_EXTRA_CORE_PACKAGES ?= " \
    2048-libretro \
    3dengine-libretro \
    dinothawr-libretro \
    gme-libretro \
    mrboom-libretro \
    prboom-libretro \
    superflappybirds-libretro \
    tyrquake-libretro \
"

RDEPENDS_${PN} = "${LIBRETRO_EXTRA_CORE_PACKAGES}"
