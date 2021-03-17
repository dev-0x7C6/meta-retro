LICENSE = "MAME"
LIC_FILES_CHKSUM = "file://readme.md;md5=08244ad0cc4ba1c0458fd4c0f00b6b9e"

require mame.inc

LIBRETRO_GIT_REPO = "github.com/libretro/${BPN}.git"

LIBRETRO_EXTRA_MAKEFLAGS_append_armarch = " USE_CYCLONE=1 USE_DRZ80=1"
