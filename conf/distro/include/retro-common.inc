MAINTAINER = "Bartłomiej Burdukiewicz <bartlomiej.burdukiewicz@gmail.com>"

RETRO_FEATURES ?= "retroarch-automount retroarch-autostart retroarch-firmware retroarch-gles retroarch-gles3 usrmerge"

DISTRO_FEATURES_BACKFILL:remove = "pulseaudio gobject-introspection-data ldconfig"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"

VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

DISTROOVERRIDES:prepend = "${@bb.utils.contains('DISTRO_FEATURES', 'rauc', 'rauc-integration:', '', d)}"
DISTROOVERRIDES:prepend = "${@bb.utils.contains('DISTRO_FEATURES', 'libretro-latest', 'libretro-latest:', '', d)}"

SANITY_TESTED_DISTROS:append = "gentoo \n"
