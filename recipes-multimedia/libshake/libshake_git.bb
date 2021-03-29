SUMMARY = "Simple, cross-platform haptic library."
HOMEPAGE = "https://github.com/zear/libShake"
BUGTRACKER = "https://github.com/zear/libShake/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=c49bb48e5987c0801be634da2ff4707e"

PV = "0.3.2"
SRC_URI = "git://github.com/zear/libShake.git;protocol=https"
SRCREV = "v${PV}"
S = "${WORKDIR}/git"

inherit autotools-brokensep

EXTRA_OEMAKE += "BACKEND=LINUX"

do_patch() {
# don't override default ldflags
	sed -i -E '/.*LDFLAGS.*:=.*/d' ${S}/Makefile
}

do_install_prepend() {
# script expects already existing directories
	install -d ${D}${includedir}
	install -d ${D}${libdir}
}
