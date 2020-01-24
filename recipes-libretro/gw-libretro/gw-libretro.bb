DESCRIPTION = "Game and Watch simulator"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=04e3156d1bba43f54e5930e75a5271aa"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/gw-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "gw"
