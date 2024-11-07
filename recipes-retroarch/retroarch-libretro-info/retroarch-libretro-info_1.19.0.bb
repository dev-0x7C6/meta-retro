SUMMARY = "RetroArch additional headers with info about libretro cores"

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/libretro-super/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=459277d80461c2908b4cf14949f8dcd5"

SRC_URI = "git://github.com/libretro/libretro-core-info.git;protocol=https;branch=master"
SRCREV = "142dcdb6b929fb916ab6fa26efd1d3b9e829e6a1"

inherit artifact-preview retroarch-allarch

FILES:${PN} += "${RETROARCH_LIBRETRO_CORES_INFO_DIR}"

ARTIFACT_PREVIEW_FILES = "${S}/*.info"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_INFO_DIR}
  cp -R --no-dereference --preserve=mode,links -v ${S}/*.info ${D}${RETROARCH_LIBRETRO_CORES_INFO_DIR}
}

