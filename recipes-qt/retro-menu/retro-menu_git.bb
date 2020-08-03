DESCRIPTION = "Retro menu launcher for retro distribution. Written in Qt / QML."

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5

SRC_URI = "git://github.com/dev-0x7C6/retro-menu.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative-native qtgamepad qtquickcontrols2"
RDEPENDS_${PN} += "qtgamepad qtquickcontrols2"
