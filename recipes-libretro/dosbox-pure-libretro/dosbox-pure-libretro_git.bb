SUMMARY = "MS-DOS emulator"
DESCRIPTION = "DOSBox Pure is a new fork of DOSBox built for RetroArch/Libretro \ 
aiming for simplicity and ease of use."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7c050190136f70e95bb9873bf63cf427"

inherit libretro

PR = "r4"

LIBRETRO_GIT_REPO = "github.com/libretro/dosbox-pure.git"
LIBRETRO_GIT_BRANCH = "main"

CCACHE_DISABLE = "1"

export CC = "${HOST_PREFIX}gcc ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
export CXX = "${HOST_PREFIX}g++ ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"

LIBRETRO_EXTRA_MAKEFLAGS:append = " CXX='${CXX}'"
LIBRETRO_EXTRA_MAKEFLAGS:append = " CC='${CC}'"

do_patch() {
# Do not use strong LDFLAGS override, avoid override Yocto defaults
    sed -i "s/LDFLAGS :=/LDFLAGS +=/g" ${S}/Makefile
# Avoid switching to g++-9
    sed -i "/CXX.*\?=.*/d" ${S}/Makefile
}

# Unable to compile with -Werror=format-security
SECURITY_STRINGFORMAT = "-Wformat -Wformat-security"

INSANE_SKIP:${PN} = "already-stripped"
