DESCRIPTION = "Sega 8/16 bit emu - picodrive arm optimised libretro core"

LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=4613340462793d879916d43aa44d4236"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/picodrive.git"

do_compile() {
  if [ ! -z "${LIBRETRO_MAKEFILE_PREFIX}" ]; then
    echo "prefix changed: ${LIBRETRO_MAKEFILE_PREFIX}"
    cd ${LIBRETRO_MAKEFILE_PREFIX}
  fi
  
  if [ "${TUNE_ARCH}" = "arm" ]; then
    oe_runmake -f Makefile.libretro platform=armv
  elif [ "${TUNE_ARCH}" = "aarch64" ]; then
    oe_runmake -f Makefile.libretro platform=aarch64
  else   
    oe_runmake -f Makefile.libretro ${LIBRETRO_FINAL_MAKEFLAGS} \
    ARCH=${LIBRETRO_CPU_ARCH} \
    ARM="${IS_ARM_ARCH}" \
    CPU_ARCH=${TUNE_ARCH}
  fi
}
