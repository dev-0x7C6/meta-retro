DESCRIPTION = "PCSX2 - The Playstation 2 Emulator."

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504"

inherit libretro-cmake

PR = "r3"

LIBRETRO_GIT_REPO = "github.com/libretro/pcsx2.git"
LIBRETRO_GIT_BRANCH = "libretro"

DEPENDS = "libzip-native libzip alsa-lib attr ffmpeg fmt glib-2.0 glib-2.0-native libaio libpcap libpng libsdl2 openssl soundtouch zlib"
RDEPENDS:${PN} += "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-firmware', 'firmware-libretro-pcsx2', '', d)}"

EXTRA_OECMAKE:append = " -DLIBRETRO=ON \
  -DUSE_SYSTEM_FMT=ON \
  -DUSE_SYSTEM_LIBZIP=ON \
  -DUSE_SYSTEM_SDL2=ON \
"

LIBRETRO_CORE_SOURCE_PATH = "/bin/"

do_configure:prepend() {
# workaround broken native libzip tools detection
    ln -sf ${STAGING_DIR_NATIVE}/usr/bin/zipcmp ${STAGING_DIR_HOST}/usr/bin/
    ln -sf ${STAGING_DIR_NATIVE}/usr/bin/zipmerge ${STAGING_DIR_HOST}/usr/bin/
    ln -sf ${STAGING_DIR_NATIVE}/usr/bin/ziptool ${STAGING_DIR_HOST}/usr/bin/
}
