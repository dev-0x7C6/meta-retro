DESCRIPTION = "Standalone emulators package group"

inherit retro/packagegroup

EMULATOR_PACKAGES ?= ""
EMULATOR_PACKAGES_append_64bit = " dolphin-emu"

RDEPENDS_${PN} = "${EMULATOR_PACKAGES}"
