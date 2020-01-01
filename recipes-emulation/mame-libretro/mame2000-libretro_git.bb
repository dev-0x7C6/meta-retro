LICENSE = "MAME"
LIC_FILES_CHKSUM = "file://readme.md;md5=08244ad0cc4ba1c0458fd4c0f00b6b9e"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/${BPN}.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "mame2000"
LIBRETRO_PLATFORM = "unix"
