
DESCRIPTION = "Rauc update bundle that contains retro-image-full system"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

inherit bundle

SRC_URI += "file://hook.sh"

RAUC_BUNDLE_COMPATIBLE = "${MACHINE}-${DISTRO}"

RAUC_BUNDLE_HOOKS[file] ?= "hook.sh"
RAUC_BUNDLE_SLOTS = "rootfs"

RETRO_RAUC_KEY_FILE ?= "${THISDIR}/test.key.pem"
RETRO_RAUC_CERT_FILE ?= "${THISDIR}/test.cert.pem"

RAUC_KEY_FILE ?= "${RETRO_RAUC_KEY_FILE}"
RAUC_CERT_FILE ?= "${RETRO_RAUC_CERT_FILE}"

RAUC_SLOT:rootfs = "retro-image-full"
RAUC_SLOT:rootfs[fstype] = "ext4"
RAUC_SLOT:rootfs[hooks] ?= "post-install"

BUNDLE_ARGS += "--mksquashfs-args="-comp lzo""