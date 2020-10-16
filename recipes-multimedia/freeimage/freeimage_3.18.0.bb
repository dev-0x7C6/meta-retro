SUMMARY = "FreeImage tool used by WhatsApp Purple"
SECTION = "webos/support"

#Due to issues with CRLF line endings in LibWebP now using our own fork, so we don't need to patch in OE which caused issues. In future we migth be able to go back to upstream 3.18.0 release directly for example.
SRC_URI = "${SOURCEFORGE_MIRROR}/freeimage/FreeImage3180.zip"
SRC_URI[sha256sum] = "f41379682f9ada94ea7b34fe86bf9ee00935a3147be41b6569c9605a53e438fd"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

TARGET_LDFLAGS += "-lpng"

#TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}/FreeImage"

DEPENDS = " \
  jpeg \
  libpng \
"

# Workaround for now
TARGET_CFLAGS += "-DPNG_ARM_NEON_OPT=0"

do_configure() {
   sed -i -e /^CC/d \
          -e /^CXX\ /d \
          -e /^AR/d \
          -e /^INCDIR\ /d \
          -e /^INSTALLDIR\ /d \
          -e s:'-o root -g root'::g \
          -e /ldconfig/d \
   ${S}/Makefile.gnu
}

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    oe_runmake INSTALLDIR="${D}${libdir}" INCDIR="${D}${includedir}" install
}

INSANE_SKIP_${PN} = "already-stripped dev-so"

FILES_${PN} += "${libdir}"
FILES_SOLIBSDEV = "{libdir}/lib${BP}${SOLIBSDEV}"
