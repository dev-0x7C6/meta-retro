SUMMARY = "An OpenGL and OpenGL ES shader front end and validator."
DESCRIPTION = "Glslang is the official reference compiler front end \
for the OpenGL ES and OpenGL shading languages. It \
implements a strict interpretation of the specifications \
for these languages. It is open and free for anyone to use, \
either from a command line or programmatically."
SECTION = "graphics"
HOMEPAGE = "https://www.khronos.org/opengles/sdk/tools/Reference-Compiler"

inherit cmake python3-dir

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=918e668376010a04448a312fb37ae69b"

S = "${WORKDIR}/git"

SRCREV = "${PV}"
SRC_URI = "git://github.com/KhronosGroup/glslang"

FILES_${PN} += "${libdir}/*"

BBCLASSEXTEND = "native nativesdk"
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

do_install_append() {
    # Some of the vulkan samples/test require these headers
    install -d ${D}${includedir}/SPIRV
    cp -f ${S}/SPIRV/GlslangToSpv.h ${D}${includedir}/SPIRV
    cp -f ${S}/SPIRV/Logger.h ${D}${includedir}/SPIRV
    cp -f ${S}/SPIRV/SPVRemapper.h ${D}${includedir}/SPIRV
    cp -f ${S}/SPIRV/spvIR.h ${D}${includedir}/SPIRV

    install -d ${D}${includedir}/glslang/Include
    cp -f ${S}/glslang/Include/*.h ${D}${includedir}/glslang/Include
    install -d ${D}${includedir}/glslang/Public
    cp -f ${S}/glslang/Public/*.h ${D}${includedir}/glslang/Public
    install -d ${D}${includedir}/glslang/MachineIndependent
    cp -f ${S}/glslang/MachineIndependent/Versions.h ${D}${includedir}/glslang/MachineIndependent
}
