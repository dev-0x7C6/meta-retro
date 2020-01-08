LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r2"

PACKAGECONFIG ??= "assets"
PACKAGECONFIG[assets] = ",,"

RDEPENDS_${PN} = " \
  ${@bb.utils.contains('PACKAGECONFIG', 'assets', 'retroarch-assets', '', d)} \
  libretro-bundle \
  retroarch \
"

ALLOW_EMPTY_${PN} = "1"
