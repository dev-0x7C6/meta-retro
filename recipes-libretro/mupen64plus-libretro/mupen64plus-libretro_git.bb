SUMMARY = "Nintendo 64 emulator"
DESCRIPTION = "Nintendo 64 emulator - Mupen64Plus + GLideN64 for libretro"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro

LIBRETRO_CORE_PATCHES:raspberrypi4 = "file://mupen64plus_next-rpi4-gles3-fix.patch"
LIBRETRO_CORE_PATCHES:raspberrypi4-64 = "file://mupen64plus_next-rpi4-gles3-fix.patch"

DEPENDS += "libpng"
DEPENDS:append:x86arch = " nasm-native"

LIBRETRO_CORE = "mupen64plus_next"
LIBRETRO_GIT_REPO = "github.com/libretro/mupen64plus-libretro-nx.git"
LIBRETRO_GIT_BRANCH = "develop"

LIBRETRO_MAKEFILE_FORCE_GLES:gles3 = "FORCE_GLES=0"

USE_MESA = "1"
USE_MESA:rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '1', '0', d)}"

LIBRETRO_EXTRA_MAKEFLAGS:append = " MESA=${USE_MESA}"
LIBRETRO_EXTRA_MAKEFLAGS:append:gles3 = " GLES3=1"
