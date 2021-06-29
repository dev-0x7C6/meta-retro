MESA_ARM_PREFERRED_DRIVERS ?= "etnaviv freedreno lima panfrost"

DISTROOVERRIDES_append_aarch64 = ":arm-common"
DISTROOVERRIDES_append_aarch64_be = ":arm-common"
DISTROOVERRIDES_append_arm = ":arm-common"
DISTROOVERRIDES_append_armeb = ":arm-common"

PACKAGECONFIG_append_pn-mesa_arm-common = " ${MESA_ARM_PREFERRED_DRIVERS}"

PACKAGECONFIG_remove_pn-mesa_arm-common = "va vdpau"
