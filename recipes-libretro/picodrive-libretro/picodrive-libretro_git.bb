DESCRIPTION = "Sega 8/16 bit emu - picodrive arm optimised libretro core"

LICENSE = "PICODRIVE"
LIC_FILES_CHKSUM = "file://COPYING;md5=4613340462793d879916d43aa44d4236"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/picodrive.git"

# More details here: https://github.com/dev-0x7C6/meta-retro/pull/2#
LIBRETRO_PLATFORM_arm32 = "armv"

# Show warning when compiling with thumb instruction set
do_configure_append() {
    if ${@bb.utils.contains('TUNE_FEATURES', 'thumb', 'true', 'false', d)}; then
        bbwarn "thumb instruction set is causing massive performance regression for this core"
    fi
}
