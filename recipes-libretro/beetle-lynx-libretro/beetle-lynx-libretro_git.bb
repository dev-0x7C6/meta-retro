DESCRIPTION = "Atari Lynx emulator - Mednafen Lynx Port for libretro, itself a fork of Handy"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro-git

LIBRETRO_CORE = "mednafen_lynx"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-lynx-libretro.git"
