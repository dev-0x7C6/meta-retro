DESCRIPTION = "N64 emulator - Mupen64Plus + GLideN64 for libretro (next version)"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/mupen64plus-libretro-nx.git;protocol=https;branch=develop"
S = "${WORKDIR}/git"

DEPENDS_append = " libpng nasm-native"

LIBRETRO_CORE = "mupen64plus_next"

LIBRETRO_EXTRA_MAKEFLAGS_append_rpi = " MESA=${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '1', '0', d)}"
LIBRETRO_PLATFORM_rpi = "${LIBRETRO_PLATFORM_AUTODETECT}"

LIBRETRO_FULL_OVERRIDE_ASFLAGS_x86-64 = "1"
LIBRETRO_EXTRA_ASFLAGS_x86-64 = "-f elf64 -d ELF_TYPE"
LIBRETRO_REPRESENT_AARCH64_AS = "aarch64"
