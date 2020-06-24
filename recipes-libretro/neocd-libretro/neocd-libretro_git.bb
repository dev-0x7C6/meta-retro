DESCRIPTION = "Neo Geo CD emulator for libretro"

LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f839e273ca0906304c90b406662bf17a"

inherit libretro-core-git

LIBRETRO_CORE = "neocd"
LIBRETRO_GIT_REPO = "github.com/libretro/neocd_libretro.git"
