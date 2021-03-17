DESCRIPTION = "Neko Project 2 (PC98 emulator) port for libretro/RetroArch"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3367bdf04085d84733e8a785a9746f02"

inherit libretro

LIBRETRO_CORE = "libretro/nekop2"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-meowPC98.git"

LIBRETRO_MAKEFILE_PREFIX = "libretro"
