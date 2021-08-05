MACHINEOVERRIDES =. "${@bb.utils.contains('MACHINE_FEATURES', 'full-kms', 'full-kms:', '', d)}"

RPI_ALWAYS_FULLHD ?= "1"
RPI_ENABLE_AUDIO ?= "1"
RPI_V4L2M2M_DECODER ?= "1"

MESA_ARM_PREFERRED_DRIVERS:rpi = ""
PACKAGECONFIG:append:pn-mesa:rpi = " v3d vc4"

RPI_KERNEL_DEVICETREE_OVERLAYS:append:rpi:full-kms = " overlays/cma.dtbo overlays/vc4-kms-v3d-pi4.dtbo overlays/rpivid-v4l2.dtbo"

VC4_DTBO_VARIANT = "vc4-kms-v3d"
VC4_DTBO_VARIANT:raspberrypi4 = "vc4-kms-v3d-pi4,cma-320"
VC4_DTBO_VARIANT:raspberrypi4-64 = "vc4-kms-v3d-pi4,cma-320"

VC4DTBO:rpi:full-kms = "${VC4_DTBO_VARIANT}"

# vc4-hdmi driver do not support audio mixing
DISTRO_FEATURES:append:rpi:full-kms = " pulseaudio"
