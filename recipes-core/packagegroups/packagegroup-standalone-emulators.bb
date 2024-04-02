DESCRIPTION = "Standalone emulators package group"

inherit retro-packagegroup

EMULATOR_PACKAGES ?= ""
#EMULATOR_PACKAGES:append:64bit = " dolphin-emu"

RDEPENDS:${PN} = "${EMULATOR_PACKAGES}"
