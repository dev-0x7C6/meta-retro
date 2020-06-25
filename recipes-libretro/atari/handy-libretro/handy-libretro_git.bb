DESCRIPTION = "Atari Lynx emulator - Handy port for libretro"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://lynx/license.txt;md5=79e740318fa817fd77c119393656df93"

inherit libretro-core-git

LIBRETRO_GIT_REPO = "github.com/libretro/libretro-handy.git"
LIBRETRO_CORE = "handy"

