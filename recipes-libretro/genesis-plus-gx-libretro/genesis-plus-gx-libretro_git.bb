LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/Genesis-Plus-GX.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "genesis_plus_gx"
LIBRETRO_PLATFORM_AUTODETECT_RPI4 = "${LIBRETRO_PLATFORM_AUTODETECT_RPI3}"
