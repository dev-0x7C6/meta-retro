inherit bundle

LICENSE = "MIT"

RAUC_BUNDLE_SLOTS = "rootfs"

RETRO_RAUC_KEY_FILE ?= "${THISDIR}/key.pem.example"
RETRO_RAUC_CERT_FILE ?= "${THISDIR}/cert.pem.example"

RAUC_KEY_FILE ?= "${RETRO_RAUC_KEY_FILE}"
RAUC_CERT_FILE ?= "${RETRO_RAUC_CERT_FILE}"

RAUC_SLOT_rootfs = "retro-image-full"
