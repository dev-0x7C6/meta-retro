DESCRIPTION = "Libretro extra cores package group"

inherit retro-packagegroup

LIBRETRO_EXTRA_CORE_PACKAGES ?= " \
  dinothawr-libretro \
  mrboom-libretro \
  prboom-libretro \
  superflappybirds-libretro \
  tyrquake-libretro \
"

RDEPENDS_${PN} = "${LIBRETRO_EXTRA_CORE_PACKAGES}"
