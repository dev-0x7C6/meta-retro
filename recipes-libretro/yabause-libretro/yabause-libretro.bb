DESCRIPTION = "Sega Saturn emu - Yabause (optimised) port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://yabause/COPYING;md5=4b446a5a0b773c458f6a5b3288522b62"

inherit libretro-git

LIBRETRO_PLATFORM_arm32 = "armv,unix"
LIBRETRO_PLATFORM_arm64 = "arm64,unix"

LIBRETRO_MAKEFILE_PREFIX = "yabause/src/libretro"
LIBRETRO_CORE = "yabause/src/libretro/yabause"
LIBRETRO_REPO = "github.com/libretro/yabause.git"
