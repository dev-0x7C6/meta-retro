DESCRIPTION = "Atari 8-bit/800/5200 emulator - Atari800 port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://atari800/COPYING;md5=eb723b61539feef013de476e68b5c50a"

inherit libretro/core/git

LIBRETRO_LTO_ENABLED = "0"

LIBRETRO_CORE = "atari800"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-atari800.git"
