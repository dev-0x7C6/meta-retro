DESCRIPTION = "Libretro port of X Millennium Sharp X1 emulator"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5098a370a52934362ba8889458c5fc7a"

inherit libretro

LIBRETRO_MAKEFILE_PREFIX = "libretro"
LIBRETRO_CORE = "libretro/x1"

LIBRETRO_GIT_REPO = "github.com/libretro/xmil-libretro.git"