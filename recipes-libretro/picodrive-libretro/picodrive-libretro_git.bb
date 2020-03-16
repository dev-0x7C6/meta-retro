DESCRIPTION = "Sega 8/16 bit emu - picodrive arm optimised libretro core"

LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=4613340462793d879916d43aa44d4236"

inherit libretro/core

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/picodrive.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "picodrive"

