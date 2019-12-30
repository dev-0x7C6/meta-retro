LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE.txt;md5=82f2245ecff2ebb94c72bbce5002e25c"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/snes9x2010.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "snes9x2010"
