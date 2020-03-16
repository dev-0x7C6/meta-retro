DESCRIPTION = "Standalone emulators package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r5"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit retro/overrides packagegroup

EMULATOR_PACKAGES ?= ""
EMULATOR_PACKAGES_append_64bit = " dolphin-emu"

RDEPENDS_${PN} = "${EMULATOR_PACKAGES}"
