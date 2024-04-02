SUMMARY = "Sega Mega Drive / Genesis emulator"
DESCRIPTION = "Sega Mega Drive / Genesis emulator - Genesis-Plus-GX"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=eb39740e4fefb2dca99a700b7afdc3a8"

inherit libretro
inherit tune-blacklist

LIBRETRO_GIT_REPO = "github.com/libretro/Genesis-Plus-GX.git"

# Thumb instruction set is causing huge performance regression
TUNE_FEATURES_BLACKLIST = "thumb"
