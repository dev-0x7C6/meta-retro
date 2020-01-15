DESCRIPTION = "Pokemon Mini emulator - PokeMini port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=65d7e3de6ed0d7bb08187100789e7221"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/pokemini.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "pokemini"

