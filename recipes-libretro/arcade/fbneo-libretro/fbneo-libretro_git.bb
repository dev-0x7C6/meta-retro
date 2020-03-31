DESCRIPTION = "Arcade emu - FinalBurn Neo v0.2.97.44 (WIP) port for libretro"

LICENSE = "FB-NEO"
LIC_FILES_CHKSUM = "file://src/license.txt;md5=e1fed87bd6bd0f0ec211e3d2ba85737e"

inherit libretro/core/git

PR = "r1000"

LIBRETRO_GIT_REPO = "github.com/libretro/FBNeo.git"
LIBRETRO_CORE = "src/burner/libretro/fbneo"
LIBRETRO_MAKEFILE_PREFIX = "src/burner/libretro/"

# Unable to compile with -Werror=format-security
SECURITY_STRINGFORMAT = "-Wformat -Wformat-security"

# Workaround missing make clean
do_configure() {
}