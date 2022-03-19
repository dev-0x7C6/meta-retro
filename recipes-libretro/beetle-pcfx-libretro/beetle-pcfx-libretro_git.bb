SUMMARY = "PCFX emulator"
DESCRIPTION = "PCFX emulator - Mednafen PCFX Port for libretro"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

LIBRETRO_CORE = "mednafen_pcfx"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-pcfx-libretro"

LIBRETRO_EXTRA_MAKEFLAGS:append:armarch = " IS_X86=0"
