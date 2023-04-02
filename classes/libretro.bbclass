# Classes

inherit retro-overrides
inherit retroarch-checks
inherit retroarch-paths

require files/libretro-git-fetcher.inc

SECTION = "emulators"

# Core

LIBRETRO_CORE ?= "${@d.getVar("PN").split('-libretro')[0].replace('-', '_')}"
LIBRETRO_MAKEFILE_PREFIX ?= ""

LIBRETRO_CORE_FILE = "${@os.path.basename(d.getVar('LIBRETRO_CORE', d, 1))}"

# Platform

LIBRETRO_PLATFORM ?= "unix"
LIBRETRO_EXTRA_MAKEFLAGS ?= ""

LIBRETRO_REPRESENT_ARM64 ?= "aarch64"
LIBRETRO_REPRESENT_ARM32 ?= "arm"
LIBRETRO_REPRESENT_X86_32 ?= "x86"
LIBRETRO_REPRESENT_X86_64 ?= "x86_64"

LIBRETRO_CPU_ARCH_DETECT = "${TUNE_ARCH}"
LIBRETRO_CPU_ARCH_DETECT:arm64 = "${LIBRETRO_REPRESENT_ARM64}"
LIBRETRO_CPU_ARCH_DETECT:arm32 = "${LIBRETRO_REPRESENT_ARM32}"
LIBRETRO_CPU_ARCH_DETECT:x86 = "${LIBRETRO_REPRESENT_X86_32}"
LIBRETRO_CPU_ARCH_DETECT:x86-64 = "${LIBRETRO_REPRESENT_X86_64}"
LIBRETRO_CPU_ARCH ?= "${LIBRETRO_CPU_ARCH_DETECT}"

# Flags

inherit libretro-cflags

# Features

LIBRETRO_MAKEFILE_HAVE_HARD_FLOAT ?= "ARM_FLOAT_ABI_HARD=${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '1', '0', d)}"
LIBRETRO_MAKEFILE_HAVE_NEON ?= "HAVE_NEON=${@bb.utils.contains('TUNE_FEATURES', 'neon', '1', '0', d)}"
LIBRETRO_MAKEFILE_LIBRETRO_CPU ?= "LIBRETRO_CPU=${LIBRETRO_CPU_ARCH}"
LIBRETRO_MAKEFILE_WITH_DYNAREC ?= "WITH_DYNAREC=${LIBRETRO_CPU_ARCH}"

LIBRETRO_MAKEFILE_ARCHITECTURE_OVERRIDES ?= " \
  ${LIBRETRO_MAKEFILE_HAVE_HARD_FLOAT} \
  ${LIBRETRO_MAKEFILE_HAVE_NEON} \
  ${LIBRETRO_MAKEFILE_LIBRETRO_CPU} \
  ${LIBRETRO_MAKEFILE_WITH_DYNAREC} \
"

LIBRETRO_MAKEFILE_FORCE_GLES ?= "FORCE_GLES=${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', '1', '0', d)}"
LIBRETRO_MAKEFILE_FORCE_GLES3 ?= "FORCE_GLES3=${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', '1', '0', d)}"
LIBRETRO_MAKEFILE_HAVE_OPENGL ?= "HAVE_OPENGL=${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', '1', '0', d)}"
LIBRETRO_MAKEFILE_HAVE_VULKAN ?= "HAVE_VULKAN=${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', '1', '0', d)}"

LIBRETRO_MAKEFILE_GRAPHICS_OVERRIDES ?= " \
  ${LIBRETRO_MAKEFILE_FORCE_GLES} \
  ${LIBRETRO_MAKEFILE_FORCE_GLES3} \
  ${LIBRETRO_MAKEFILE_HAVE_OPENGL} \
  ${LIBRETRO_MAKEFILE_HAVE_VULKAN} \
"

IS_ARM_ARCH ?= "0"
IS_ARM_ARCH:armarch = "1"

LIBRETRO_FINAL_MAKEFLAGS ?= " \
  "platform=${LIBRETRO_PLATFORM}" \
  ${LIBRETRO_MAKEFILE_ARCHITECTURE_OVERRIDES} \
  ${LIBRETRO_MAKEFILE_GRAPHICS_OVERRIDES} \
  ${LIBRETRO_EXTRA_MAKEFLAGS} \
"

inherit libretro-vulkan-deps

DEPENDS:append = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'virtual/libgles2 virtual/egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'virtual/libgles2 virtual/egl', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'virtual/libgl', '', d)} \
  zlib \
"

do_compile() {
  if [ ! -z "${LIBRETRO_MAKEFILE_PREFIX}" ]; then
    echo "prefix changed: ${LIBRETRO_MAKEFILE_PREFIX}"
    cd ${LIBRETRO_MAKEFILE_PREFIX}
  fi

  MAKEFILE_PATH="Makefile";
  [ -f "Makefile.libretro" ] && MAKEFILE_PATH="Makefile.libretro"
  [ -f "makefile.libretro" ] && MAKEFILE_PATH="makefile.libretro"

  oe_runmake -f "${MAKEFILE_PATH}" ${LIBRETRO_FINAL_MAKEFLAGS} \
    ARCH=${LIBRETRO_CPU_ARCH} \
    ARM="${IS_ARM_ARCH}" \
    CPU_ARCH=${TUNE_ARCH}
}

# Some cores provide additional info file
LIBRETRO_INFO_FILE ?= ""

FILES:${PN} += "${RETROARCH_LIBRETRO_CORES_DIR} ${RETROARCH_LIBRETRO_CORES_INFO_DIR}"

do_install() {
# install core
  install -d ${D}${RETROARCH_LIBRETRO_CORES_DIR}
  install -m 644 ${S}/${LIBRETRO_CORE}_libretro.so ${D}${RETROARCH_LIBRETRO_CORES_DIR}/${LIBRETRO_CORE_FILE}_libretro.so

# install core info
  if [ -n "${LIBRETRO_INFO_FILE}" ]; then
    install -d ${D}/${RETROARCH_LIBRETRO_CORES_INFO_DIR}
    install -m 644 ${S}/${LIBRETRO_INFO_FILE} ${D}/${RETROARCH_LIBRETRO_CORES_INFO_DIR}
  fi
}
