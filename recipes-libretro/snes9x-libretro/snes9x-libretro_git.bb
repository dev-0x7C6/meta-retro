DESCRIPTION = "Snes9x - Portable Super Nintendo Entertainment System (TM) emulator."

LICENSE = "SNES9X"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1b05960bb22bba725eff645eabda6458"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/snes9x.git"

LIBRETRO_MAKEFILE_PREFIX = "libretro/"
LIBRETRO_CORE = "libretro/snes9x"
