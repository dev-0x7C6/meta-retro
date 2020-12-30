inherit core-image

require classes/include/retro-core-image-debug.inc
require classes/include/retro-core-image-development.inc
require classes/include/retro-core-image-raspberrypi.inc
require classes/include/retro-core-image-rauc.inc

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'polkit systemd', 'rtkit', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-automount', 'udev-extraconf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-autostart systemd', 'retroarch-autostart-service', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-firmware', 'firmware-libretro', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'kodi rauc polkit', d)} \
    kernel-modules \
    packagegroup-libretro-cores \
    retro-user \
    retroarch \
"

IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' + 4096', '' ,d)}"
