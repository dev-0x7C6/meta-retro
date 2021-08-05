DEPENDS += "libpcap libglu"

LIBRETRO_PLATFORM:append:arm32 = "-armv"
LIBRETRO_PLATFORM:append:opengles = "-gles"

EXTRA_OEMAKE:append:64bit = " DESMUME_JIT=0"

# Maybe glvnd support that's comming in future will help
REQUIRED_DISTRO_FEATURES = "x11"