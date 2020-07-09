DESCRIPTION = "ZX Spectrum emu - Fuse port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=784d7dc7357bd924e8d5642892bf1b6b"

inherit libretro

LIBRETRO_LTO_ENABLED_arm64 ?= "0"

LIBRETRO_GIT_REPO = "github.com/libretro/fuse-libretro.git"
