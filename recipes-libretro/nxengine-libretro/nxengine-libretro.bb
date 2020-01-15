DESCRIPTION = "Cave Story engine clone - NxEngine port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://nxengine/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/nxengine-libretro.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "nxengine"
