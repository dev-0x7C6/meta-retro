MESA_ARM_PREFERRED_DRIVERS ?= "etnaviv freedreno lima panfrost"

DISTROOVERRIDES:append:aarch64 = ":arm-common"
DISTROOVERRIDES:append:aarch64_be = ":arm-common"
DISTROOVERRIDES:append:arm = ":arm-common"
DISTROOVERRIDES:append:armeb = ":arm-common"

PACKAGECONFIG:append:pn-mesa:arm-common = " ${MESA_ARM_PREFERRED_DRIVERS}"
PACKAGECONFIG:remove:pn-mesa:arm-common = "va vdpau"

VAAPISUPPORT:arm-common = "0"
VDPAUSUPPORT:arm-common = "0"
