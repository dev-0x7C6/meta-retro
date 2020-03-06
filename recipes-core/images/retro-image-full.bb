DESCRIPTION = "RetroArch minimal image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image

IMAGE_INSTALL_append = " \
  kernel-modules \
  packagegroup-core-boot \
  packagegroup-retroarch \
  packagegroup-standalone-emulators \
  retroarch-assets-xmb-monochrome \
  retroarch-assets-xmb-pixel \
  retroarch-autoconfig \
  retroarch-database-cheats \
  retroarch-database-cursors \
  retroarch-database-titles \
  retroarch-libretro-info \
  retroarch-overlays \
  retroarch-shaders \
  retroarch-user \
"

IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
