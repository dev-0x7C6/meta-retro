FILESEXTRAPATHS_prepend_rpi_retro := "${THISDIR}/files:"
SRC_URI_append_rpi_retro = " file://raspberrypi-rauc-retro.rules"

do_install_append_rpi_retro() {
    install -m 0644 ${WORKDIR}/raspberrypi-rauc-retro.rules ${D}${sysconfdir}/udev/mount.blacklist.d/
}
