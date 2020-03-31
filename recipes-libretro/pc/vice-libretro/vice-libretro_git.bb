DESCRIPTION = "C64 emulator - port of VICE for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://vice/COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"

inherit libretro/core/git

DEPENDS += "flex-native bison-native"

LIBRETRO_GIT_REPO = "github.com/libretro/vice-libretro.git"
LIBRETRO_CORE = "vice_x64"

