DESCRIPTION = "Dreamcast emulator - reicast"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f1637c76115ca31de8eaf5f93b64c7ff"

inherit cmake retro/overrides retroarch/paths retroarch/checks retro/git

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/reicast/reicast-emulator.git;protocol=https;branch=alpha"
SRCREV = "${AUTOREV}"

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "/usr/bin"

PACKAGECONFIG ?= "libretro"

DEPENDS = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl ', '', d)} \
  alsa-lib \
  libpthread-stubs \
  nasm-native \
  libao \
  libevdev \
  libgcc \
"

CCACHE_DISABLE = "1"

PACKAGECONFIG[libretro] = "-DLIBRETRO=ON,-DLIBRETRO=OFF"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_DIR} ${RETROARCH_SYSTEM_DIR}"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${B}/lib/ppsspp_libretro.so ${D}${RETROARCH_LIBRETRO_CORES_DIR}/ppsspp_libretro.so

  install -d ${D}${RETROARCH_SYSTEM_DIR}/PPSSPP/
  cp -rf ${B}/assets/* ${D}${RETROARCH_SYSTEM_DIR}/PPSSPP/
}
