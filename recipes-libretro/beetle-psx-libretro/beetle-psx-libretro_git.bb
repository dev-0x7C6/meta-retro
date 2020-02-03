DESCRIPTION = "PSX emulator - Mednafen PSX Port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro-git

LIBRETRO_CORE = "mednafen_psx_hw"
LIBRETRO_REPO = "github.com/libretro/beetle-psx-libretro.git"

#FIXME
LIBRETRO_EXTRA_MAKEFLAGS_append = " GLES=0 GL_LIB=-lGL"
