SUMMARY = "Nintendo DS emulator"
DESCRIPTION = "Nintendo DS emulator - DESMUME"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://desmume/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro

DEPENDS += "libpcap libglu"

LIBRETRO_MAKEFILE_PREFIX = "desmume/src/frontend/libretro"

LIBRETRO_PLATFORM_append_arm32 = "-armv"
LIBRETRO_PLATFORM_append_opengles = "-gles"

LIBRETRO_GIT_REPO = "github.com/libretro/desmume.git"
LIBRETRO_CORE = "desmume/src/frontend/libretro/desmume"

# Unable to compile on 64-bit platforms
COMPATIBLE_MACHINE = "(32bit)"

# Maybe glvnd support that's comming in future will help
REQUIRED_DISTRO_FEATURES = "x11"
