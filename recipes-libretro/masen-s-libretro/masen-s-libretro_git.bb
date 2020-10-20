DESCRIPTION = "Mesen-S is a cross-platform SNES emulator for Windows & Linux built in C++."

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/Mesen-S"

LIBRETRO_MAKEFILE_PREFIX = "Libretro"
LIBRETRO_CORE = "Libretro/mesen-s"