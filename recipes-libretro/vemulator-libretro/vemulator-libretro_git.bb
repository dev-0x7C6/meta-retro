DESCRIPTION = "A port of the SEGA Visual Memory Unit emulator VeMUlator for libretro."

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/vemulator-libretro.git"

# Workaround AR/CC overrides by core
LIBRETRO_EXTRA_MAKEFLAGS += "AR="${AR}" CC="${CC}""

# Fixed undefined new operator 
TARGET_LDFLAGS += "-lstdc++"
