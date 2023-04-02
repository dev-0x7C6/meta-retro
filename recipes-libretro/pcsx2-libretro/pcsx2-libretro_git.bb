DESCRIPTION = "PCSX2 - The Playstation 2 Emulator."

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro-cmake python3native

LIBRETRO_CORE = "pcsx2/pcsx2"

PR = "r2"

LIBRETRO_GIT_REPO = "github.com/libretro/pcsx2.git"
LIBRETRO_GIT_BRANCH = "libretro"

DEPENDS = "zlib attr alsa-lib glib-2.0 glib-2.0-native libaio libpcap libpng soundtouch openssl ffmpeg"
RDEPENDS:${PN} += "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-firmware', 'firmware-libretro-pcsx2', '', d)}"

EXTRA_OECMAKE:append = " -DLIBRETRO=ON -DCMAKE_BUILD_TYPE=Release"
