SUMMARY = "Nintendo DS emulator"
DESCRIPTION = "Nintendo DS emulator - DESMUME"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://desmume/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro
require desmume-common.inc

LIBRETRO_MAKEFILE_PREFIX = "desmume/src/frontend/libretro"

LIBRETRO_GIT_REPO = "github.com/libretro/desmume.git"
LIBRETRO_CORE = "desmume/src/frontend/libretro/desmume"
