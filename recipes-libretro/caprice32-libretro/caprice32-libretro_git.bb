SUMMARY = "Amstrad CPC emulator"
DESCRIPTION = "Amstrad CPC emu - Caprice32 port for libretro"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://cap32/COPYING.txt;md5=8ca43cbc842c2336e835926c2166c28b"

inherit libretro

LIBRETRO_CORE = "cap32"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-cap32.git"
