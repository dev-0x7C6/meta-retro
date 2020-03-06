DESCRIPTION = "PCEngine emu - Mednafen PCE Fast port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro-git

LIBRETRO_CORE = "mednafen_pce_fast"
LIBRETRO_GIT_REPO = "github.com/libretro/beetle-pce-fast-libretro.git"
