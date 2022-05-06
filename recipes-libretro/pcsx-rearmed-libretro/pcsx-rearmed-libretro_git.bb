SUMMARY = "Sony PlayStation emulator"
DESCRIPTION = "Sony PlayStation emulator - pcsx-rearmed"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=5dd99a4a14d516c44d0779c1e819f963"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/pcsx_rearmed.git"

PREFFERED_DYNAMIC_RECOMPILER ?= "lightrec"
PREFFERED_DYNAMIC_RECOMPILER:armarch = "ari64"

PREFFERED_BUILTIN_GPU ?= "${@bb.utils.contains('TUNE_FEATURES', 'neon', 'neon', 'peops', d)}"
PREFFERED_BUILTIN_GPU:arm64 = "unai"

PCSX_THREAD_RENDERING ?= "1"
PCSX_THREAD_RENDERING:arm = "0"


LIBRETRO_COMMON_FLAGS = "-fPIC -shared"

LIBRETRO_EXTRA_MAKEFLAGS += " \
	BUILTIN_GPU=${PREFFERED_BUILTIN_GPU} \
	DYNAREC=${PREFFERED_DYNAMIC_RECOMPILER} \
	THREAD_RENDERING=${PCSX_THREAD_RENDERING} \
"
