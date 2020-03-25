DESCRIPTION = "MSX/MSX2 emu - fMSX port for libretro"

LICENSE = "fMSX"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d953e2d1968065c02d63ff481dfee5d4"

inherit libretro/core/git

LIBRETRO_CORE = "fmsx"
LIBRETRO_GIT_REPO = "github.com/libretro/fmsx-libretro.git"
