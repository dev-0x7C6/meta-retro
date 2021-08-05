FILESEXTRAPATHS:prepend:rpi:retro := "${THISDIR}/files:"
SRC_URI:append:rpi_retro = " file://raspberrypi-rauc-retro.rules"

do_install:append:rpi_retro() {
    install -m 0644 ${WORKDIR}/raspberrypi-rauc-retro.rules ${D}${sysconfdir}/udev/mount.blacklist.d/
}
