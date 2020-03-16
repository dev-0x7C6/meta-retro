DESCRIPTION = "Libretro extra cores package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit retro/overrides packagegroup

LIBRETRO_EXTRA_CORE_PACKAGES ?= " \
  dinothawr-libretro \
  mrboom-libretro \
  prboom-libretro \
  superflappybirds-libretro \
  tyrquake-libretro \
"

RDEPENDS_${PN} = "${LIBRETRO_EXTRA_CORE_PACKAGES}"
