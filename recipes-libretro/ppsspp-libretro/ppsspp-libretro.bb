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
  spirv-tools \
"

PACKAGECONFIG ?=  " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'egl gles', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'egl gles', '', d)} \
  ffmpeg \
  libretro \
  libzip \
"

PACKAGECONFIG_append_armarch = " ${@bb.utils.contains('TUNE_FEATURES', 'neon', 'armv7 arm', 'arm', d)}"
PACKAGECONFIG_append_mipsarch = " mips"
PACKAGECONFIG_append_x86 = " x86"
PACKAGECONFIG_append_x86-64 = " x86-64"

OECMAKE_C_FLAGS_append = " ${@bb.utils.contains('TUNE_FEATURES', 'neon', '-mfpu=neon', '', d)}"
OECMAKE_CXX_FLAGS_append = " ${@bb.utils.contains('TUNE_FEATURES', 'neon', '-mfpu=neon', '', d)}"

PACKAGECONFIG[armv7] = "-DARMV7=ON,-DARMV7=OFF"
PACKAGECONFIG[arm] = "-DARM=ON,-DARM=OFF"
PACKAGECONFIG[mips] = "-DMIPS=ON,-DMIPS=OFF"
PACKAGECONFIG[x86] = "-DX86=ON,-DX86=OFF"
PACKAGECONFIG[x86-64] = "-DX86_64=ON,-DX86_64=OFF"

PACKAGECONFIG[discord] = "-DUSE_DISCORD=ON,-DUSE_DISCORD=OFF"
PACKAGECONFIG[egl] = "-DUSING_EGL=ON,-DUSING_EGL=OFF,virtual/egl"
PACKAGECONFIG[fbdev] = "-DUSING_FBDEV=ON,-DUSING_FBDEV=OFF"
PACKAGECONFIG[ffmpeg] = "-DUSE_FFMPEG=ON -DUSE_SYSTEM_FFMPEG=ON,-DUSE_FFMPEG=OFF -USE_SYSTEM_FFMPEG=OFF,ffmpeg"
PACKAGECONFIG[gles] = "-DUSING_GLES2=ON,-DUSING_GLES2=OFF,virtual/libgles2"
PACKAGECONFIG[headless] = "-DHEADLESS=ON,-DHEADLESS=OFF"
PACKAGECONFIG[libretro] = "-DLIBRETRO=ON,-DLIBRETRO=OFF"
PACKAGECONFIG[mobile] = "-DMOBILE_DEVICE=ON,-DMOBILE_DEVICE=OFF"
PACKAGECONFIG[qt] = "-DUSING_QT_UI=ON,-DUSING_QT_UI=OFF"
PACKAGECONFIG[simulator] = "-DSIMULATOR=ON,-DSIMULATOR=OFF"
PACKAGECONFIG[tests] = "-DUNITTEST=ON,-DUNITTEST=OFF"
PACKAGECONFIG[vulkan-x11] = "-DUSING_X11_VULKAN=ON,-DUSING_X11_VULKAN=OFF"
PACKAGECONFIG[wsi] = "-DUSE_WAYLAND_WSI=ON,-DUSE_WAYLAND_WSI=OFF"
PACKAGECONFIG[libzip] = "-DUSE_SYSTEM_LIBZIP=ON,-DUSE_SYSTEM_LIBZIP=OFF,libzip"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_DIR}"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${B}/lib/ppsspp_libretro.so ${D}${RETROARCH_LIBRETRO_CORES_DIR}/ppsspp_libretro.so
}
