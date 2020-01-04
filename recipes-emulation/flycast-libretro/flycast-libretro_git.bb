LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/flycast.git;protocol=https"
S = "${WORKDIR}/git"

DEPENDS = "virtual/egl libpng"

LIBRETRO_CORE = "flycast"

LIBRETRO_EXTRA_FLAGS_arm = " \
	HAVE_GENERIC_JIT=0 \
	PLATFORM_EXT=unix \
	WITH_DYNAREC=arm \
	ARM_FLOAT_ABI_HARD=1 \
	SINGLE_PREC_FLAGS=1 \
	THREADED_RENDERING_DEFAULT=1 \
	HAVE_VULKAN=0 \
"
