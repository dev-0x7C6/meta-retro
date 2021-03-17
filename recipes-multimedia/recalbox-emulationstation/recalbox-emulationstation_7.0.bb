LICENSE = "MIT"
LIC_FILES_CHKSUM="file://LICENSE.md;md5=a1de4af539197c968484564e2632ac9e"

inherit cmake

SRCREV = "7.0-Reloaded"
SRC_URI = "gitsm://gitlab.com/recalbox/recalbox-emulationstation.git;protocol=https;branch=master \
           file://0001-Fixed-missing-string-include.patch \
           "
S = "${WORKDIR}/git"

DEPENDS = " \
  boost \
  curl \
  freeimage \
  freetype \
  ffmpeg \
  libzip \
  libeigen \
  libsdl2 \
  libsdl2-mixer \
  rapidjson \
"

PACKAGECONFIG_rpi ??= " \
  gles \
  rpi \
"

PACKAGECONFIG ??= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'gl', '', d)} \
"

PACKAGECONFIG[cec] = "-DCEC=ON,-DCEC=OFF,libcec"
PACKAGECONFIG[gl] = "-DGL=ON,-DGL=OFF"
PACKAGECONFIG[gles] = "-DGLES=ON,-DGLES=OFF,virtual/egl"
PACKAGECONFIG[rpi] =  "-DRPI=ON,-DRPI=OFF,userland"
