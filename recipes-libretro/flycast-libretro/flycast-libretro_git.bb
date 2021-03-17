SUMMARY = "Sega Dreamcast/Naomi emulator"
DESCRIPTION = "Sega Dreamcast/Naomi emulator - flycast dedicated libretro emulator"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro
inherit tune-blacklist

DEPENDS += "libpng"

LIBRETRO_GIT_REPO = "github.com/libretro/flycast.git"

LIBRETRO_REPRESENT_ARM64 = "arm64"

LIBRETRO_PLATFORM_arm32 = "armv"
LIBRETRO_PLATFORM_arm64 = "arm64"

# Use AS as default for x86 and x86_64, CC for others
CC_AS = "${CC}"
CC_AS_x86arch = "${AS}"

LIBRETRO_EXTRA_MAKEFLAGS += "AS="${AS}" CC_AS="${CC_AS}" HAVE_OPENMP=0 HAVE_LTCG=0"
TARGET_LDFLAGS += "-lrt"

# Flycast overrides passed LDFLAGS and have special LDFLAGS_END to append them if needed
LIBRETRO_EXTRA_MAKEFLAGS += "CC_PREFIX="${TARGET_PREFIX}" LDFLAGS_END="${LDFLAGS}""

# Avoid linker failure: R_ARM_THM_CALL against symbol
TUNE_FEATURES_BLACKLIST = "thumb"
