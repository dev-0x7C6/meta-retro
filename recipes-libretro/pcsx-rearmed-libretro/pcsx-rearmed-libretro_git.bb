LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r100"

inherit libretro-git

LIBRETRO_CORE = "pcsx_rearmed"
LIBRETRO_REPO = "github.com/libretro/pcsx_rearmed.git"

PREFFERED_DYNAMIC_RECOMPILER ?= "lightrec"
PREFFERED_DYNAMIC_RECOMPILER_armarch = "ari64"

LIBRETRO_EXTRA_MAKEFLAGS_append = " HAVE_CHD=0 DYNAREC=${PREFFERED_DYNAMIC_RECOMPILER}"
LIBRETRO_EXTRA_MAKEFLAGS_append_armarch = " ${@bb.utils.contains('TUNE_FEATURES', 'neon', 'BUILTIN_GPU=neon', 'BUILTIN_GPU=peops', d)}"