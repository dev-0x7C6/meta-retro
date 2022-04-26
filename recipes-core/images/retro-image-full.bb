DESCRIPTION = "RetroArch full image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit retro-core-image

IMAGE_INSTALL += " \
  retroarch-assets \
  retroarch-autoconfig \
  retroarch-database \
  retroarch-libretro-info \
  retroarch-overlays \
  packagegroup-standalone-emulators \
"
