DESCRIPTION = "MelonDS - Nintendo DS emulator"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/melonDS.git"

DEPENDS += "virtual/libgl"

JIT_ARCH = ""
JIT_ARCH:arm64 = "aarch64"
JIT_ARCH:x86-64 = "x64"

LIBRETRO_EXTRA_MAKEFLAGS += "HAVE_OPENGL=`0` JIT_ARCH='${JIT_ARCH}'"