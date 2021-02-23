SUMMARY = "Nintendo GameBoy Advance emulator"
DESCRIPTION = "Nintendo GameBoy Advance emulator - mgba"

LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/mgba.git"

LIBRETRO_EXTRA_MAKEFLAGS = "HAVE_VFS_FD=0"
