RETROARCH_PREFERRED_KERNEL_FOR_X86 ?= "linux-yocto"

DISTROOVERRIDES:append:x86 = ":x86-common"
DISTROOVERRIDES:append:x86-64 = ":x86-common"
RETRO_FEATURES:append:x86-common = " retroarch-opengl"

PREFERRED_PROVIDER:virtual/kernel:x86-common = "${RETROARCH_PREFERRED_KERNEL_FOR_X86}"

MESA_X86_PREFERRED_DRIVERS ?= "gallium gallium-llvm nouveau i915 iris r300 r600 radeonsi"

PACKAGECONFIG:append:pn-mesa:x86-common = " ${MESA_X86_PREFERRED_DRIVERS}"
