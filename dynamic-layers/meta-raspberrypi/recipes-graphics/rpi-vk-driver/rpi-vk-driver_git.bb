# Based on original: https://github.com/jwinarske/meta-flutter/blob/zeus/recipes-graphics/rpi-vk-driver/rpi-vk-driver_git.bb (Joel Winarske)

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0e9db807e4f1ed14373059c8499d5f82"

inherit cmake features_check python3native

SRC_URI = "git://github.com/Yours3lf/rpi-vk-driver.git;protocol=https;branch=master"
SRCREV = "39bb5f20e39185bf41a636a238437d55dc6ded5a"
S = "${WORKDIR}/git"

DEPENDS += "libdrm vulkan-headers expat zlib"

REQUIRED_DISTRO_FEATURES = "vulkan"
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

# todo add package flags
EXTRA_OECMAKE_append = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DCMAKE_SKIP_INSTALL_RPATH=ON \
    -DBUILD_TESTING=OFF \
"

FILES_${PN} = " \
    ${libdir}/librpi-vk-driver.so \
    ${datadir}/vulkan/icd.d/rpi-vk-driver.json \
"

FILES_${PN}-dev  = " \
    ${bindir}/QPUassemblerExe \
"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'wayland x11', d)}"

PACKAGECONFIG[x11] = "-DBUILD_WSI_XLIB_SUPPORT=ON -DBUILD_WSI_XCB_SUPPORT=ON, -DBUILD_WSI_XLIB_SUPPORT=OFF -DBUILD_WSI_XCB_SUPPORT=OFF, libxcb libx11 libxrandr"
PACKAGECONFIG[wayland] = "-DBUILD_WSI_WAYLAND_SUPPORT=ON, -DBUILD_WSI_WAYLAND_SUPPORT=OFF, wayland"
