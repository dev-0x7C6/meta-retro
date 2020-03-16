DESCRIPTION = "Vectrex emulator - vecx port for libretro"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86be7c1121127c4ab250ab6043117e46"

inherit libretro/core/git

LIBRETRO_CORE = "vecx"
LIBRETRO_GIT_REPO = "github.com/libretro/libretro-vecx.git"
