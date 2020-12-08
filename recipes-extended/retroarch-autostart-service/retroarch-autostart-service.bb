SUMMARY = "Systemd service for RetroArch"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit retro-user systemd

PV = "1.0"

SRC_URI = "file://retroarch.service.in"

SYSTEMD_SERVICE_${PN} = "retroarch.service"

do_compile() {
    sed -e 's/@@RETRO_USER_NAME@@/${RETRO_USER_NAME}/' \
        "${WORKDIR}/retroarch.service.in" > "${WORKDIR}/retroarch.service"
}

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/retroarch.service ${D}${systemd_unitdir}/system/
}
