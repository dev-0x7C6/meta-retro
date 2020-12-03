MAINTAINER = "Bartłomiej Burdukiewicz <bartlomiej.burdukiewicz@gmail.com>"

DISTRO_FEATURES_BACKFILL_remove = "pulseaudio gobject-introspection-data ldconfig"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"

VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

DISTROOVERRIDES =. "${@bb.utils.contains('DISTRO_FEATURES', 'rauc', 'rauc-integration:', '', d)}"

SANITY_TESTED_DISTROS_append = "gentoo \n"