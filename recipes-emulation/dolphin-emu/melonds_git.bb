DESCRIPTION = "DS emulator, sorta"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "gitsm://github.com/Arisotura/melonds.git;protocol=https;branch=master"
SRCREV = "0.9.2"
S = "${WORKDIR}/git"

inherit cmake_qt5

PACKAGECONFIG ?= "frontend jit"

PACKAGECONFIG[frontend] = "-DBUILD_QT_SDL=ON,-DBUILD_QT_SDL=OFF,libsdl2"
PACKAGECONFIG[jit] = "-DENABLE_JIT=ON,-DENABLE_JIT=OFF"
PACKAGECONFIG[lto] = "-DENABLE_LTO=ON,-DENABLE_LTO=OFF"

DEPENDS += "libarchive libepoxy libslipr"
