# Classes

inherit retro-overrides
inherit retroarch-checks
inherit retroarch-paths

require files/libretro-git-fetcher.inc
require files/libretro-tested-revs.inc

inherit cmake

# Variables

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "/usr/bin"
CCACHE_DISABLE = "1"

LIBRETRO_CORE_SOURCE_PATH ?= ""
LIBRETRO_CORE_FILENAME ?= "${LIBRETRO_CORE}_libretro.so"

# Depends

DEPENDS += " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'virtual/libgles2 virtual/egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'virtual/libgles2 virtual/egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'vulkan-loader', '', d)} \
  zlib \
"

RDEPENDS_${PN} += " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'vulkan-loader', '', d)} \
"

# Installation

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_DIR}"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${B}/${LIBRETRO_CORE_SOURCE_PATH}/${LIBRETRO_CORE_FILENAME} ${D}${RETROARCH_LIBRETRO_CORES_DIR}/
}
