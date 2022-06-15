FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wlan.network"

FILES:${PN} += "${sysconfdir}/systemd/network/wlan.network"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
}