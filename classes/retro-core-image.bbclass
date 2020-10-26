inherit core-image

IMAGE_FSTYPES += "ext4"

SPLASH_rpi = "psplash-raspberrypi"

RETRO_IMAGE_INSTALL_DEBUG_TWEAKS ?= " \
    alsa-utils \
    bzip2 \
    elfutils \
    gptfdisk \
    hdparm \
    htop \
    iotop \
    mc \
    net-tools \
    strace \
    tar \
    util-linux \
    vim \
    wget \
"

RETRO_IMAGE_FEATURES_FOR_DEBUG_TWEAKS ?= "ssh-server-dropbear"
RETRO_CORE_IMAGE_EXTRA ?= ""

IMAGE_FEATURES += "${RETRO_IMAGE_FEATURES_FOR_DEBUG_TWEAKS} splash"

IMAGE_INSTALL_append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-automount', 'udev-extraconf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-firmware', 'firmware-libretro', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'retroarch-service', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', '', d)} \
    ${@bb.utils.contains('EXTRA_IMAGE_FEATURES', 'debug-tweaks', '${RETRO_IMAGE_INSTALL_DEBUG_TWEAKS}', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'kodi rauc', d)} \
    ${RETRO_ADDITIONAL_MULTIMEDIA_PACKAGES} \
    ${RETRO_CORE_IMAGE_EXTRA} \
    cool-retro-term \
    kernel-modules \
    packagegroup-core-boot \
    packagegroup-libretro-cores \
    retro-menu \
    retro-user \
    retroarch \
"

IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' + 4096', '' ,d)}"
