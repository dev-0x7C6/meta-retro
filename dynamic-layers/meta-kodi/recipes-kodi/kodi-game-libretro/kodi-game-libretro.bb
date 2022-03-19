SUMMARY = "Libretro compatibility layer for the Kodi Game API"
HOMEPAGE = "https://github.com/kodi-game/game.libretro"
BUGTRACKER = "https://github.com/kodi-game/game.libretro/issues"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=435d4178fd08b25f9cf911f1c3a0ce1d"

inherit kodi-addon

RDEPENDS:${PN} += "kodi"

PV = "2.2.0-Matrix"

SRCREV = "${PV}"
SRC_URI = "git://github.com/kodi-game/game.libretro;nobranch=1;protocol=https"
S = "${WORKDIR}/git"

KODIADDONNAME = "game.libretro"
