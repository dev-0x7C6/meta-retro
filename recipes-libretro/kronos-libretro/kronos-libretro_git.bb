DESCRIPTION = "Saturn & ST-V emulator - Kronos port for libretro"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://yabause/COPYING;md5=4b446a5a0b773c458f6a5b3288522b62"

inherit libretro

PR = "r2"

SRC_URI += "file://0001-Fixed-missing-GL_READ_WRITE-define.patch"
SRC_URI += "file://0002-Fixed-missing-GL_PIXEL_BUFFER_BARRIER_BIT-define.patch"

LIBRETRO_PLATFORM:arm32 = "armv-unix"
LIBRETRO_PLATFORM:arm64 = "arm64-unix"

LIBRETRO_MAKEFILE_PREFIX = "yabause/src/libretro"
LIBRETRO_CORE = "yabause/src/libretro/kronos"

LIBRETRO_GIT_REPO = "github.com/libretro/yabause.git"
LIBRETRO_GIT_BRANCH = "kronos"
