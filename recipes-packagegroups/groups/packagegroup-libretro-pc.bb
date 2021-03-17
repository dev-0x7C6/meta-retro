DESCRIPTION = "Libretro PC cores"

inherit retro-packagegroup

LIBRETRO_PC_CORES ?= " \
  bk-libretro \
  bluemsx-libretro \
  dosbox-libretro \
  dosbox-pure-libretro \
  fmsx-libretro \
  quasi88-libretro \
  theodore-libretro \
  vice-libretro \
  vice-x128-libretro \
  vice-x64sc-libretro \
  vice-xcbm2-libretro \
  vice-xcbm5x0-libretro \
  vice-xpet-libretro \
  vice-xplus4-libretro \
  vice-xscpu64-libretro \
  vice-xvic-libretro \
"

LIBRETRO_PC_CORES_remove_arm64 = "dosbox-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_PC_CORES}"
