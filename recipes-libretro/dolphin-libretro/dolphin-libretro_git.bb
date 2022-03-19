SUMMARY = "Nintendo GameCube / Wii emulator"
DESCRIPTION = "Dolphin is a GameCube / Wii emulator, allowing you to play \
games for these two platforms on PC with improvements."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://license.txt;md5=751419260aa954499f7abaabaa882bbe"

inherit libretro-cmake
require files/dolphin-32bit-configuration.inc

LIBRETRO_GIT_REPO = "github.com/libretro/dolphin.git"

DEPENDS = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl ', '', d)} \
  curl \
  fmt \
  libusb \
  pugixml \
  xz \
  zlib \
"

PACKAGECONFIG ?=  " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'egl', '', d)} \
  ${@bb.utils.filter('DISTRO_FEATURES', 'vulkan x11', d)} \
  evdev \
  sdl2 \
"

PACKAGECONFIG[dsptool] = "-DDSPTOOL=ON,-DDSPTOOL=OFF"
PACKAGECONFIG[egl] = "-DENABLE_EGL=ON,-DENABLE_EGL=OFF,virtual/egl virtual/libgl virtual/libgles2"
PACKAGECONFIG[evdev] = "-DENABLE_EVDEV=ON,-DENABLE_EVDEV=OFF,libevdev"
PACKAGECONFIG[fastlog] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
PACKAGECONFIG[gdbstub] = "-DGDBSTUB=ON,-DGDBSTUB=OFF"
PACKAGECONFIG[gprof] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
PACKAGECONFIG[headless] = "-DENABLE_HEADLESS=ON,-DENABLE_HEADLESS=OFF"
PACKAGECONFIG[lto] = "-DENABLE_LTO=ON,-DENABLE_LTO=OFF"
PACKAGECONFIG[oprofile] = "-DOPROFILING=ON,-DOPROFILING=OFF"
PACKAGECONFIG[sdl2] = "-DENABLE_SDL=ON,-DENABLE_SDL=OFF,libsdl2"
PACKAGECONFIG[system-enet] = "-DUSE_SHARED_ENET=ON,-DUSE_SHARED_ENET=OFF,,libenet"
PACKAGECONFIG[vtune] = "-DENABLE_VTUNE=ON,-DENABLE_VTUNE=OFF"
PACKAGECONFIG[vulkan] = ",,vulkan-loader vulkan-headers glslang glslang-native"
PACKAGECONFIG[x11] = "-DENABLE_X11=ON,-DENABLE_X11=OFF,libxi"

EXTRA_OECMAKE += "-DLIBRETRO=ON"

