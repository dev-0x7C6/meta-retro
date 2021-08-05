SUMMARY = "Libretro Cg shaders"
DESCRIPTION = "Collection of commonly used Cg shaders. \
These shaders are usable by either HLSL and/or Cg runtime compilers. \
The cg2glsl script will translate most of these into GLSL shaders."

HOMEPAGE = "https://github.com/libretro/common-shaders"
BUGTRACKER = "https://github.com/libretro/common-shaders/issues"

LICENSE = "CLOSED"

SRC_URI = "gitsm://github.com/libretro/common-shaders.git;protocol=https"

require include/retroarch-shaders.inc

FILES:${PN} += "${RETROARCH_SHADERS_DIR}"

do_install() {
  install -m 755 -d ${D}${RETROARCH_SHADERS_DIR}/cg
  cp -R --no-dereference --preserve=mode,links -v ${S}/* ${D}${RETROARCH_SHADERS_DIR}/cg
}
