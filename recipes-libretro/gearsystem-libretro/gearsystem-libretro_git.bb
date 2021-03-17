DESCRIPTION = "Sega 8 bit emu - Gearsystem port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/drhelius/Gearsystem.git"

LIBRETRO_MAKEFILE_PREFIX = "platforms/libretro"
LIBRETRO_CORE = "platforms/libretro/gearsystem"
