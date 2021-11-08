DESCRIPTION = "Libretro extra cores package group"

inherit retro-packagegroup

LIBRETRO_EXTRA_CORE_PACKAGES ?= " \
    3dengine-libretro \
    bash-launcher-libretro \
    dinothawr-libretro \
    gme-libretro \
    mrboom-libretro \
    prboom-libretro \
    superflappybirds-libretro \
    tyrquake-libretro \
"

RDEPENDS:${PN} = "${LIBRETRO_EXTRA_CORE_PACKAGES}"
