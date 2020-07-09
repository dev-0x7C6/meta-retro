DESCRIPTION = "Dolphin is a GameCube / Wii emulator, allowing you to play \
games for these two platforms on PC with improvements."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://license.txt;md5=751419260aa954499f7abaabaa882bbe"

inherit libretro-cmake

LIBRETRO_GIT_REPO = "github.com/libretro/dolphin.git"

DEPENDS = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl ', '', d)} \
  spirv-tools \
  libusb \
"

PACKAGECONFIG ?=  " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'vulkan', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
  evdev \
  sdl \
  libretro \
  llvm \
"

OECMAKE_C_FLAGS += "-fno-common"
OECMAKE_CXX_FLAGS += "-fno-common"

PACKAGECONFIG_append_32bit = " generic"

PACKAGECONFIG[alsa] = "-DENABLE_ALSA=ON,-DENABLE_ALSA=OFF"
PACKAGECONFIG[analytics] = "-DENABLE_ANALYTICS=ON,-DENABLE_ANALYTICS=OFF"
PACKAGECONFIG[discord] = "-DUSE_DISCORD_PRESENCE=ON,-DUSE_DISCORD_PRESENCE=OFF"
PACKAGECONFIG[dsptool] = "-DDSPTOOL=ON,-DDSPTOOL=OFF"
PACKAGECONFIG[egl] = "-DENABLE_EGL=ON,-DENABLE_EGL=OFF,virtual/egl virtual/libgl virtual/libgles2"
PACKAGECONFIG[evdev] = "-DENABLE_EVDEV=ON,-DENABLE_EVDEV=OFF"
PACKAGECONFIG[fastlog] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
PACKAGECONFIG[framedumps] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
PACKAGECONFIG[gdbstub] = "-DGDBSTUB=ON,-DGDBSTUB=OFF"
PACKAGECONFIG[generic] = "-DENABLE_GENERIC=ON,-DENABLE_GENERIC=OFF"
PACKAGECONFIG[gprof] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
PACKAGECONFIG[headless] = "-DENABLE_HEADLESS=ON,-DENABLE_HEADLESS=OFF"
PACKAGECONFIG[libretro] = "-DLIBRETRO=ON -DLIBRETRO_STATIC=1,-DLIBRETRO=OFF"
PACKAGECONFIG[llvm] = "-DENABLE_LLVM=ON,-DENABLE_LLVM=OFF"
PACKAGECONFIG[lto] = "-DENABLE_LTO=ON,-DENABLE_LTO=OFF"
PACKAGECONFIG[oprofile] = "-DOPROFILING=ON,-DOPROFILING=OFF"
PACKAGECONFIG[pulse] = "-DENABLE_PULSEAUDIO=ON,-DENABLE_PULSEAUDIO=OFF"
PACKAGECONFIG[qt] = "-DENABLE_QT=ON,-DENABLE_QT=OFF"
PACKAGECONFIG[sdl] = "-DENABLE_SDL=ON,-DENABLE_SDL=OFF"
PACKAGECONFIG[system-enet] = "-DUSE_SHARED_ENET=ON,-DUSE_SHARED_ENET=OFF,,libenet"
PACKAGECONFIG[upnp] = "-DUSE_UPNP=ON,-DUSE_UPNP=OFF"
PACKAGECONFIG[vtune] = "-DENABLE_VTUNE=ON,-DENABLE_VTUNE=OFF"
PACKAGECONFIG[vulkan] = ",,vulkan-loader,vulkan-loader"
PACKAGECONFIG[x11] = "-DENABLE_X11=ON,-DENABLE_X11=OFF,libxi"
