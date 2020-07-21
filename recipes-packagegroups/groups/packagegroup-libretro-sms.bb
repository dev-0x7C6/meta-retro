DESCRIPTION = "Libretro Sega Master System"

inherit retro-packagegroup

LIBRETRO_SMS_CORES ?= " \
  gearsystem-libretro \
"

RRECOMMENDS_${PN} = "${LIBRETRO_SMS_CORES}"
