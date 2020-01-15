DESCRIPTION = "Gameboy Color emu - libgambatte port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/gambatte-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "gambatte"

