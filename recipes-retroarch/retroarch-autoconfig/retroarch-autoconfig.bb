SUMMARY = "RetroArch joypad autoconfig files"
DESCRIPTION = "Autoconfig files included in this repository are used to \
recognize input devices and automatically setup default mappings between \
the physical device and Retropad virtual controller."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/retroarch-joypad-autoconfig/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=459277d80461c2908b4cf14949f8dcd5"

SRC_URI = "gitsm://github.com/libretro/retroarch-joypad-autoconfig.git;protocol=https;branch=master"

inherit retroarch-allarch

FILES:${PN} += "${RETROARCH_AUTOCONFIG_DIR}"

do_patch() {
  rm -f ${S}/Makefile
  rm -f ${S}/configure
}

do_install() {
  install -m 0755 -d ${D}${RETROARCH_AUTOCONFIG_DIR}
  cp -R --no-dereference --preserve=mode,links -v ${S}/* ${D}${RETROARCH_AUTOCONFIG_DIR}
}
