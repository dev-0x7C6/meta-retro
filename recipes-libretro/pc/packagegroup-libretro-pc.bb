DESCRIPTION = "Libretro PC cores"

inherit retro/packagegroup

LIBRETRO_PC_CORES ?= " \
  dosbox-libretro \
  quasi88-libretro \
  vice-libretro \
"

LIBRETRO_PC_CORES_remove_arm64 = "dosbox-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_PC_CORES}"
