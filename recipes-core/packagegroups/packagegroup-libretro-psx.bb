DESCRIPTION = "Libretro PlayStation (One) cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

LIBRETRO_PSX_CORES ?= "pcsx-rearmed-libretro"
RRECOMMENDS_${PN} = "${LIBRETRO_PSX_CORES}"
