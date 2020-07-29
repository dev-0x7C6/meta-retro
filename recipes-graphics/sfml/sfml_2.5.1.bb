DESCRIPTION = "Simple and Fast Multimedia Library"
HOMEPAGE = "http://www.sfml-dev.org/index.php"
SECTION = "libs"

LICENSE = "SFML"
LIC_FILES_CHKSUM = "file://license.md;md5=7019c1b3f42a8b324fe092a4967cbb31"

DEPENDS = "openal-soft glibc gcc-runtime freetype mesa xcb-util-image libjpeg-turbo libxrandr"

SRC_URI = "http://www.sfml-dev.org/files/SFML-${PV}-sources.zip"

SRC_URI[md5sum] = "8533b22888102b4f0883311385fb1c71"
SRC_URI[sha256sum] = "bf1e0643acb92369b24572b703473af60bac82caf5af61e77c063b779471bb7f"

S = "${WORKDIR}/SFML-${PV}"

inherit cmake

FILES_${PN} =+ "${datadir}/SFML"