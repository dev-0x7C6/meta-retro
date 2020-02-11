LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro-git

DEPENDS += "libpng"

LIBRETRO_CORE = "flycast"
LIBRETRO_REPO = "github.com/libretro/flycast.git"
SRCREV = "0ef6827486d8d873b81b2bf0890464890c8b3aa0"

LIBRETRO_REPRESENT_ARM64 = "arm64"

LIBRETRO_PLATFORM_arm32 = "classic_armv7_a7"
LIBRETRO_PLATFORM_arm64 = "arm64"

# Flycast overrides passed LDFLAGS and have special LDFLAGS_END to append them if needed
LIBRETRO_EXTRA_MAKEFLAGS = " \
    CC_PREFIX="${TARGET_PREFIX}" \
    LDFLAGS_END="${LDFLAGS}" \
"
