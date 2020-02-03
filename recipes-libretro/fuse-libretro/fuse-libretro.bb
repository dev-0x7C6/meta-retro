DESCRIPTION = "ZX Spectrum emu - Fuse port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=784d7dc7357bd924e8d5642892bf1b6b"

inherit libretro-git

LIBRETRO_CORE = "fuse"
LIBRETRO_REPO = "github.com/libretro/fuse-libretro.git"
