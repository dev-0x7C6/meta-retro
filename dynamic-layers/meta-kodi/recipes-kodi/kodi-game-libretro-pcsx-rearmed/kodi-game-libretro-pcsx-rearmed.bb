SUMMARY = "PCSX ReARMed game client for XBMC"
HOMEPAGE = "https://github.com/kodi-game/game.libretro.pcsx-rearmed"
BUGTRACKER = "https://github.com/kodi-game/game.libretro.pcsx-rearmed/issues"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit kodi-addon

DEPENDS += "pcsx-rearmed-libretro"
RDEPENDS:${PN} += "kodi"

PV = "22.0.0.19-Matrix"

SRCREV = "${PV}"
SRC_URI = "git://github.com/kodi-game/game.libretro.pcsx-rearmed;nobranch=1;protocol=https"
S = "${WORKDIR}/git"

KODIADDONNAME = "game.libretro.pcsx-rearmed"
