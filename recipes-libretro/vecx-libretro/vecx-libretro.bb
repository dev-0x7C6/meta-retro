DESCRIPTION = "Vectrex emulator - vecx port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86be7c1121127c4ab250ab6043117e46"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/libretro-vecx.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "vecx"

