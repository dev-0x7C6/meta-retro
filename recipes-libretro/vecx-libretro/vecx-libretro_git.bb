DESCRIPTION = "Vectrex emulator - vecx port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86be7c1121127c4ab250ab6043117e46"

inherit libretro

LIBRETRO_EXTRA_MAKEFLAGS_opengles = "GLES=1 GL_LIB=-lGLESv2 HAS_GLES=1 HAS_GPU=1"

LIBRETRO_GIT_REPO = "github.com/libretro/libretro-vecx.git"
