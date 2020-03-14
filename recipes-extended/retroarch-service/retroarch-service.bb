SUMMARY = "Systemd service for RetroArch"

PR = "r110"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://retroarch.service"

inherit retro-user-defaults

FILES_${PN} = "${systemd_user_unitdir} ${RETRO_USER_HOMEDIR}"

do_install() {
    install -d ${D}${systemd_user_unitdir}
    install -m 0644 ${WORKDIR}/retroarch.service ${D}${systemd_user_unitdir}

    if ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-autostart', 'true', 'false', d)}; then
        install -d ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}
        ln -fs ${systemd_user_unitdir}/retroarch.service ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}/retroarch.service
        chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
    fi
}
