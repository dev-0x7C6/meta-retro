DESCRIPTION = "NES emulator - QuickNES Port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/QuickNES_Core.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "quicknes"

