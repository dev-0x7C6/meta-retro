SUMMARY = "RetroArch overlay collection"
DESCRIPTION = "Collection of overlay files for use with libretro frontends, \
such as RetroArch."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/common-overlays/issues"

# FIXME: License for repository content is missing
# I reported this bug in
# https://github.com/libretro/common-overlays/issues/44
LICENSE = "CLOSED"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/common-overlays.git;protocol=https"
SRCREV = "${AUTOREV}"

inherit retroarch-paths

DEPENDS += "rsync-native"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

FILES_${PN} += "${RETROARCH_OVERLAY_DIR}"

do_install() {
  install -d ${D}${RETROARCH_OVERLAY_DIR}
  rsync -rlptD ${S}/* ${D}${RETROARCH_OVERLAY_DIR}
}
