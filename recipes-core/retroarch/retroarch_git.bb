SUMMARY = "RetroArch is a frontend for emulators, game engines and media players"
HOMEPAGE = "http://www.retroarch.com/"
SECTION = "emulators"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/RetroArch.git"
SRCREV = "${AUTOREV}"

DEPENDS = "zlib libv4l freetype libxml2 ffmpeg libsdl libsdl2 libsdl pulseaudio libusb"

inherit autotools-brokensep pkgconfig

CONFIGUREOPTS = " \
  --build=${BUILD_SYS} \
  --host=${HOST_SYS} \
  --prefix=${prefix} \
  --bindir=${bindir} \
  --sysconfdir=${sysconfdir} \
"

EXTRA_OECONF = "${PACKAGECONFIG_CONFARGS}"

do_configure() {
  CROSS_COMPILE="${STAGING_DIR_NATIVE}/usr/bin/" ./configure --build=${BUILD_SYS} --host=${HOST_SYS} --prefix=${prefix} --bindir=${bindir} --sysconfdir=${sysconfdir}
}

#PACKAGECONFIG[openal]          = "--enable-openal,--disable-openal,openal-soft"


#do_configure() {
#./configure  --build=x86_64-linux --host=aarch64-poky-linux --prefix=/usr --enable-egl --enable-materialui --enable-sdl2 --enable-ffmpeg --enable-zlib
#}
