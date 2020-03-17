DESCRIPTION = "Standalone port of Mednafen GBA to libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro/core/git

LIBRETRO_CORE = "mednafen_gba"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-gba-libretro.git"

LIBRETRO_PLATFORM = "unix"
LIBRETRO_PLATFORM_AUTODETECT_RPI1 = "unix"
