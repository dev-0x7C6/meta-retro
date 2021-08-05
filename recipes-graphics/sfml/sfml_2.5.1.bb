DESCRIPTION = "Simple and Fast Multimedia Library"
HOMEPAGE = "http://www.sfml-dev.org/index.php"
SECTION = "libs"

LICENSE = "SFML"
LIC_FILES_CHKSUM = "file://license.md;md5=7019c1b3f42a8b324fe092a4967cbb31"

SRC_URI = "git://github.com/SFML/SFML.git;protocol=https;nobranch=1"
SRCREV = "2f11710abc5aa478503a7ff3f9e654bd2078ebab"
PV = "2.5.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake features_check

DEPENDS = "openal-soft freetype virtual/mesa xcb-util-image libjpeg-turbo libxrandr"

FILES:${PN} =+ "${datadir}/SFML"

REQUIRED_DISTRO_FEATURES= "x11"