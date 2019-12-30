LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://Copying;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/libretro/libretro-fceumm.git;protocol=https"
S = "${WORKDIR}/git"

LIBRETRO_CORE = "fceumm"
LIBRETRO_PLATFORM = "unix"
