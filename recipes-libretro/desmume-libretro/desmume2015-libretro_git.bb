SUMMARY = "Nintendo DS emulator"
DESCRIPTION = "Nintendo DS emulator - DESMUME"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://desmume/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro

DEPENDS += "libpcap libglu"

LIBRETRO_MAKEFILE_PREFIX = "desmume"

LIBRETRO_PLATFORM_append_arm32 = "-armv"
LIBRETRO_PLATFORM_append_opengles = "-gles"

LIBRETRO_GIT_REPO = "github.com/libretro/desmume2015.git"
LIBRETRO_CORE = "desmume/desmume2015"

EXTRA_OEMAKE_append_64bit = " DESMUME_JIT=0"

# Maybe glvnd support that's comming in future will help
REQUIRED_DISTRO_FEATURES = "x11"
