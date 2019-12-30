LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/mupen64plus-libretro-nx.git;protocol=https"
S = "${WORKDIR}/git"

DEPENDS = "virtual/egl libpng"

LIBRETRO_CORE = "mupen64plus_next"
