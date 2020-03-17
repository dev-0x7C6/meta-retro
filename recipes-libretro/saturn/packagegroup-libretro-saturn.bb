DESCRIPTION = "Libretro Sega Saturn cores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit retro/overrides packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

LIBRETRO_SATURN_CORES ?= " \
    beetle-saturn-libretro \
    yabause-libretro \
"

LIBRETRO_SATURN_CORES_remove_arm64 = "yabause-libretro"

RRECOMMENDS_${PN} = "${LIBRETRO_SATURN_CORES}"
