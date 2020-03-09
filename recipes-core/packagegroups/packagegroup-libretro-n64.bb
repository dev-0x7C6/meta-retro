DESCRIPTION = "Libretro Nintendo 64 cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit common-overrides packagegroup

LIBRETRO_N64_CORES ?= " \
  mupen64plus-libretro \
  parallel-n64-libretro \
"

LIBRETRO_N64_CORES_remove_arm64 = "parallel-n64-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_N64_CORES}"
