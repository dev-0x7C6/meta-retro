DESCRIPTION = "Wonderswan emu - Mednafen WonderSwan core port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro-git

LIBRETRO_CORE = "mednafen_wswan"
LIBRETRO_REPO = "github.com/libretro/beetle-wswan-libretro.git"
