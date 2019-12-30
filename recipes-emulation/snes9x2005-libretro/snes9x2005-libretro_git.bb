LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://copyright;md5=027b5432fc7d5926db6b4514c8d49658"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/snes9x2005.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "snes9x2005"
LIBRETRO_PLATFORM = "unix"
