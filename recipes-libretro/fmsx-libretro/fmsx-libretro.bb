DESCRIPTION = "MSX/MSX2 emu - fMSX port for libretro"

LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d953e2d1968065c02d63ff481dfee5d4"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/fmsx-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "fmsx"

