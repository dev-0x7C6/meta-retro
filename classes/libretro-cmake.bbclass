# Classes

inherit retro-overrides
inherit retroarch-checks
inherit retroarch-paths

require files/libretro-git-fetcher.inc
require files/libretro-tested-revs.inc

inherit cmake

SECTION = "emulators"

# Variables

LIBRETRO_CORE ?= "${@d.getVar("PN").split('-libretro')[0].replace('-', '_')}"

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"
CCACHE_DISABLE = "1"

LIBRETRO_CORE_SOURCE_PATH ?= ""
LIBRETRO_CORE_FILENAME ?= "${LIBRETRO_CORE}_libretro.so"

# Flags

inherit libretro-cflags

# Depends

inherit libretro-vulkan-deps

DEPENDS += " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'virtual/libgles2 virtual/egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'virtual/libgles2 virtual/egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl', '', d)} \
  zlib \
"

# Installation

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_DIR}"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${B}/${LIBRETRO_CORE_SOURCE_PATH}/${LIBRETRO_CORE_FILENAME} ${D}${RETROARCH_LIBRETRO_CORES_DIR}/
}
