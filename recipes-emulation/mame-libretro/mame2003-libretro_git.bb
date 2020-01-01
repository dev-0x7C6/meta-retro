LICENSE = "MAME"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f96fca765ae6aef7102780c26c625cc4"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/${BPN}.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "mame2003"
LIBRETRO_PLATFORM = "unix"
