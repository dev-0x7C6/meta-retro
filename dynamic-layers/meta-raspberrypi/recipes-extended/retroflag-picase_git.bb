DESCRIPTION = "RetroFlag Pi-Case Safe Shutdown"

inherit cmake python3-dir python3native

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0e9db807e4f1ed14373059c8499d5f82"

SRC_URI = "git://github.com/RetroFlag/retroflag-picase.git"
SRCREV = "742ffbfbf1016b0dc00826c8e9e9f47a35431c48"

PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"
