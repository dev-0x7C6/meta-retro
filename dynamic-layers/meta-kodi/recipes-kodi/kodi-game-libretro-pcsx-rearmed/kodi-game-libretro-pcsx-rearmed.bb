SUMMARY = "PCSX ReARMed game client for XBMC"
HOMEPAGE = "https://github.com/kodi-game/game.libretro.pcsx-rearmed"
BUGTRACKER = "https://github.com/kodi-game/game.libretro.pcsx-rearmed/issues"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit kodi-addon

DEPENDS += "pcsx-rearmed-libretro"
RDEPENDS_${PN} += "kodi"

SRCREV = "22.0.0.19-Matrix"
SRC_URI = "git://github.com/kodi-game/game.libretro.pcsx-rearmed;nobranch=1;protocol=https"
S = "${WORKDIR}/git"

KODIADDONNAME = "game.libretro.pcsx-rearmed"
