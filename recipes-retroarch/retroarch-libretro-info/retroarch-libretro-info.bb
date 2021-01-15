SUMMARY = "RetroArch additional headers with info about libretro cores"

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/libretro-super/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=5400ab930bc7a77040ea8e75206294c4"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/libretro-super.git;protocol=https"
SRCREV = "${AUTOREV}"

inherit allarch artifact-preview libretro-version retroarch-paths

do_configure[noexec] = "1"
do_compile[noexec] = "1"

FILES_${PN} += "${RETROARCH_LIBRETRO_CORES_INFO_DIR}"

ARTIFACT_PREVIEW_FILES = "${S}/dist/info/*"

do_install() {
  install -d ${D}${RETROARCH_LIBRETRO_CORES_INFO_DIR}
  cp -R --no-dereference --preserve=mode,links -v ${S}/dist/info/* ${D}${RETROARCH_LIBRETRO_CORES_INFO_DIR}
}

