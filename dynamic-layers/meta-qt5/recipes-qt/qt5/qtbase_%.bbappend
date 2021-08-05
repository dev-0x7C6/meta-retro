PACKAGECONFIG:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'gl', 'gles2', d)} \
    eglfs \
    fontconfig \
    freetype \
    gbm \
    glib \
    kms \
    widgets \
"

RDEPENDS:${PN} = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
"