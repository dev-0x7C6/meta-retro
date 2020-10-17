FILESEXTRAPATHS_prepend_rpi := "${THISDIR}/files/raspberrypi:"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append := " file://ca.cert.pem"
SRC_URI_append_rpi := " file://system.conf"

PR = "r2"

do_install_prepend_rpi() {
    sed "s/raspberry-yocto-machine/${MACHINE}-${DISTRO}/g" -i "${WORKDIR}/system.conf"
}
