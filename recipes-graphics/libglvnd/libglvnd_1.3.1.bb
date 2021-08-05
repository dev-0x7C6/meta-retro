# Imported from meta-tegra

DESCRIPTION = "libglvnd is a vendor-neutral dispatch layer for arbitrating OpenGL API calls between multiple vendors."
HOMEPAGE = "https://gitlab.freedesktop.org/glvnd/libglvnd"
LICENSE = "MIT & BSD & GPL-3.0-with-autoconf-exception"
LIC_FILES_CHKSUM = "file://README.md;beginline=323;md5=f98ec0fbe6c0d2fbbd0298b5d9e664d3"

SRC_URI = "git://gitlab.freedesktop.org/glvnd/libglvnd.git;protocol=https"
SRCREV = "1c32de07074fee8edcb274899948b6551081ed54"

REQUIRED_DISTRO_FEATURES = "opengl"
PROVIDES += "virtual/egl virtual/libgl virtual/libgles1 virtual/libgles2"

inherit autotools pkgconfig features_check python3native

S = "${WORKDIR}/git"

PACKAGECONFIG ?= "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
"

PACKAGECONFIG[x11] = "--enable-x11 --enable-glx,--disable-x11 --disable-glx,libx11 libxext xorgproto"
#PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland"

do_install:append() {

    ## no-X11 hack included from mesa:
    #because we cannot rely on the fact that all apps will use pkgconfig,
    #make eglplatform.h independent of EGL_NO_X11
    # If necessary, fix up pkgconfig anyhow, for the benefit of SDK users
    if ${@bb.utils.contains('PACKAGECONFIG', 'x11', 'false', 'true', d)}; then
        sed -i -e 's!^#elif \(defined(__unix__) && defined(EGL_NO_X11)\)$!#elif  1 /* \1 */!' ${D}${includedir}/EGL/eglplatform.h
        sed -i -e 's|^Cflags: .*|& -DEGL_NO_X11|g' ${D}${libdir}/pkgconfig/libglvnd.pc ${D}${libdir}/pkgconfig/egl.pc
    fi
}

BBCLASSEXTEND = "native nativesdk"

RPROVIDES:${PN} += "libegl libgl libgles1 libgles2"
RPROVIDES:${PN}-dev += "libegl-dev libgl-dev libgles1-dev libgles2-dev"
RCONFLICTS:${PN} = "libegl libgl ligbles1 libgles2"
RCONFLICTS:${PN}-dev += "libegl-dev libgl-dev libgles1-dev libgles2-dev"
RREPLACES:${PN} = "libegl libgl libgles1 ligbles2"
RREPLACES:${PN}-dev += "libegl-dev libgl-dev libgles1-dev libgles2-dev"

RRECOMMENDS:${PN} += "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'egl-wayland', '', d)}"
