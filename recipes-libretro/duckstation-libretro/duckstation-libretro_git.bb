SUMMARY = "Sony PlayStation emulator"
DESCRIPTION = "Fast-ish PlayStation 1 emulator for PC and Android"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro-cmake

LIBRETRO_GIT_REPO = "github.com/libretro/duckstation.git"

LIBRETRO_COMMON_FLAGS = "-fPIC -shared"

EXTRA_OECMAKE_append = " -DBUILD_LIBRETRO_CORE=ON"

DEPENDS += " \
  alsa-lib \
  libao \
  libevdev \
  nasm-native \
"
