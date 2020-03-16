DESCRIPTION = "NES emu - Nestopia (enhanced) port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=686e6cb566fd6382c9fcc7a557bf4544"

inherit libretro/core/git

LIBRETRO_MAKEFILE_PREFIX = "libretro/"

LIBRETRO_GIT_REPO = "github.com/libretro/nestopia.git"
LIBRETRO_CORE = "libretro/nestopia"

