LICENSE = "MIT"
LIC_FILES_CHKSUM="file://LICENSE.md;md5=a1de4af539197c968484564e2632ac9e"

inherit cmake

SRCREV = "v${PV}"
SRC_URI = "gitsm://github.com/RetroPie/EmulationStation.git;protocol=https;branch=stable"
S = "${WORKDIR}/git"

DEPENDS = " \
  boost \
  curl \
  freeimage \
  freetype \
  libeigen \
  libsdl2 \
  rapidjson \
  vlc \
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
