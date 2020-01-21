SUMMARY = "Vulkan GLSL RetroArch shader system"
DESCRIPTION = "RetroArch is still expected to run on GLES2 and GL2 systems. \
GL2 is mostly not relevant any longer, but GLES2 is certainly a very relevant \
platform still and having GLES2 compatibility makes GL2 very easy. \
We therefore want to avoid speccing out a design which deliberately \
ruins GLES2 compatibility."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/slang-shaders/issues"

LICENSE = "CLOSED"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/slang-shaders.git;protocol=https"
SRCREV = "${AUTOREV}"

inherit retroarch-paths

FILES_${PN} += "${RETROARCH_SHADERS_DIR}"

do_install() {
  install -d ${D}${RETROARCH_SHADERS_DIR}

  rm -f ${S}/Makefile \
    ${S}/README.md \
    ${S}/configure

  cp -fr ${S}/* ${D}${RETROARCH_SHADERS_DIR}
}
