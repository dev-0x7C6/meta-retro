PACKAGECONFIG_append = " gbm eglfs kms gles2 widgets freetype fontconfig glib"

RDEPENDS_${PN} = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
"