DESCRIPTION = "PCSX2 - The Playstation 2 Emulator."

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro-cmake python3native

LIBRETRO_GIT_REPO = "github.com/aliaspider/pcsx2"
DEPENDS += "glib-2.0 alsa-lib libpng"

PACKAGECONFIG ?=  "libretro"

PACKAGECONFIG[libretro] = "-DLIBRETRO=ON,-DLIBRETRO=OFF"

# TODO: x11-xcb (with opengl acceleration) / will glvnd help ?