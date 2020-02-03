DESCRIPTION = "BK-0010/0011/Terak 8510a emulator"

LICENSE = "BK"
LIC_FILES_CHKSUM = "file://README.md;md5=ad839e758049dc57d65f2ad8e69dc629"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/dev-0x7C6/bk-emulator.git;protocol=https"
SRCREV = "${AUTOREV}"

#TODO: upstream license fix: https://github.com/arcade-mini/bk-emulator/pull/3
#TODO: upstream compilation fix: https://github.com/arcade-mini/bk-emulator/pull/3

LIBRETRO_CORE = "bk"
