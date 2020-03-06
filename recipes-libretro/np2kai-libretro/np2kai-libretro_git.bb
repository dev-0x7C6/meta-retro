DESCRIPTION = "PC98 emu - Modified Neko Project II port for libretro"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3367bdf04085d84733e8a785a9746f02"

inherit libretro-git

LIBRETRO_CORE = "sdl2/np2kai"
LIBRETRO_GIT_REPO = "github.com/AZO234/NP2kai.git"

LIBRETRO_MAKEFILE_PREFIX = "sdl2"
