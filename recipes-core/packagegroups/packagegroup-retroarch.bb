DESCRIPTION = "RetroArch package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r4"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit retroarch-overrides packagegroup

PACKAGECONFIG ??= "assets user"

PACKAGECONFIG[assets] = ",,"
PACKAGECONFIG[user] = ",,"

RETROARCH_ASSETS_PACKAGES ?= " \
  retroarch-assets-xmb-pixel \
  retroarch-assets-xmb-monochrome \
"

RETROARCH_PACKAGES ?= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-automount', 'udev-extraconf', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'retroarch-service', '', d)} \
  ${@bb.utils.contains('PACKAGECONFIG', 'assets', '${RETROARCH_ASSETS_PACKAGES}', '', d)} \
  ${@bb.utils.contains('PACKAGECONFIG', 'user', 'retroarch-user', '', d)} \
  retroarch \
"

LIBRETRO_CORE_PACKAGES_append_armarch = " \
  pcsx-rearmed-libretro \
"

LIBRETRO_CORE_PACKAGES ?= " \
  4do-libretro \
  81-libretro \
  atari800-libretro \
  beetle-gba-libretro \
  beetle-lynx-libretro \
  beetle-ngp-libretro \
  beetle-pce-fast-libretro \
  beetle-pcfx-libretro \
  beetle-psx-libretro \
  beetle-supergrafx-libretro \
  beetle-vb-libretro \
  beetle-wswan-libretro \
  bluemsx-libretro \
  caprice32-libretro \
  dinothawr-libretro \
  dosbox-libretro \
  fbalpha2012-libretro \
  fceumm-libretro \
  fmsx-libretro \
  freechaf-libretro \
  freeintv-libretro \
  fuse-libretro \
  gambatte-libretro \
  genesis-plus-gx-libretro \
  gw-libretro \
  hatari-libretro \
  mame2000-libretro \
  mame2003-libretro \
  mame2003-plus-libretro \
  mgba-libretro \
  mrboom-libretro \
  mupen64plus-libretro \
  np2kai-libretro \
  nxengine-libretro \
  o2em-libretro \
  pokemini-libretro \
  prboom-libretro \
  prosystem-libretro \
  quicknes-libretro \
  snes9x2002-libretro \
  snes9x2005-libretro \
  snes9x2010-libretro \
  stella2014-libretro \
  tgbdual-libretro \
  tyrquake-libretro \
  vba-next-libretro \
  vecx-libretro \
  virtualjaguar-libretro \
"

RDEPENDS_${PN} = " \
  ${LIBRETRO_CORE_PACKAGES} \
  ${RETROARCH_PACKAGES} \
"
