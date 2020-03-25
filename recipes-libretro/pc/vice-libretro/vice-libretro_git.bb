DESCRIPTION = "C64 emulator - port of VICE for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://vice/COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"

DEPENDS += "flex-native bison-native"

inherit libretro/core/git

LIBRETRO_GIT_REPO = "github.com/libretro/vice-libretro.git"
LIBRETRO_CORE = "vice_x64"

