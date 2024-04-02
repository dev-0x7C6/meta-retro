DESCRIPTION = "Libretro Arcade cores"

inherit retro-packagegroup

LIBRETRO_ARCADE_CORES ?= " \
  fbalpha2012-cps1-libretro \
  fbalpha2012-cps2-libretro \
  fbalpha2012-libretro \
  fbalpha2012-neogeo-libretro \
  fbneo-libretro \
  mame2000-libretro \
  mame2003-libretro \
  mame2003-plus-libretro \
  mame2010-libretro \
"

LIBRETRO_ARCADE_CORES:remove:arm32 = "mame2010-libretro mame2016-libretro mame-libretro"
LIBRETRO_ARCADE_CORES:remove:arm64 = "mame2000-libretro mame2010-libretro mame2016-libretro mame-libretro"
LIBRETRO_ARCADE_CORES:remove:x86 = "mame2016-libretro mame2010-libretro"

LIBRETRO_ARCADE_CORES:remove:python2-deprecated = "mame-libretro mame2016-libretro"

RRECOMMENDS:${PN} = "${LIBRETRO_ARCADE_CORES}"
