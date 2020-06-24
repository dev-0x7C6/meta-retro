SUMMARY = "Assets needed for RetroArch"
DESCRIPTION = "Assets needed for RetroArch - e.g. menu drivers, etc. \
Also contains the official branding."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/retroarch-assets/issues"

LICENSE = "CC-BY-SA-4.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=7bd61880991ed797753fcc00acae2c51"

PR = "r102"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/retroarch-assets.git"
SRCREV = "${AUTOREV}"

inherit allarch retroarch-paths

DEPENDS += "rsync-native"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

FILES_${PN} += "${RETROARCH_ASSETS_DIR}"

PACKAGES =+ " \
  ${PN}-glui \
  ${PN}-ozone \
  ${PN}-sounds \
  ${PN}-xmb-automatic \
  ${PN}-xmb-dot-art \
  ${PN}-xmb-flatui \
  ${PN}-xmb-monochrome \
  ${PN}-xmb-neoactive \
  ${PN}-xmb-pixel \
  ${PN}-xmb-retroactive \
  ${PN}-xmb-retrosystem \
  ${PN}-xmb-sysematic \
"

FILES_${PN}-glui = "${RETROARCH_ASSETS_DIR}/glui"
FILES_${PN}-ozone = "${RETROARCH_ASSETS_DIR}/ozone"
FILES_${PN}-ozone = "${RETROARCH_ASSETS_DIR}/ozone"
FILES_${PN}-xmb-automatic = "${RETROARCH_ASSETS_DIR}/xmb/automatic"
FILES_${PN}-xmb-dot-art = "${RETROARCH_ASSETS_DIR}/xmb/dot-art"
FILES_${PN}-xmb-flatui = "${RETROARCH_ASSETS_DIR}/xmb/flatui"
FILES_${PN}-xmb-monochrome = "${RETROARCH_ASSETS_DIR}/xmb/monochrome"
FILES_${PN}-xmb-neoactive = "${RETROARCH_ASSETS_DIR}/xmb/neoactive"
FILES_${PN}-xmb-pixel = "${RETROARCH_ASSETS_DIR}/xmb/pixel"
FILES_${PN}-xmb-retroactive = "${RETROARCH_ASSETS_DIR}/xmb/retroactive"
FILES_${PN}-xmb-retrosystem = "${RETROARCH_ASSETS_DIR}/xmb/retrosystem"
FILES_${PN}-xmb-sysematic = "${RETROARCH_ASSETS_DIR}/xmb/sysematic"

do_install() {
  install -d ${D}${RETROARCH_ASSETS_DIR}

  rm -rf ${S}/Makefile \
    ${S}/configure \
    ${S}/src

  rsync -rlptD ${S}/* ${D}${RETROARCH_ASSETS_DIR}
}
