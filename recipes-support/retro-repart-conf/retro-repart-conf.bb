DESCRIPTION = "System partition layout configuration for system-repart"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://10-home.conf"

inherit systemd feature-check

REQUIRED_COMBINED_FEATURES = "gpt"

do_install() {
  install -d ${D}${sysconfdir}/repart.d/
  install -m 0644 ${WORKDIR}/10-home.conf ${D}${sysconfdir}/repart.d/
}