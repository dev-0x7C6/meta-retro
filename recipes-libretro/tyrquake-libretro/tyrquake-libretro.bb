DESCRIPTION = "Quake 1 engine - Tyrquake port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://gnu.txt;md5=79c2cc4426b9e6f3b9098f02eb47aac1"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/tyrquake.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "tyrquake"

