MACHINEOVERRIDES =. "${@bb.utils.contains('MACHINE_FEATURES', 'full-kms', 'full-kms:', '', d)}"

RPI_ALWAYS_FULLHD ?= "1"
RPI_ENABLE_AUDIO ?= "1"
RPI_V4L2M2M_DECODER ?= "1"

MESA_ARM_PREFERRED_DRIVERS_rpi = ""
PACKAGECONFIG_append_pn-mesa_rpi = " v3d vc4"

RPI_KERNEL_DEVICETREE_OVERLAYS_append_rpi_full-kms = " overlays/cma.dtbo overlays/vc4-kms-v3d-pi4.dtbo overlays/rpivid-v4l2.dtbo"

VC4_DTBO_VARIANT = "vc4-kms-v3d"
VC4_DTBO_VARIANT_raspberrypi4 = "vc4-kms-v3d-pi4,cma-512"
VC4_DTBO_VARIANT_raspberrypi4-64 = "vc4-kms-v3d-pi4,cma-512"

VC4DTBO_rpi_full-kms = "${VC4_DTBO_VARIANT}"

# vc4-hdmi driver do not support audio mixing
DISTRO_FEATURES_append_rpi_full-kms = " pulseaudio"
