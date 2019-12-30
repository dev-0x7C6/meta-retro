LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=5dd99a4a14d516c44d0779c1e819f963"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/pcsx_rearmed;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "pcsx_rearmed_libretro.so"
