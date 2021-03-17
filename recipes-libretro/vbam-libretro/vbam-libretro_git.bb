DESCRIPTION = "Visual Boy Advance - A fork of VBA-M with libretro integration"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://doc/License.txt;md5=ad8ac3e11cc39f83fcaa6cd492075985"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/vbam-libretro.git"

LIBRETRO_MAKEFILE_PREFIX = "src/libretro"
LIBRETRO_CORE = "src/libretro/vbam"
