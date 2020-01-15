DESCRIPTION = "MSX/MSX2/Colecovision emu - blueMSX port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://license.txt;md5=7e47935857eb320b159bf6ec4114c655"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/blueMSX-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "bluemsx"

