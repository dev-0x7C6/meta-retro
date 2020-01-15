DESCRIPTION = "Mr.Boom - 8 players Bomberman clone for libretro."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7d8cb796ca7b5ac0cdb18c3e2749d97"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/mrboom-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "mrboom"

