DESCRIPTION = "3D Engine for libretro GL with additional features (camera/location/etc). Should be compatible from libretro 3D/GLES 2.0 and up."

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://license;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro

LIBRETRO_PLATFORM_append_opengles = "-gles"

LIBRETRO_EXTRA_MAKEFLAGS = "GL_LIB=-lGLESv2"
TARGET_CFLAGS += "-DHAVE_OPENGLES2"

LIBRETRO_GIT_REPO = "github.com/libretro/libretro-3dengine.git"
