SUMMARY = "Sega Dreamcast/Naomi emulator"
DESCRIPTION = "Sega Dreamcast/Naomi emulator - flycast dedicated libretro emulator"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro
inherit tune-blacklist

DEPENDS += "libpng nasm-native"

LIBRETRO_GIT_REPO = "github.com/libretro/flycast.git"

LIBRETRO_REPRESENT_ARM64 = "arm64"

LIBRETRO_PLATFORM:arm32 = "armv"
LIBRETRO_PLATFORM:arm64 = "arm64"

# Patch default LDFLAGS
do_patch() {
	sed -i 's#^LDFLAGS .*:=$#LDFLAGS := ${LDFLAGS}#g' ${S}/Makefile
}

# Avoid linker failure: R_ARM_THM_CALL against symbol
TUNE_FEATURES_BLACKLIST = "thumb"
