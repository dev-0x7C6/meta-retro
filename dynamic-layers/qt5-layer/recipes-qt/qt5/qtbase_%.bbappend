PACKAGECONFIG_append = " gbm eglfs kms gles2 widgets"

RDEPENDS_${PN} = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
"