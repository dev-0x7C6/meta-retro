inherit retro-user

PACKAGES += "pulseaudio-user-service"
FILES:${PN}-user-service = "${RETRO_USER_DEFAULT_TARGET_WANTS} ${RETRO_USER_SOCKETS_TARGET_WANTS}"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'true', 'false', d)}; then
        install -d ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}
        install -d ${D}${RETRO_USER_SOCKETS_TARGET_WANTS}
        if ${@bb.utils.contains('DISTRO_FEATURES', 'pipewire', 'true', 'false', d)}; then
            ln -fs ${systemd_user_unitdir}/pipewire-pulse.service ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}/pipewire-pulse.service
            ln -fs ${systemd_user_unitdir}/pipewire-pulse.socket ${D}${RETRO_USER_SOCKETS_TARGET_WANTS}/pipewire-pulse.socket
            ln -fs ${systemd_user_unitdir}/pipewire.service ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}/pipewire.service
            ln -fs ${systemd_user_unitdir}/pipewire.socket ${D}${RETRO_USER_SOCKETS_TARGET_WANTS}/pipewire.socket
            ln -fs ${systemd_user_unitdir}/pipewire-media-session.service ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}/pipewire-media-session.service
        else
            ln -fs ${systemd_user_unitdir}/pulseaudio.service ${D}${RETRO_USER_DEFAULT_TARGET_WANTS}/pulseaudio.service
            ln -fs ${systemd_user_unitdir}/pulseaudio.socket ${D}${RETRO_USER_SOCKETS_TARGET_WANTS}/pulseaudio.socket
        fi
        chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}/
    fi
}
