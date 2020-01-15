DESCRIPTION = "Doom/Doom II engine - PrBoom port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=14aa9744482b9e7ee47eef837e04c26e"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/libretro-prboom.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "prboom"

