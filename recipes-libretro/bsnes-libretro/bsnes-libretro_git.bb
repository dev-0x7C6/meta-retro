SUMMARY = "Super Nintendo emulator"
DESCRIPTION = "Super Nintendo emulator - bsnes port for libretro"

LICENSE = "GPL-3.0 & ISC"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=fe114267df72c30b064ae55ca5242069"

inherit libretro

#LIBRETRO_CORE = "out/bsnes_libretro"
LIBRETRO_GIT_REPO = "github.com/libretro/bsnes-libretro.git"

#FIXME: upstream: didn't pass LDFLAGS? [ldflags]
# QA run found fatal errors. Please consider fixing them
# TARGET_CC_ARCH += "${LDFLAGS}"
