# Features
MACHINEOVERRIDES =. "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'opengles:gles:', '', d)}"
MACHINEOVERRIDES =. "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'opengles:gles3:', '', d)}"

# Common overrides for architectures
MACHINEOVERRIDES_append_aarch64 = ":armarch:arm64:64bit"
MACHINEOVERRIDES_append_aarch64_be = ":armarch:arm64:64bit"
MACHINEOVERRIDES_append_arm = ":armarch:arm32:32bit"
MACHINEOVERRIDES_append_armeb = ":armarch:arm32:32bit"
MACHINEOVERRIDES_append_x86 = ":x86arch:32bit"
MACHINEOVERRIDES_append_x86-64 = ":x86arch:64bit"
