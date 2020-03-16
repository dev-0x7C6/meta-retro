DESCRIPTION = "Doom/Doom II engine - PrBoom port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=14aa9744482b9e7ee47eef837e04c26e"

inherit libretro/core/git

LIBRETRO_CORE = "prboom"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-prboom.git"
