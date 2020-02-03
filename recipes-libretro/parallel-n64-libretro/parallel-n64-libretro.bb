DESCRIPTION = "N64 emu - Highly modified Mupen64Plus port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://mupen64plus-core/LICENSES;md5=6bf42b6befd3315498f337409d7f83c2"

inherit libretro-git

LIBRETRO_CORE = "parallel_n64"
LIBRETRO_REPO = "github.com/libretro/parallel-n64.git"
SRCREV = "ab155da18068f638e5ace2e5e6f7387bddc3511b"

LIBRETRO_EXTRA_COMPILATION_FLAGS_armarch = " -DARM -DARM_ASM -D__NEON_OPT -DNOSSE"

do_patch_append_opengles() {
  sed -i -e "/^typedef GLfloat GLdouble/d" "${S}/libretro-common/include/glsm/glsm.h"
}
