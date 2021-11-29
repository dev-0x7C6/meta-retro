SUMMARY = "RetroArch Database containing cheatcode files, content data files, etc."
DESCRIPTION = "RetroArch incoporates a ROM scanning system to automatically \
produce playlists. Each ROM that is scanned by the playlist generator \
is checked against a database of ROMs that are known to be good copies."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/libretro-database/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=459277d80461c2908b4cf14949f8dcd5"

SRC_URI = "gitsm://github.com/libretro/libretro-database.git;protocol=https;branch=master"

PR = "r3"

inherit retroarch-allarch

PACKAGES =+ " \
  ${PN}-cheats \
  ${PN}-cursors \
  ${PN}-titles \
"

FILES:${PN}-cheats = "${RETROARCH_DATABASE_CHEATS_DIR}"
FILES:${PN}-cursors = "${RETROARCH_DATABASE_CURSORS_DIR}"
FILES:${PN}-titles = "${RETROARCH_DATABASE_TITLES_DIR}"

FILES:${PN} += "${RETROARCH_DATABASE_DIR}"

do_patch() {
# FIXME: files with character [ or ] failing at rpm package stage
# BUG-REPORT: https://bugzilla.yoctoproject.org/show_bug.cgi?id=13746
# WORKAROUND: drop problematic files
    find ${S} -type f \( -name "*[*" -o -name "*]*" \) -delete
}

do_install() {
  install -d ${D}${RETROARCH_DATABASE_DIR}
  install -d ${D}${RETROARCH_DATABASE_CHEATS_DIR}
  install -d ${D}${RETROARCH_DATABASE_CURSORS_DIR}
  install -d ${D}${RETROARCH_DATABASE_TITLES_DIR}

  cp -R --no-dereference --preserve=mode,links -v ${S}/cht/* ${D}${RETROARCH_DATABASE_CHEATS_DIR}/
  cp -R --no-dereference --preserve=mode,links -v ${S}/cursors/* ${D}${RETROARCH_DATABASE_CURSORS_DIR}/
  cp -R --no-dereference --preserve=mode,links -v ${S}/rdb/* ${D}${RETROARCH_DATABASE_TITLES_DIR}/
}
