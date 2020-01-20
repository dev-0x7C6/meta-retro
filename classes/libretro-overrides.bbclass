OVERRIDES_append = "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', ':gles', '', d)}"
OVERRIDES_append = "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', ':gles3', '0', d)}"
