DESCRIPTION = "Dolphin is a GameCube / Wii emulator"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://license.txt;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/dolphin-emu/dolphin.git;protocol=https"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 common-overrides

PACKAGECONFIG ?= " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
    egl \
    upnp \
    frontend-nogui \
    frontend-qt \
    alsa \
    encode \
"

DEPENDS += "bluez5 mbedtls hidapi curl zlib vulkan-loader"
RDEPENDS_${PN} += "bluez5"

FILES_${PN} += "${datadir}/icons"

CCACHE_DISABLE = "1"

PACKAGECONFIG_append_32bit = " generic"

EXTRA_OECMAKE_append = " -DDISTRIBUTOR="${DISTRO_NAME}""

PACKAGECONFIG[x11] = "-DENABLE_X11=ON,-DENABLE_X11=OFF"
PACKAGECONFIG[egl] = "-DENABLE_EGL=ON,-DENABLE_EGL=OFF,virtual/egl"
PACKAGECONFIG[generic] = "-DENABLE_GENERIC=ON,-DENABLE_GENERIC=OFF"
PACKAGECONFIG[upnp] = "-DUSE_UPNP=ON,-DUSE_UPNP=OFF"
PACKAGECONFIG[frontend-nogui] = "-DENABLE_NOGUI=ON,-DENABLE_NOGUI=OFF"
PACKAGECONFIG[frontend-qt] = "-DENABLE_QT=ON,-DENABLE_QT=OFF"
PACKAGECONFIG[lto] = "-DENABLE_LTO=ON,-DENABLE_QT=OFF,qtbase"
PACKAGECONFIG[headless] = "-DENABLE_HEADLESS=ON,-DENABLE_HEADLESS=OFF"
PACKAGECONFIG[alsa] = "-DENABLE_ALSA=ON,-DENABLE_ALSA=OFF,alsa-lib"
PACKAGECONFIG[pulseaudio] = "-DENABLE_PULSEAUDIO=ON,-DENABLE_PULSEAUDIO=OFF,pulseaudio"
PACKAGECONFIG[llvm] = "-DENABLE_LLVM=ON,-DENABLE_LLVM=OFF,llvm"
PACKAGECONFIG[tests] = "-DENABLE_TESTS=ON,-DENABLE_TESTS=OFF"
PACKAGECONFIG[discord] = "-DUSE_DISCORD_PRESENCE=ON,-DUSE_DISCORD_PRESENCE=OFF"
PACKAGECONFIG[analytics] = "-DENABLE_ANALYTICS=ON,-DENABLE_ANALYTICS=OFF"
PACKAGECONFIG[encode] = "-DENCODE_FRAMEDUMPS=ON,-DENCODE_FRAMEDUMPS=OFF"
