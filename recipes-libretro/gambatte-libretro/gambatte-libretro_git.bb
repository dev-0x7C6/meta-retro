DESCRIPTION = "Gameboy Color emu - libgambatte port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

inherit libretro-core-git

LIBRETRO_CORE = "gambatte"
LIBRETRO_GIT_REPO = "github.com/libretro/gambatte-libretro.git"
