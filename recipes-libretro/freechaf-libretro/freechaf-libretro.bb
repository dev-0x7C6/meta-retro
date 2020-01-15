DESCRIPTION = "ChannelF emulator for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2f5b803c8170f71ee6bf8ed95ce49be9"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/FreeChaF.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "freechaf"

