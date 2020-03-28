inherit libretro/core/git

# Too much debug symbols are generated
DEBUG_FLAGS = ""

LIBRETRO_EXTRA_MAKEFLAGS_append_32bit = " PTR64=0"
LIBRETRO_EXTRA_MAKEFLAGS_append_64bit = " PTR64=1"