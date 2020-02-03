DESCRIPTION = "Atari 7800 ProSystem emu - ProSystem port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://License.txt;md5=ec2ee434a4ad8ef5c1eae190fff988a9"

inherit libretro-git

LIBRETRO_CORE = "prosystem"
LIBRETRO_REPO = "github.com/libretro/prosystem-libretro.git"
