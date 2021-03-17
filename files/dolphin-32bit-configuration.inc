# 32-bit platforms are not supported by dolphin emulator
# it's possible to compile 32bit version with "generic" PACKAGECONFIG
# but it's resulting in very poor runtime performance

inherit logging retro-overrides

PACKAGECONFIG_append_32bit = " generic"

do_configure_prepend_32bit() {
    bbwarn "compiling 32-bit version of this software will result with poor performance (disabled JIT)"
}

PACKAGECONFIG[generic] = "-DENABLE_GENERIC=ON,-DENABLE_GENERIC=OFF"
