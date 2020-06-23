DESCRIPTION = "Dinothawr - standalone libretro puzzle game"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit libretro/core/git

LIBRETRO_CORE = "gme"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-gme.git"
