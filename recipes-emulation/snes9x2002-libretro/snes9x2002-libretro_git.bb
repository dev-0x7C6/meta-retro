LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://README.txt;md5=04df038c61013590a2177f5636154a1f"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/snes9x2002.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "snes9x2002"
LIBRETRO_PLATFORM = "unix"
