SUMMARY = "Assets needed for RetroArch"
DESCRIPTION = "Assets needed for RetroArch - e.g. menu drivers, etc. \
Also contains the official branding."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/retroarch-assets/issues"

LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=7bd61880991ed797753fcc00acae2c51"

PR = "r102"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/retroarch-assets.git"
SRCREV = "c2bbf234195bbad91c827337a2fb2b5bc727407b"

inherit retroarch-paths

FILES_${PN} += "${RETROARCH_ASSETS_DIR}"

PACKAGES =+ " \
  retroarch-assets-glui \
  retroarch-assets-ozone \
  retroarch-assets-sounds \
  retroarch-assets-xmb-automatic \
  retroarch-assets-xmb-dot-art \
  retroarch-assets-xmb-flatui \
  retroarch-assets-xmb-monochrome \
  retroarch-assets-xmb-neoactive \
  retroarch-assets-xmb-pixel \
  retroarch-assets-xmb-retroactive \
  retroarch-assets-xmb-retrosystem \
  retroarch-assets-xmb-sysematic \
"

FILES_retroarch-assets-glui = "${RETROARCH_ASSETS_DIR}/glui"
FILES_retroarch-assets-ozone = "${RETROARCH_ASSETS_DIR}/ozone"
FILES_retroarch-assets-ozone = "${RETROARCH_ASSETS_DIR}/ozone"
FILES_retroarch-assets-xmb-automatic = "${RETROARCH_ASSETS_DIR}/xmb/automatic"
FILES_retroarch-assets-xmb-dot-art = "${RETROARCH_ASSETS_DIR}/xmb/dot-art"
FILES_retroarch-assets-xmb-flatui = "${RETROARCH_ASSETS_DIR}/xmb/flatui"
FILES_retroarch-assets-xmb-monochrome = "${RETROARCH_ASSETS_DIR}/xmb/monochrome"
FILES_retroarch-assets-xmb-neoactive = "${RETROARCH_ASSETS_DIR}/xmb/neoactive"
FILES_retroarch-assets-xmb-pixel = "${RETROARCH_ASSETS_DIR}/xmb/pixel"
FILES_retroarch-assets-xmb-retroactive = "${RETROARCH_ASSETS_DIR}/xmb/retroactive"
FILES_retroarch-assets-xmb-retrosystem = "${RETROARCH_ASSETS_DIR}/xmb/retrosystem"
FILES_retroarch-assets-xmb-sysematic = "${RETROARCH_ASSETS_DIR}/xmb/sysematic"

do_install() {
  install -d ${D}${RETROARCH_ASSETS_DIR}

  rm -rf ${S}/Makefile \
    ${S}/configure \
    ${S}/src

  cp -fr ${S}/* ${D}${RETROARCH_ASSETS_DIR}
}
