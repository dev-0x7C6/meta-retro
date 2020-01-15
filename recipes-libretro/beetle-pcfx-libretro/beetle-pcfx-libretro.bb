DESCRIPTION = "PCFX emulator - Mednafen PCFX Port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/beetle-pcfx-libretro;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "mednafen_pcfx"

