DESCRIPTION = "Atari emulator - Hatari port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://gpl.txt;md5=751419260aa954499f7abaabaa882bbe"

inherit libretro

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/hatari.git;protocol=https"
SRCREV = "${AUTOREV}"

LIBRETRO_CORE = "hatari"

