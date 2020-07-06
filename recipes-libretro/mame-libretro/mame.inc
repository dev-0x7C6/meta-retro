inherit libretro python-dir pythonnative

# Too much debug symbols are generated
DEBUG_FLAGS = ""

# Compilation taking to much time
LIBRETRO_LTO_ENABLED ?= "0"

LIBRETRO_EXTRA_MAKEFLAGS_append_32bit = " PTR64=0"
LIBRETRO_EXTRA_MAKEFLAGS_append_64bit = " PTR64=1"
