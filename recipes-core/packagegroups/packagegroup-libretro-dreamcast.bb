DESCRIPTION = "Libretro Dreamcast cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

LIBRETRO_DREAMCAST_CORES ?= "flycast-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_DREAMCAST_CORES}"
