DESCRIPTION = "PlayStation Portable emu - PPSSPP port for libretro"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=e336f8162cddec7981e240f46825d8a2"

inherit cmake retroarch-overrides retroarch-paths retroarch-dist-checks

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/hrydgard/ppsspp.git;protocol=https"
SRCREV = "${AUTOREV}"

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "/usr/bin"

DEPENDS = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl ', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-vulkan', 'vulkan-loader', '', d)} \
"

PACKAGECONFIG ?=  " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'gles2', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'gles2', '', d)} \
  libretro \
"
PACKAGECONFIG[libretro] = "-DLIBRETRO=ON,-DLIBRETRO=OFF"
PACKAGECONFIG[gles2] = "-DUSING_GLES2=ON,-DUSING_GLES2=OFF,virtual/egl virtual/libgles1 virtual/libgles2"
PACKAGECONFIG[ffmpeg] = "-DUSE_FFMPEG=ON,-DUSE_FFMPEG=OFF,ffmpeg"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_DIR}"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${B}/lib/ppsspp_libretro.so ${D}${RETROARCH_LIBRETRO_CORES_DIR}/ppsspp_libretro.so
}
