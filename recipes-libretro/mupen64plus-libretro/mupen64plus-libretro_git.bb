LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/mupen64plus-libretro-nx.git;protocol=https"
S = "${WORKDIR}/git"

DEPENDS = "virtual/egl libpng nasm-native"

LIBRETRO_CORE = "mupen64plus_next"

LIBRETRO_FULL_OVERRIDE_ASFLAGS_x86-64 = "1"
LIBRETRO_EXTRA_ASFLAGS_x86-64 = "-f elf64 -d ELF_TYPE"

LIBRETRO_REPRESENT_AARCH64_AS = "aarch64"