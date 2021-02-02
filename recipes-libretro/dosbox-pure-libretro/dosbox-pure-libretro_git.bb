SUMMARY = "MS-DOS emulator libretro core"
DESCRIPTION = "DOSBox Pure is a new fork of DOSBox built for RetroArch/Libretro \ 
aiming for simplicity and ease of use."

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7c050190136f70e95bb9873bf63cf427"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/dosbox-pure.git"
LIBRETRO_GIT_BRANCH = "main"

do_patch() {
# Do not use strong LDFLAGS override, avoid override Yocto defaults
    sed -i "s/LDFLAGS :=/LDFLAGS +=/g" ${S}/Makefile
# Avoid switching to g++-9
    sed -i "s/CXX := g++-9//g" ${S}/Makefile
}

# Unable to compile with -Werror=format-security
SECURITY_STRINGFORMAT = "-Wformat -Wformat-security"

INSANE_SKIP_${PN} = "already-stripped"
