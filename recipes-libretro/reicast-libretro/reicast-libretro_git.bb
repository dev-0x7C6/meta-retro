DESCRIPTION = "Dreamcast emulator - reicast"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit libretro-cmake

LIBRETRO_GIT_REPO = "github.com/reicast/reicast-emulator.git"

LIBRETRO_GIT_BRANCH = "stable"
LIBRETRO_CORE = "reicast"

PACKAGECONFIG ?= "libretro"

EXTRA_OECMAKE_append = " -DCMAKE_THREAD_LIBS_INIT=-lpthread -DCMAKE_HAVE_THREADS_LIBRARY=1 -DCMAKE_USE_PTHREADS_INIT=1 -DTHREADS_PREFER_PTHREAD_FLAG=ON"

DEPENDS += " \
  alsa-lib \
  libao \
  libevdev \
  nasm-native \
"

PACKAGECONFIG[libretro] = "-DLIBRETRO=ON,-DLIBRETRO=OFF"
