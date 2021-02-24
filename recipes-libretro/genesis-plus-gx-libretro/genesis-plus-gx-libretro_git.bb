SUMMARY = "Sega Mega Drive / Genesis emulator"
DESCRIPTION = "Sega Mega Drive / Genesis emulator - Genesis-Plus-GX"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b1a7fd51d37f7b7ac0052c1eb94ac3f1"

inherit libretro
inherit tune-blacklist

LIBRETRO_GIT_REPO = "github.com/libretro/Genesis-Plus-GX.git"

# Thumb instruction set is causing huge performance regression
TUNE_FEATURES_BLACKLIST = "thumb"
