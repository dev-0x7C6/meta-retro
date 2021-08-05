# Features
MACHINEOVERRIDES =. "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'opengles:gles:', '', d)}"
MACHINEOVERRIDES =. "${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'opengles:gles3:', '', d)}"

# Common overrides for architectures
MACHINEOVERRIDES:append:aarch64 = ":armarch:arm64:64bit"
MACHINEOVERRIDES:append:aarch64_be = ":armarch:arm64:64bit"
MACHINEOVERRIDES:append:arm = ":armarch:arm32:32bit"
MACHINEOVERRIDES:append:armeb = ":armarch:arm32:32bit"
MACHINEOVERRIDES:append:x86 = ":x86arch:32bit"
MACHINEOVERRIDES:append:x86-64 = ":x86arch:64bit"
