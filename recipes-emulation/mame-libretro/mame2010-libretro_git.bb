LICENSE = "MAME"
LIC_FILES_CHKSUM = "file://README.md;md5=a9c48e15fed578c670fd8e2d8d601b05"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/${BPN}.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "mame2010"
LIBRETRO_PLATFORM_AUTODETECT_RPI4 = "${LIBRETRO_PLATFORM_AUTODETECT_RPI3}"
