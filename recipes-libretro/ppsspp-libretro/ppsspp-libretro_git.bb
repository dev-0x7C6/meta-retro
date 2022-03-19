DESCRIPTION = "PlayStation Portable emu - PPSSPP port for libretro"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=e336f8162cddec7981e240f46825d8a2"

inherit libretro-cmake
inherit libretro-vulkan-deps

LIBRETRO_GIT_REPO = "github.com/hrydgard/ppsspp.git"

#Need to be reworked, switched to included ffmpeg
#LIBRETRO_CORE_PATCHES += "file://0001-Revert-Mpeg-Parse-video-streams-from-PSMF-header.patch"

LIBRETRO_CORE_SOURCE_PATH = "lib"

DEPENDS = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl ', '', d)} \
  spirv-tools \
"

PACKAGECONFIG ?=  " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'egl gles', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'egl gles', '', d)} \
  libretro \
  libzip \
"

# Workaround for aarch64
PACKAGECONFIG:append:arm64 = " system-ffmpeg"

PACKAGECONFIG:append:armarch = " ${@bb.utils.contains('TUNE_FEATURES', 'neon', 'armv7 arm', 'arm', d)}"
PACKAGECONFIG:append:mipsarch = " mips"
PACKAGECONFIG:append:x86 = " x86"
PACKAGECONFIG:append:x86-64 = " x86-64"

PACKAGECONFIG[armv7] = "-DARMV7=ON,-DARMV7=OFF"
PACKAGECONFIG[arm] = "-DARM=ON,-DARM=OFF"
PACKAGECONFIG[mips] = "-DMIPS=ON,-DMIPS=OFF"
PACKAGECONFIG[x86] = "-DX86=ON,-DX86=OFF"
PACKAGECONFIG[x86-64] = "-DX86_64=ON,-DX86_64=OFF"

PACKAGECONFIG[discord] = "-DUSE_DISCORD=ON,-DUSE_DISCORD=OFF"
PACKAGECONFIG[egl] = "-DUSING_EGL=ON,-DUSING_EGL=OFF,virtual/egl"
PACKAGECONFIG[fbdev] = "-DUSING_FBDEV=ON,-DUSING_FBDEV=OFF"
PACKAGECONFIG[gles] = "-DUSING_GLES2=ON,-DUSING_GLES2=OFF,virtual/libgles2"
PACKAGECONFIG[headless] = "-DHEADLESS=ON,-DHEADLESS=OFF"
PACKAGECONFIG[libretro] = "-DLIBRETRO=ON,-DLIBRETRO=OFF"
PACKAGECONFIG[libzip] = "-DUSE_SYSTEM_LIBZIP=ON,-DUSE_SYSTEM_LIBZIP=OFF,libzip"
PACKAGECONFIG[mobile] = "-DMOBILE_DEVICE=ON,-DMOBILE_DEVICE=OFF"
PACKAGECONFIG[qt] = "-DUSING_QT_UI=ON,-DUSING_QT_UI=OFF"
PACKAGECONFIG[simulator] = "-DSIMULATOR=ON,-DSIMULATOR=OFF"
PACKAGECONFIG[system-ffmpeg] = "-DUSE_FFMPEG=ON -DUSE_SYSTEM_FFMPEG=ON,-DUSE_FFMPEG=ON -USE_SYSTEM_FFMPEG=OFF,ffmpeg"
PACKAGECONFIG[tests] = "-DUNITTEST=ON,-DUNITTEST=OFF"
PACKAGECONFIG[vulkan-x11] = "-DUSING_X11_VULKAN=ON,-DUSING_X11_VULKAN=OFF"
PACKAGECONFIG[wsi] = "-DUSE_WAYLAND_WSI=ON,-DUSE_WAYLAND_WSI=OFF"

# Now libretro-vulkan-deps will take care
# PACKAGECONFIG[vulkan] = ",,${VULKAN_DEPENDS},${VULKAN_DEPENDS}"

FILES:${PN} += "${RETROARCH_SYSTEM_DIR}"
RCONFLICTS:${PN} += "firmware-libretro-psp"

do_install:append() {
  install -d ${D}${RETROARCH_SYSTEM_DIR}/PPSSPP/
  cp -rf ${B}/assets/* ${D}${RETROARCH_SYSTEM_DIR}/PPSSPP/
}