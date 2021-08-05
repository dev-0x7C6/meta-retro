DESCRIPTION = "P-UAE Amiga emulator port for libretro"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/libretro-uae.git"

SECURITY_STRINGFORMAT = ""
INSANE_SKIP:${PN} += "already-stripped"

