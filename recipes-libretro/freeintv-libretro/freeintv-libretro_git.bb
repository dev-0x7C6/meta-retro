DESCRIPTION = "Intellivision emulator for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=80cf7e863beef0254d0b1d87589d16cf"

inherit libretro-core-git

LIBRETRO_CORE = "freeintv"
LIBRETRO_GIT_REPO = "github.com/libretro/FreeIntv.git"
