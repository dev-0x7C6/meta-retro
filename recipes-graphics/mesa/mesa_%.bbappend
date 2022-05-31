inherit retro-overrides

FILES:${PN} += "${datadir}/drirc.d/00-radv-defaults.conf"

VULKAN_DRIVERS:append:x86arch:class-target = ",amd"
