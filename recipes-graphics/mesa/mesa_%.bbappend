EXTRA_OEMESON_append_glvnd = " -Dglvnd=true"
DEPENDS_append_glvnd = " libglvnd"
PROVIDES_glvnd = "virtual/mesa virtual/libgbm"

# Workaround for the do_install_append() present in the OE-Core recipe
do_install_prepend_glvnd() {
    install -d ${D}${includedir}/EGL
    touch ${D}${includedir}/EGL/eglplatform.h
}

do_install_append_glvnd() {
    rm -rf ${D}${includedir}/EGL
}

FILES_libegl-mesa_append_glvnd = " ${libdir}/libEGL_mesa.so.* ${datadir}/glvnd"
FILES_libegl-mesa-dev_append_glvnd = " ${libdir}/libEGL_mesa.so"
FILES_libgl-mesa_append_glvnd = " ${libdir}/libGLX_mesa.so.*"
FILES_libgl-mesa-dev_append_glvnd = " ${libdir}/libGLX_mesa.so"

python __anonymous() {
    if "tegra" not in d.getVar('OVERRIDES').split(':'):
        return
    pkgconfig = (d.getVar('PACKAGECONFIG') or '').split();
    for p in (("egl", "libegl", "libegl1"),
              ("dri", "libgl", "libgl1"),
              ("gles", "libgles1", "libglesv1-cm1"),
              ("gles", "libgles2", "libglesv2-2"),
              ("gles", "libgles3",)):
        if not p[0] in pkgconfig:
            continue
        fullp = p[1] + "-mesa"
        d.delVar("RREPLACES_" + fullp)
        d.delVar("RPROVIDES_" + fullp)
        d.delVar("RCONFLICTS_" + fullp)

        # For -dev, the first element is both the Debian and original name
        fullp += "-dev"
        d.delVar("RREPLACES_" + fullp)
        d.delVar("RPROVIDES_" + fullp)
        d.delVar("RCONFLICTS_" + fullp)
}
