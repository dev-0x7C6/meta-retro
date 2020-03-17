LICENSE = "MAME"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f96fca765ae6aef7102780c26c625cc4"

inherit libretro/core/git

LIBRETRO_CORE = "mame2003"
LIBRETRO_GIT_REPO = "github.com/libretro/${BPN}.git"
