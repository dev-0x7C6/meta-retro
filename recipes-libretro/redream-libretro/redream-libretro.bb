DESCRIPTION = "Dreamcast emulator - redream port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro-git

LIBRETRO_MAKEFILE_PREFIX = "deps/libretro"

LIBRETRO_CORE = "deps/libretro/redream"
LIBRETRO_GIT_REPO = "github.com/libretro/redream.git"
