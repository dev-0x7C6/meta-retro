DESCRIPTION = "3DO emu - 4DO/libfreedo port for libretro"

LICENSE = "GPL-2.0-or-later & LGPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
	file://${RETRO_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c \
	file://${RETRO_LICENSE_DIR}/LGPL-2.0-or-later;md5=6d2d9952d88b50a51a5c73dc431d06c7 \
"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/opera-libretro.git"

#FIXME: upstream: CC and AR is overriden and --sysroot flag is lost
LIBRETRO_EXTRA_MAKEFLAGS:append = " "CC=${CC}" "AR=${AR}""
