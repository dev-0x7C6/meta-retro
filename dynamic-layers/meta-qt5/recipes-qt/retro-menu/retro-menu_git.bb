DESCRIPTION = "Retro menu launcher for retro distribution. Written in Qt / QML."
HOMEPAGE = "https://github.com/dev-0x7C6/retro-menu.git"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5 libretro-version retroarch-paths

SRC_URI = "git://github.com/dev-0x7C6/retro-menu.git;protocol=https;branch=master"
SRCREV = "c21f262fad2ff150cea32f317febcbe61bc72881"
S = "${WORKDIR}/git"

PACKAGECONFIG ?= "analyse"

PACKAGECONFIG[analyse] = "-DLIBRETRO_ANALYSE=ON,-DLIBRETRO_ANALYSE=OFF"

EXTRA_OECMAKE:append = " \
    -D LIBRETRO_CORE_INFO_PATH:PATH="${RETROARCH_LIBRETRO_CORES_INFO_DIR}" \
    -D LIBRETRO_CORE_PATH:PATH="${RETROARCH_LIBRETRO_CORES_DIR}" \
    -D LIBRETRO_FIRMWARE_PATH:PATH="${RETROARCH_SYSTEM_DIR}" \
"

PACKAGECONFIG ?= "quickcompiler"

PACKAGECONFIG[quickcompiler] = "-DENABLE_QT_QUICK_COMPILER=ON,-DENABLE_QT_QUICK_COMPILER=OFF,qtdeclarative-native"

DEPENDS = "qtbase qtgamepad qtquickcontrols2 qtsvg"
RDEPENDS:${PN} += "qtgamepad qtquickcontrols2 qtsvg"
