SUMMARY = "Nintendo Virtual Boy emulator"
DESCRIPTION = "Virtual Boy emulator - Mednafen VB (optimised) port for libretro"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

LIBRETRO_CORE = "mednafen_vb"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-vb-libretro.git"
