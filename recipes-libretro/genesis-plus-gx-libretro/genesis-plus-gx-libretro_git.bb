LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro
inherit tune-blacklist

LIBRETRO_GIT_REPO = "github.com/libretro/Genesis-Plus-GX.git"

# Thumb instruction set is causing huge performance regression
TUNE_FEATURES_BLACKLIST = "thumb"
