DESCRIPTION = "N64 emu - Highly modified Mupen64Plus port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://mupen64plus-core/LICENSES;md5=6bf42b6befd3315498f337409d7f83c2"

inherit libretro-core-git

DEPENDS += "bc-native"

LIBRETRO_LTO_ENABLED ?= "0"

LIBRETRO_CORE = "parallel_n64"
LIBRETRO_GIT_REPO = "github.com/libretro/parallel-n64.git"

LIBRETRO_PLATFORM_arm32 = "unix,classic_armv7_a7"
LIBRETRO_PLATFORM_arm64 = "unix,armv8"
LIBRETRO_EXTRA_MAKEFLAGS_armarch = "USE_SSE2NEON=1"

do_patch_append_opengles() {
  sed -i -e "/^typedef GLfloat GLdouble/d" "${S}/libretro-common/include/glsm/glsm.h"
}
