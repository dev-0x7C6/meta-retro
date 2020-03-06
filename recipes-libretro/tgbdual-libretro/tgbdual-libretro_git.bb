DESCRIPTION = "Gameboy Color emu - TGB Dual port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://docs/COPYING-2.0.txt;md5=cbbd794e2a0a289b9dfcc9f513d1996e"

inherit libretro-git

LIBRETRO_CORE = "tgbdual"
LIBRETRO_GIT_REPO = "github.com/libretro/tgbdual-libretro.git"
