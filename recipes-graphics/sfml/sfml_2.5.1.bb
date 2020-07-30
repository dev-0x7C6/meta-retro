DESCRIPTION = "Simple and Fast Multimedia Library"
HOMEPAGE = "http://www.sfml-dev.org/index.php"
SECTION = "libs"

LICENSE = "SFML"
LIC_FILES_CHKSUM = "file://license.md;md5=7019c1b3f42a8b324fe092a4967cbb31"

SRC_URI = "git://github.com/SFML/SFML.git;protocol=https;branch=master"
SRCREV = "241b542ca30751e9283230288b4d704fe3e80981"
PV = "2.5.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake features_check

DEPENDS = "openal-soft freetype virtual/mesa xcb-util-image libjpeg-turbo libxrandr"

FILES_${PN} =+ "${datadir}/SFML"

REQUIRED_DISTRO_FEATURES= "x11"