SUMMARY = "Assets needed for RetroArch"
DESCRIPTION = "Assets needed for RetroArch - e.g. menu drivers, etc. \
Also contains the official branding."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/retroarch-assets/issues"

LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=7bd61880991ed797753fcc00acae2c51"

PR = "r100"
S = "${WORKDIR}/git"

SRC_URI = "gitsm://github.com/libretro/retroarch-assets.git"
SRCREV = "c2bbf234195bbad91c827337a2fb2b5bc727407b"

FILES_${PN} += "${datadir}/libretro"

inherit autotools-brokensep

do_configure() {
}
