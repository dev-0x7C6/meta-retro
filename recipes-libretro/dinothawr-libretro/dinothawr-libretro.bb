DESCRIPTION = "Dinothawr - standalone libretro puzzle game"

LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b413578467594c7048cc4fddb4993bf9"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/Dinothawr.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "dinothawr"

