DESCRIPTION = "Atari emulator - Hatari port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://gpl.txt;md5=751419260aa954499f7abaabaa882bbe"

inherit libretro

LIBRETRO_CORE = "hatari"
LIBRETRO_GIT_REPO = "github.com/libretro/hatari.git"

# LTO fails with GCC 10.1
LIBRETRO_LTO_ENABLED ?= "0"