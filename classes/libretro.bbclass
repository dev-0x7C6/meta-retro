LIBRETRO_CORE ??= ""

LIBRETRO_PLATFORM_raspberrypi4 ??= "rpi4"
LIBRETRO_PLATFORM_raspberrypi3 ??= "rpi3"
LIBRETRO_PLATFORM_raspberrypi2 ??= "rpi2"
LIBRETRO_PLATFORM ??= "unix"

FILES_${PN} += "${libdir}/libretro"

do_compile() {
  oe_runmake -f Makefile.libretro platform="${LIBRETRO_PLATFORM}"
}

do_install() {
  install -d ${D}${libdir}/libretro
  install -m 644 ${S}/${LIBRETRO_CORE} ${D}${libdir}/libretro/${LIBRETRO_CORE}
}
