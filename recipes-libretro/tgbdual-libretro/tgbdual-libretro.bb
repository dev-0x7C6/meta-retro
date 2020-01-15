DESCRIPTION = "Gameboy Color emu - TGB Dual port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://docs/COPYING-2.0.txt;md5=cbbd794e2a0a289b9dfcc9f513d1996e"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/tgbdual-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "tgbdual"
