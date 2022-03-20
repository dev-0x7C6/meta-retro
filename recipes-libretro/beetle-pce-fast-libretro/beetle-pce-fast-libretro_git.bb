SUMMARY = "PC-Engine emulator"
DESCRIPTION = "PCEngine emu - Mednafen PCE Fast port for libretro"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

LIBRETRO_CORE = "mednafen_pce_fast"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-pce-fast-libretro.git"
