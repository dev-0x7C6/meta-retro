SUMMARY = "Native Dolphin emulator launcher"
DESCRIPTION = "Launch native Dolphin from RetroArch/libretro"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=9fb2db49998f52308b904afb2fa8ebfc"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/RobLoach/libretro-dolphin-launcher.git"
LIBRETRO_INFO_FILE = "dolphin_launcher_libretro.info"

RRECOMMENDS:${PN} += "dolphin-emu"
