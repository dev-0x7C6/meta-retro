inherit core-image

IMAGE_INSTALL_append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-automount', 'udev-extraconf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'retroarch-service', '', d)} \
    ${RETRO_ADDITIONAL_MULTIMEDIA_PACKAGES} \
    kernel-modules \
    networkmanager \
    packagegroup-core-boot \
    packagegroup-libretro-cores \
    retro-user \
    retroarch \
"

IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"