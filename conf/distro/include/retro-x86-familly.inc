RETROARCH_PREFERRED_KERNEL_FOR_X86 ?= "linux-yocto"

DISTROOVERRIDES_append_x86 = ":x86-common"
DISTROOVERRIDES_append_x86-64 = ":x86-common"
RETRO_FEATURES_append_x86-common = " retroarch-opengl"

PREFERRED_PROVIDER_virtual/kernel_x86-common = "${RETROARCH_PREFERRED_KERNEL_FOR_X86}"

MESA_X86_PREFERRED_DRIVERS ?= "gallium gallium-llvm nouveau i915 iris r300 r600 radeonsi"

PACKAGECONFIG_append_pn-mesa_x86-common = " ${MESA_X86_PREFERRED_DRIVERS}"
