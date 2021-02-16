SUMMARY = "Nintendo Gameboy Advance emulator"
DESCRIPTION = "Standalone port of Mednafen GBA to libretro"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

LIBRETRO_CORE = "mednafen_gba"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-gba-libretro.git"
