DESCRIPTION = "RetroArch package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r3"

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
  beetle-gba-libretro \
  beetle-psx-libretro \
  dosbox-libretro \
  fceumm-libretro \
  genesis-plus-gx-libretro \
  mame2000-libretro \
  mame2003-libretro \
  mame2003-plus-libretro \
  mgba-libretro \
  mupen64plus-libretro \
  snes9x2002-libretro \
  snes9x2005-libretro \
  snes9x2010-libretro \
  vba-next-libretro \
"

RDEPENDS_${PN} = " \
  ${LIBRETRO_CORE_PACKAGES} \
  ${RETROARCH_PACKAGES} \
"
