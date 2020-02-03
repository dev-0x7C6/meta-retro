LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r100"

inherit libretro-git

LIBRETRO_CORE = "pcsx_rearmed"
LIBRETRO_REPO = "github.com/libretro/pcsx_rearmed.git"

LIBRETRO_EXTRA_MAKEFLAGS_append = " HAVE_CHD=0"
LIBRETRO_EXTRA_MAKEFLAGS_append_arm32 = " ${@bb.utils.contains('TUNE_FEATURES', 'neon', 'BUILTIN_GPU=neon', 'BUILTIN_GPU=peops', d)} USE_DYNAREC=1"
LIBRETRO_EXTRA_MAKEFLAGS_append_arm64 = " BUILTIN_GPU=peops USE_DYNAREC=0"
