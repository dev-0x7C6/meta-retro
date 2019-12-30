LIBRETRO_CORE ??= ""

LIBRETRO_PLATFORM_AUTODETECT = "unix"
LIBRETRO_PLATFORM_AUTODETECT_raspberrypi4 = "rpi4"
LIBRETRO_PLATFORM_AUTODETECT_raspberrypi3 = "rpi3"
LIBRETRO_PLATFORM_AUTODETECT_raspberrypi2 = "rpi2"

LIBRETRO_PLATFORM ??= "${LIBRETRO_PLATFORM_AUTODETECT}"

FILES_${PN} += "${libdir}/libretro"

do_compile() {
  if [[ -f "Makefile.libretro" ]]; then
    oe_runmake -f Makefile.libretro platform="${LIBRETRO_PLATFORM}"
  else
    oe_runmake -f Makefile platform="${LIBRETRO_PLATFORM}"
  fi
}

do_install() {
  install -d ${D}${libdir}/libretro
  install -m 644 ${S}/${LIBRETRO_CORE}_libretro.so ${D}${libdir}/libretro/${LIBRETRO_CORE}_libretro.so
}
