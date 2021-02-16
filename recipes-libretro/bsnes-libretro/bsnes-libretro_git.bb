SUMMARY = "Super Nintendo emulator"
DESCRIPTION = "Super Nintendo emulator - bsnes port for libretro"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=84a5ab0137615a43b50948e40c5881ae"

inherit libretro

LIBRETRO_CORE = "out/bsnes_accuracy"
LIBRETRO_GIT_REPO = "github.com/libretro/bsnes-libretro.git"

#FIXME: upstream: didn't pass LDFLAGS? [ldflags]
# QA run found fatal errors. Please consider fixing them
TARGET_CC_ARCH += "${LDFLAGS}"
