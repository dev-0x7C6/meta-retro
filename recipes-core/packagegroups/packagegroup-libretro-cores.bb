DESCRIPTION = "Libretro cores package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r5"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit common-overrides packagegroup

LIBRETRO_CORE_PACKAGES_append_64bit = " dolphin-libretro"

PACKAGECONFIG ??= "arcade atari dreamcast gba gbc n64 psx snes"

PACKAGECONFIG[arcade] = ",,,,packagegroup-libretro-arcade"
PACKAGECONFIG[atari] = ",,,,packagegroup-libretro-atari"
PACKAGECONFIG[dreamcast] = ",,,,packagegroup-libretro-dreamcast"
PACKAGECONFIG[gba] = ",,,,packagegroup-libretro-gba"
PACKAGECONFIG[gbc] = ",,,,packagegroup-libretro-gbc"
PACKAGECONFIG[n64] = ",,,,packagegroup-libretro-n64"
PACKAGECONFIG[psx] = ",,,,packagegroup-libretro-psx"
PACKAGECONFIG[snes] = ",,,,packagegroup-libretro-snes"

# TODO: compilation of those failed on specific architectures:

LIBRETRO_CORE_PACKAGES_remove_arm64 = " \
  dosbox-libretro \
  yabause-libretro \
"

LIBRETRO_CORE_PACKAGES ?= " \
  81-libretro \
  beetle-ngp-libretro \
  beetle-pce-fast-libretro \
  beetle-pcfx-libretro \
  beetle-saturn-libretro \
  beetle-supergrafx-libretro \
  beetle-vb-libretro \
  beetle-wswan-libretro \
  bk-libretro \
  bluemsx-libretro \
  caprice32-libretro \
  dosbox-libretro \
  fbalpha2012-libretro \
  fceumm-libretro \
  fmsx-libretro \
  freechaf-libretro \
  freeintv-libretro \
  fuse-libretro \
  genesis-plus-gx-libretro \
  gw-libretro \
  neocd-libretro \
  nestopia-libretro \
  np2kai-libretro \
  nxengine-libretro \
  o2em-libretro \
  opera-libretro \
  pokemini-libretro \
  ppsspp-libretro \
  quicknes-libretro \
  vecx-libretro \
  yabause-libretro \
"

RRECOMMENDS_${PN}_append = " ${LIBRETRO_CORE_PACKAGES}"
