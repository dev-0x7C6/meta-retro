SUMMARY = "MS-DOS emulator"
DESCRIPTION = "Dosbox port to libretro"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit libretro

# Workaround: ISO C++17 does not allow dynamic exception specifications
LIBRETRO_EXTRA_CXXFLAGS += "-std=c++14"

LIBRETRO_GIT_REPO = "github.com/libretro/dosbox-libretro.git"
