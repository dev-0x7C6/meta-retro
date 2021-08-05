SUMMARY = "Nintendo Entertainment System emulator"
DESCRIPTION = "Nintendo Entertainment System emulator - FCEUmm libretro port"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://Copying;md5=6e233eda45c807aa29aeaa6d94bc48a2"

inherit libretro

LIBRETRO_CORE = "fceumm"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-fceumm.git"

LIBRETRO_EXTRA_CFLAGS = "-std=gnu11"
LIBRETRO_EXTRA_CFLAGS:append:armarch = " -DARM"
LIBRETRO_EXTRA_CXXFLAGS = "-std=gnu++11"
LIBRETRO_EXTRA_CXXFLAGS:append:armarch = " -DARM"

