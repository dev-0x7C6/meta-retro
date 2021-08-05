FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RETRO_UBOOT_NO_DELAY ?= "1"

OVERRIDES .= "${@bb.utils.contains_any('MACHINE', 'raspberrypi4 raspberrypi4-64', ':rpi4', '', d)}"

SRC_URI += "${@bb.utils.contains('RETRO_UBOOT_NO_DELAY', '1', 'file://no-boot-delay.cfg', '', d)}"
SRC_URI:append:rpi4 = " file://disable-xhci-pci.cfg"
