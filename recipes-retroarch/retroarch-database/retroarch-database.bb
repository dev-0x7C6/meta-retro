SUMMARY = "RetroArch Database containing cheatcode files, content data files, etc."
DESCRIPTION = "RetroArch incoporates a ROM scanning system to automatically \
produce playlists. Each ROM that is scanned by the playlist generator \
is checked against a database of ROMs that are known to be good copies."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/libretro-database/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=459277d80461c2908b4cf14949f8dcd5"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/libretro-database.git;protocol=https"
SRCREV = "${AUTOREV}"

PV = "2020+git${SRCPV}"
PR = "r1"

inherit allarch retroarch-paths

PACKAGES =+ " \
  ${PN}-cheats \
  ${PN}-cursors \
  ${PN}-titles \
"

FILES_${PN}-cheats = "${RETROARCH_DATABASE_CHEATS_DIR}"
FILES_${PN}-cursors = "${RETROARCH_DATABASE_CURSORS_DIR}"
FILES_${PN}-titles = "${RETROARCH_DATABASE_TITLES_DIR}"

FILES_${PN} += "${RETROARCH_DATABASE_DIR}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
  install -d ${D}${RETROARCH_DATABASE_DIR}
  install -d ${D}${RETROARCH_DATABASE_CHEATS_DIR}
  install -d ${D}${RETROARCH_DATABASE_TITLES_DIR}
  install -d ${D}${RETROARCH_DATABASE_CURSORS_DIR}

# FIXME: files with character [ or ] failing at rpm package stage
# WORKAROUND: use ipk by default package class
# UPSTREAM: https://bugzilla.yoctoproject.org/show_bug.cgi?id=13746
  cp -rf --preserve=mode ${S}/cht/* ${D}${RETROARCH_DATABASE_CHEATS_DIR}/
  cp -rf --preserve=mode ${S}/rdb/* ${D}${RETROARCH_DATABASE_TITLES_DIR}/
  cp -rf --preserve=mode ${S}/cursors/* ${D}${RETROARCH_DATABASE_CURSORS_DIR}/
}
