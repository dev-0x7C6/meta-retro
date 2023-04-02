SUMMARY = "SoundTouch audio tempo/pitch control library"
HOMEPAGE = "http://www.surina.net/soundtouch/index.html"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.TXT;md5=e05877bfa22930262b6cfbe7db2eea24"

inherit cmake pkgconfig gettext

SRC_URI = " \
    git://codeberg.org/soundtouch/soundtouch.git;protocol=https;branch=master \
    file://0001-Fix-path-to-m4-macro-dir.patch \
"
SRCREV = "e1f315f5358d9db5cee35a7a2886425489fcefe8"
PV = "2.3.1"
S = "${WORKDIR}/git"
