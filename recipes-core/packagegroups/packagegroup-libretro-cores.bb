DESCRIPTION = "Libretro cores package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r5"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit common-overrides packagegroup

LIBRETRO_CORE_PACKAGES_append_64bit = " dolphin-libretro"

PACKAGECONFIG ??= "atari arcade dc gba gbc n64 psx snes"

LIBRETRO_ATARI_CORES ?= " \
  atari800-libretro \
  beetle-lynx-libretro \
  hatari-libretro \
  prosystem-libretro \
  stella2014-libretro \
  virtualjaguar-libretro \
"

LIBRETRO_ARCADE_CORES ?= "mame2000-libretro mame2003-libretro mame2003-plus-libretro"
LIBRETRO_DC_CORES ?= "flycast-libretro"
LIBRETRO_GBA_CORES ?= "beetle-gba-libretro mgba-libretro vba-next-libretro"
LIBRETRO_GBC_CORES ?= "gambatte-libretro tgbdual-libretro"
LIBRETRO_N64_CORES ?= "mupen64plus-libretro parallel-n64-libretro"
LIBRETRO_PSX_CORES ?= "pcsx-rearmed-libretro"
LIBRETRO_SNES_CORES ?= "snes9x2002-libretro snes9x2005-libretro snes9x2010-libretro"

PACKAGECONFIG[arcade] = ",,,,${LIBRETRO_ARCADE_CORES}"
PACKAGECONFIG[atari] = ",,,,${LIBRETRO_ATARI_CORES}"
PACKAGECONFIG[gba] = ",,,,${LIBRETRO_GBA_CORES}"
PACKAGECONFIG[gbc] = ",,,,${LIBRETRO_GBC_CORES}"
PACKAGECONFIG[n64] = ",,,,${LIBRETRO_N64_CORES}"
PACKAGECONFIG[psx] = ",,,,${LIBRETRO_PSX_CORES}"
PACKAGECONFIG[snes] = ",,,,${LIBRETRO_SNES_CORES}"

# TODO: compilation of those failed on specific architectures:

LIBRETRO_CORE_PACKAGES_remove_arm64 = " \
  dosbox-libretro \
  yabause-libretro \
"

LIBRETRO_MAME_CORES_remove_arm64 = "parallel-n64-libretro"
LIBRETRO_N64_CORES_remove_arm64 = "mame2000-libretro"

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
