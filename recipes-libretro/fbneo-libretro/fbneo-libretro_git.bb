SUMMARY = "FB Neo multi-arcade emulator"
DESCRIPTION = "Multi-arcade emulator - FinalBurn Neo v0.2.97.44 (WIP) port for libretro"

LICENSE = "FB-NEO"
LIC_FILES_CHKSUM = "file://src/license.txt;md5=22b5ab10f7a5e14171d15ecbef75d08c"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/FBNeo.git"
LIBRETRO_CORE = "src/burner/libretro/fbneo"
LIBRETRO_MAKEFILE_PREFIX = "src/burner/libretro/"

# Unable to compile with -Werror=format-security
SECURITY_STRINGFORMAT = "-Wformat -Wformat-security"

# Workaround missing make clean
do_configure() {
}
