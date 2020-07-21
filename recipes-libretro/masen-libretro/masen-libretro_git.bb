DESCRIPTION = "High-accuracy NES and Famicom emulator"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/SourMesen/Mesen.git"

LIBRETRO_MAKEFILE_PREFIX = "Libretro"
LIBRETRO_CORE = "Libretro/mesen"