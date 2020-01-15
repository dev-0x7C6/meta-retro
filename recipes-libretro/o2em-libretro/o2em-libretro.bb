DESCRIPTION = "Odyssey 2 / Videopac emu - O2EM port for libretro"

LICENSE = "CLOSED"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/libretro-o2em;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "o2em"
