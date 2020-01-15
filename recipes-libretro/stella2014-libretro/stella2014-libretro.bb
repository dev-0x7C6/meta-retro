DESCRIPTION = "Atari 2600 emulator - Stella port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://stella/license.txt;md5=435d4178fd08b25f9cf911f1c3a0ce1d"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/stella2014-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "stella2014"
