SUMMARY = "Systemd service for RetroArch"

PR = "r100"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://retroarch.service"

inherit systemd

# We need retroarch user for this service to run
RDEPENDS_${PN} += "retroarch-user"

SYSTEMD_SERVICE_${PN} = "retroarch.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/retroarch.service ${D}${systemd_unitdir}/system
}
