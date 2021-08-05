DESCRIPTION = "Libretro Sega Master System"

inherit retro-packagegroup

LIBRETRO_SMS_CORES ?= " \
  gearsystem-libretro \
  smsplus-gx-libretro \
"

RRECOMMENDS:${PN} = "${LIBRETRO_SMS_CORES}"
