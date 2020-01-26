OVERRIDES_append = "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', ':opengles:gles', '', d)}"
OVERRIDES_append = "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', ':opengles:gles3', '0', d)}"
