SUMMARY = "FB Neo multi-arcade emulator"
DESCRIPTION = "Multi-arcade emulator - FinalBurn Neo v0.2.97.44 (WIP) port for libretro"

LICENSE = "FB-NEO"
LIC_FILES_CHKSUM = "file://src/license.txt;md5=3581b426b1a7d159163b0429cf980805"

inherit libretro

SRC_URI += "file://0001-Fixed-issue-with-_TIME_BITS-64-is-allowed-only-with-.patch"

LIBRETRO_EXTRA_MAKEFLAGS:append:armarch = " USE_CYCLONE=1"
LIBRETRO_EXTRA_MAKEFLAGS:append:x86-64 = " USE_X64_DRC=1"
LIBRETRO_EXTRA_MAKEFLAGS:append:32bit = " PTR64=0"
LIBRETRO_EXTRA_MAKEFLAGS:append:64bit = " PTR64=1"

LIBRETRO_GIT_REPO = "github.com/libretro/FBNeo.git"
LIBRETRO_CORE = "src/burner/libretro/fbneo"
LIBRETRO_MAKEFILE_PREFIX = "src/burner/libretro/"

# Unable to compile with -Werror=format-security
SECURITY_STRINGFORMAT = "-Wformat -Wformat-security"

# Workaround missing make clean
do_configure() {
}

