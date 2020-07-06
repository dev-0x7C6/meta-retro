DESCRIPTION = "NES emulator - QuickNES Port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro

LIBRETRO_CORE = "quicknes"
LIBRETRO_GIT_REPO = "github.com/libretro/QuickNES_Core.git"
