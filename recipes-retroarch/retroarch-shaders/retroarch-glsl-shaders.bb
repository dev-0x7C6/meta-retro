SUMMARY = "Retroarch GLSL shaders"
DESCRIPTION = "This repo is for glsl shaders converted by hand from libretro's \
common-shaders repo, since some don't play nicely with the cg2glsl script.y."

HOMEPAGE = "https://github.com/libretro/glsl-shaders"
BUGTRACKER = "https://github.com/libretro/glsl-shaders/issues"

LICENSE = "CLOSED"

SRC_URI = "gitsm://github.com/libretro/glsl-shaders.git"

require include/retroarch-shaders.inc

FILES:${PN} += "${RETROARCH_SHADERS_DIR}"

do_install() {
  install -m 755 -d ${D}${RETROARCH_SHADERS_DIR}/glsl
  cp -R --no-dereference --preserve=mode,links -v ${S}/* ${D}${RETROARCH_SHADERS_DIR}/glsl
}
