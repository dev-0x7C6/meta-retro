DESCRIPTION = "3DO emu - 4DO/libfreedo port for libretro"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

inherit libretro-git

LIBRETRO_CORE = "opera"
LIBRETRO_REPO = "github.com/libretro/opera-libretro.git"

#FIXME: upstream: CC and AR is overriden and --sysroot flag is lost
LIBRETRO_EXTRA_MAKEFLAGS_append = " "CC=${CC}" "AR=${AR}""
