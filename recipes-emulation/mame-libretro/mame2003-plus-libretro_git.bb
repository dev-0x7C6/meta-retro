LICENSE = "MAME"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=fe039f42ebf8b0b7bc62b8260961295f"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/${BPN}.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "mame2003_plus"
LIBRETRO_PLATFORM = "unix"
