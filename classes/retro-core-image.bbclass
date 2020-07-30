inherit core-image

IMAGE_INSTALL_append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'kodi', 'kodi', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-automount', 'udev-extraconf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-firmware', 'firmware-libretro', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'retroarch-service', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', '', d)} \
    ${RETRO_ADDITIONAL_MULTIMEDIA_PACKAGES} \
    kernel-modules \
    packagegroup-core-boot \
    packagegroup-libretro-cores \
    retro-user \
    retroarch \
"

IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' + 4096', '' ,d)}"
