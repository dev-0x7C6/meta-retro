DESCRIPTION = "N64 emulator - Mupen64Plus + GLideN64 for libretro (next version)"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro-core-git

LIBRETRO_CORE_PATCHES_raspberrypi4 = "file://mupen64plus_next-rpi4-gles3-fix.patch"
LIBRETRO_CORE_PATCHES_raspberrypi4-64 = "file://mupen64plus_next-rpi4-gles3-fix.patch"

LIBRETRO_OPTIMIZATION_CXXFLAGS = ""
LIBRETRO_OPTIMIZATION_CFLAGS = ""

DEPENDS += "libpng"
DEPENDS_append_x86arch = " nasm-native"

LIBRETRO_CORE = "mupen64plus_next"
LIBRETRO_GIT_REPO = "github.com/libretro/mupen64plus-libretro-nx.git"
LIBRETRO_GIT_BRANCH = "develop"

LIBRETRO_MAKEFILE_FORCE_GLES_gles3 = "FORCE_GLES=0"

USE_MESA = "1"
USE_MESA_rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '1', '0', d)}"

LIBRETRO_EXTRA_MAKEFLAGS_append = " MESA=${USE_MESA}"
LIBRETRO_EXTRA_MAKEFLAGS_append_gles3 = " GLES3=1"

#LIBRETRO_FULL_OVERRIDE_ASFLAGS_x86-64 = "1"
#LIBRETRO_EXTRA_ASFLAGS_x86-64 = "-f elf64 -d ELF_TYPE"
