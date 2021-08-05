DESCRIPTION = "N64 emu - Highly modified Mupen64Plus port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://mupen64plus-core/LICENSES;md5=6bf42b6befd3315498f337409d7f83c2"

inherit libretro

DEPENDS += "bc-native"

LIBRETRO_GIT_REPO = "github.com/libretro/parallel-n64.git"

LIBRETRO_PLATFORM:append:arm32 = "-classic_armv7_a7"
LIBRETRO_PLATFORM:append:arm64 = "-armv8"
LIBRETRO_PLATFORM:append:opengles = "-gles"

LIBRETRO_EXTRA_MAKEFLAGS:armarch = "USE_SSE2NEON=1"
