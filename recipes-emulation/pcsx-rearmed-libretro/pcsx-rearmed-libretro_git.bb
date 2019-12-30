LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=5dd99a4a14d516c44d0779c1e819f963"

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/pcsx_rearmed;protocol=https"
S = "${WORKDIR}/git"

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
  install -m 644 ${S}/pcsx_rearmed_libretro.so ${D}${libdir}/libretro/pcsx_rearmed_libretro.so
}
