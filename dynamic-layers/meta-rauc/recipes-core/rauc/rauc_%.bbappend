FILESEXTRAPATHS:prepend:rpi := "${THISDIR}/files/raspberrypi:"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append := " file://ca.cert.pem"
SRC_URI:append:rpi := " file://system.conf"

PR = "r2"

do_install:prepend:rpi() {
    sed "s/raspberry-yocto-machine/${MACHINE}-${DISTRO}/g" -i "${WORKDIR}/system.conf"
}
