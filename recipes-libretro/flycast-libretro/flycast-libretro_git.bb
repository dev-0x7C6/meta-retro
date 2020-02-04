LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro-git

DEPENDS += "libpng"

LIBRETRO_CORE = "flycast"
LIBRETRO_REPO = "github.com/dev-0x7C6/flycast.git"

LIBRETRO_REPRESENT_ARM64 = "arm64"

LIBRETRO_PLATFORM_arm32 = "classic_armv7_a7"
LIBRETRO_PLATFORM_arm64 = "arm64"
