inherit retro-user

FILES:${PN}-server += "${RETRO_USER_DEFAULT_TARGET_WANTS} ${RETRO_USER_SOCKETS_TARGET_WANTS}"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'true', 'false', d)}; then
        install -d ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}
        install -d ${D}${RETRO_USER_SOCKETS_TARGET_WANTS}

        ln -fs ${systemd_user_unitdir}/pulseaudio.service ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}/pulseaudio.service
        ln -fs ${systemd_user_unitdir}/pulseaudio.socket ${D}${RETRO_USER_SOCKETS_TARGET_WANTS}/pulseaudio.socket

        chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}/
    fi
}

INSANE_SKIP:${PN}-server += "host-user-contaminated"
