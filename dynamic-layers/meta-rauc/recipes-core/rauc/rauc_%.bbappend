FILESEXTRAPATHS_prepend_rpi := "${THISDIR}/files/raspberrypi:"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_prepend_rpi() {
    sed s/raspberry-yocto-machine/${MACHINE}/g -i ${WORKDIR}/system.conf
}