SUMMARY = "Retro default user"
DESCRIPTION = "Dedicated user"

PR = "r8"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit retro/user useradd systemd

RDEPENDS_${PN} = "bash"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
  --create-home \
  --user-group \
  --groups ${RETRO_USER_GROUPS} \
  --uid ${RETRO_USER_ID} \
  --home ${RETRO_USER_HOMEDIR} \
  --shell /bin/bash \
  -P ${RETRO_USER_PASSWORD} \
  ${RETRO_USER_NAME} \
"

ALLOW_EMPTY_${PN} = "1"
EXCLUDE_FROM_WORLD = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
