DESCRIPTION = "Dolphin is a GameCube / Wii emulator"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=42dac715b05c09ace95c14324cdfd147"

SRC_URI = "gitsm://github.com/dolphin-emu/dolphin.git;protocol=https;branch=master"
SRCREV = "954f27c5d7289b2b806d0fb94dd105edaa1bb4be"
S = "${WORKDIR}/git"

inherit cmake_qt5 retro-overrides gettext libretro-version
require files/dolphin-32bit-configuration.inc

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

PACKAGECONFIG ?= " \
    ${@bb.utils.filter('DISTRO_FEATURES', 'alsa bluetooth pulseaudio vulkan x11', d)} \
    egl \
    encode \
    ffmpeg \
    frontend-nogui \
    frontend-qt \
    sdl \
    upnp \
"

DEPENDS += " \
    curl \
    hidapi \
    lzo \
    mbedtls \
    zlib \
"

FILES:${PN} += "${datadir}/icons"

CCACHE_DISABLE = "1"

EXTRA_OECMAKE += "-DDISTRIBUTOR="${DISTRO_NAME}""
DEPENDS += "fmt"

PACKAGECONFIG[alsa] = "-DENABLE_ALSA=ON,-DENABLE_ALSA=OFF,alsa-lib"
PACKAGECONFIG[analytics] = "-DENABLE_ANALYTICS=ON,-DENABLE_ANALYTICS=OFF"
PACKAGECONFIG[bluetooth] = ",,bluez5,bluez5"
PACKAGECONFIG[discord] = "-DUSE_DISCORD_PRESENCE=ON,-DUSE_DISCORD_PRESENCE=OFF"
PACKAGECONFIG[egl] = "-DENABLE_EGL=ON,-DENABLE_EGL=OFF,virtual/egl"
PACKAGECONFIG[encode] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
PACKAGECONFIG[evdev] = "-DENABLE_EVDEV=ON,-DENABLE_EVDEV=OFF,libevdev"
PACKAGECONFIG[sdl] = "-DENABLE_SDL=ON,-DENABLE_SDL=OFF,libsdl2"
PACKAGECONFIG[ffmpeg] = ",,ffmpeg"
PACKAGECONFIG[frontend-nogui] = "-DENABLE_NOGUI=ON,-DENABLE_NOGUI=OFF"
PACKAGECONFIG[frontend-qt] = "-DENABLE_QT=ON,-DENABLE_QT=OFF,qtbase"
PACKAGECONFIG[headless] = "-DENABLE_HEADLESS=ON,-DENABLE_HEADLESS=OFF"
PACKAGECONFIG[llvm] = "-DENABLE_LLVM=ON,-DENABLE_LLVM=OFF,llvm"
PACKAGECONFIG[lto] = "-DENABLE_LTO=ON,-DENABLE_LTO=OFF"
PACKAGECONFIG[pulseaudio] = "-DENABLE_PULSEAUDIO=ON,-DENABLE_PULSEAUDIO=OFF,pulseaudio"
PACKAGECONFIG[tests] = "-DENABLE_TESTS=ON,-DENABLE_TESTS=OFF"
PACKAGECONFIG[upnp] = "-DUSE_UPNP=ON,-DUSE_UPNP=OFF,miniupnpd"
PACKAGECONFIG[vulkan] = ",,vulkan-loader,vulkan-loader"
PACKAGECONFIG[x11] = "-DENABLE_X11=ON,-DENABLE_X11=OFF"
