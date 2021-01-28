SUMMARY = "Libretro Cg shaders"
DESCRIPTION = "Collection of commonly used Cg shaders. \
These shaders are usable by either HLSL and/or Cg runtime compilers. \
The cg2glsl script will translate most of these into GLSL shaders."

HOMEPAGE = "https://github.com/libretro/common-shaders"
BUGTRACKER = "https://github.com/libretro/common-shaders/issues"

LICENSE = "CLOSED"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/common-shaders.git;protocol=https"
SRCREV = "${AUTOREV}"

inherit allarch libretro-version retroarch-paths

do_configure[noexec] = "1"
do_compile[noexec] = "1"

FILES_${PN} += "${RETROARCH_SHADERS_DIR}"

do_install() {
  install -m 755 -d ${D}${RETROARCH_SHADERS_DIR}/cg

  rm -f ${S}/Makefile \
    ${S}/README.md \
    ${S}/configure

  cp -R --no-dereference --preserve=mode,links -v ${S}/* ${D}${RETROARCH_SHADERS_DIR}/cg
}
