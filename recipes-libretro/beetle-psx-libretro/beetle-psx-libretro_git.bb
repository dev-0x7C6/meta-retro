DESCRIPTION = "PSX emulator - Mednafen PSX Port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro-git

LIBRETRO_CORE = "mednafen_psx_hw"
LIBRETRO_REPO = "github.com/libretro/beetle-psx-libretro.git"

LIBRETRO_PLATFORM_opengles = "unix-gles"
LIBRETRO_EXTRA_MAKEFLAGS_append = " HAVE_CHD=1 HAVE_LIGHTREC=1 HAVE_OPENGL=1"

do_patch_append_opengles() {
  sed -i -e "/^typedef GLfloat GLdouble/d" "${S}/libretro-common/include/glsm/glsm.h"
}
