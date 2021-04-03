DEPENDS += "libpcap libglu"

LIBRETRO_PLATFORM_append_arm32 = "-armv"
LIBRETRO_PLATFORM_append_opengles = "-gles"

EXTRA_OEMAKE_append_64bit = " DESMUME_JIT=0"

# Maybe glvnd support that's comming in future will help
REQUIRED_DISTRO_FEATURES = "x11"