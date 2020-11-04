DESCRIPTION = "P-UAE Amiga emulator port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/libretro-uae.git"

SECURITY_STRINGFORMAT = ""
INSANE_SKIP_${PN} += "already-stripped"

