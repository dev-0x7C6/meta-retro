SUMMARY = "Sega Saturn emulator"
DESCRIPTION = "Sega Saturn emulator - Mednafen Saturn port for libretro"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

LIBRETRO_CORE = "mednafen_saturn_hw"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-saturn-libretro.git"

LIBRETRO_PLATFORM:append:opengles = "-gles"
LIBRETRO_EXTRA_MAKEFLAGS += "HAVE_CHD=1 HAVE_OPENGL=1"
LIBRETRO_EXTRA_MAKEFLAGS:append:armarch = " IS_X86=0"
