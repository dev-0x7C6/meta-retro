SUMMARY = "A general purpose TCP-IP emulator library"
DESCRIPTION = "A general purpose TCP-IP emulator used by virtual machine \
hypervisors to provide virtual networking services."

HOMEPAGE = "https://gitlab.freedesktop.org/slirp/libslirp"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=bca0186b14e6b05e338e729f106db727"

SRC_URI = "git://gitlab.freedesktop.org/slirp/libslirp.git;protocol=https;nobranch=1"
SRCREV = "v4.4.0"
S = "${WORKDIR}/git"

inherit meson

DEPENDS = "glib-2.0"
