SUMMARY = "Sony PlayStation emulator"
DESCRIPTION = "PSX emulator - Mednafen PSX Port for libretro"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=801f80980d171dd6425610833a22dbe6"

inherit libretro

LIBRETRO_CORE = "mednafen_psx_hw"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-psx-libretro.git"

LIBRETRO_PLATFORM_append_opengles = "-gles"
LIBRETRO_EXTRA_MAKEFLAGS_append = " HAVE_HW=1 HAVE_CHD=1 HAVE_LIGHTREC=1"
