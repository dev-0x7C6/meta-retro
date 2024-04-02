inherit core-image retro-user

require classes/include/retro-core-image-debug.inc
require classes/include/retro-core-image-development.inc
require classes/include/retro-core-image-raspberrypi.inc
require classes/include/retro-core-image-rauc.inc

RETRO_WAYLAND_COMPOSITOR ??= "weston"

IMAGE_INSTALL:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'polkit systemd', 'rtkit', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retro-home-resize', 'retro-repart-conf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-automount', 'udev-extraconf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-autostart systemd', 'retroarch-service', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-firmware', 'firmware-libretro', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'samba', 'samba samba-base', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '${RETRO_WAYLAND_COMPOSITOR}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'zeroconf', 'avahi-daemon avahi-dnsconfd', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'kodi rauc resize-helper polkit', d)} \
    kernel-modules \
    packagegroup-libretro-cores \
    retro-cpufreq-tune \
    mesa-megadriver \
    mesa-vulkan-drivers \
    retroarch \
    retroarch-cg-shaders \
    retroarch-glsl-shaders \
    retroarch-slang-shaders \
"

IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' + 4096', '' ,d)}"
