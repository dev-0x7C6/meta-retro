inherit libretro python3-dir python3native

# Too much debug symbols are generated
DEBUG_FLAGS = ""

LIBRETRO_EXTRA_MAKEFLAGS:append:32bit = " PTR64=0"
LIBRETRO_EXTRA_MAKEFLAGS:append:64bit = " PTR64=1"
