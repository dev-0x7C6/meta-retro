SUMMARY = "Assets needed for RetroArch"
DESCRIPTION = "Assets needed for RetroArch - e.g. menu drivers, etc. \
Also contains the official branding."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/retroarch-assets/issues"

LICENSE = "CC-BY-SA-4.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=7bd61880991ed797753fcc00acae2c51"

SRC_URI = "gitsm://github.com/libretro/retroarch-assets.git;protocol=https;branch=master"

inherit allarch libretro-version retroarch-paths

SRCREV = "9d77c501b88586cb0ed036e7d13908372ef6f9d6"
S = "${WORKDIR}/git"

FILES:${PN} += "${RETROARCH_ASSETS_DIR}"

COMPONENTS = " \
  ${PN}-glui \
  ${PN}-menu-widgets \
  ${PN}-ozone \
  ${PN}-rgui \
  ${PN}-sounds \
  ${PN}-xmb-automatic \
  ${PN}-xmb-dot-art \
  ${PN}-xmb-flatui \
  ${PN}-xmb-monochrome \
  ${PN}-xmb-neoactive \
  ${PN}-xmb-pixel \
  ${PN}-xmb-retroactive \
  ${PN}-xmb-retrosystem \
  ${PN}-xmb-systematic \
"

PACKAGES =+ "${COMPONENTS}"
RDEPENDS:${PN} += "${COMPONENTS}"

FILES:${PN}-glui = "${RETROARCH_ASSETS_DIR}/glui"
FILES:${PN}-menu-widgets = "${RETROARCH_ASSETS_DIR}/menu_widgets"
FILES:${PN}-ozone = "${RETROARCH_ASSETS_DIR}/ozone"
FILES:${PN}-rgui = "${RETROARCH_ASSETS_DIR}/rgui"
FILES:${PN}-sounds = "${RETROARCH_ASSETS_DIR}/sounds"
FILES:${PN}-xmb-automatic = "${RETROARCH_ASSETS_DIR}/xmb/automatic"
FILES:${PN}-xmb-dot-art = "${RETROARCH_ASSETS_DIR}/xmb/dot-art"
FILES:${PN}-xmb-flatui = "${RETROARCH_ASSETS_DIR}/xmb/flatui"
FILES:${PN}-xmb-monochrome = "${RETROARCH_ASSETS_DIR}/xmb/monochrome"
FILES:${PN}-xmb-neoactive = "${RETROARCH_ASSETS_DIR}/xmb/neoactive"
FILES:${PN}-xmb-pixel = "${RETROARCH_ASSETS_DIR}/xmb/pixel"
FILES:${PN}-xmb-retroactive = "${RETROARCH_ASSETS_DIR}/xmb/retroactive"
FILES:${PN}-xmb-retrosystem = "${RETROARCH_ASSETS_DIR}/xmb/retrosystem"
FILES:${PN}-xmb-systematic = "${RETROARCH_ASSETS_DIR}/xmb/systematic"

do_patch() {
  rm -rf ${S}/src

  rm -f ${S}/Makefile
  rm -f ${S}/configure
  rm -f ${S}/xmb/convert.sh
  rm -f ${S}/xmb/NPMApng2PMApng.py
}

do_install() {
  install -d ${D}${RETROARCH_ASSETS_DIR}
  cp -R --no-dereference --preserve=mode,links -v ${S}/* ${D}${RETROARCH_ASSETS_DIR}
}
