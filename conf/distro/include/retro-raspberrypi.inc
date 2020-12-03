RPI_ALWAYS_FULLHD ?= "1"
RPI_ENABLE_AUDIO ?= "1"

PACKAGECONFIG_append_pn-mesa_rpi = " v3d vc4"
