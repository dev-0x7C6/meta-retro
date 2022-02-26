SUMMARY = "Realtime Policy and Watchdog Daemon"
DESCRIPTION = "RealtimeKit is a D-Bus system service that changes \
the scheduling policy of user processes/threads to SCHED_RR \
(i.e. realtime scheduling mode) on request. It is intended to \
be used as a secure mechanism to allow real-time scheduling to \
be used by normal user processes."

HOMEPAGE = "https://github.com/heftig/rtkit"
BUGTRACKER = "https://github.com/heftig/rtkit/issues"

LICENSE = "GPL-3.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8e768468b658b3ed44971b53d4a6716"

SRC_URI += "git://github.com/heftig/rtkit.git;protocol=https;branch=master"
SRCREV = "b9169402fe5e82d20efb754509eb0b191f214599"

S = "${WORKDIR}/git"

inherit meson systemd useradd features_check pkgconfig

DEPENDS += "dbus polkit systemd vim-native"
REQUIRED_DISTRO_FEATURES = "polkit systemd"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--system --no-create-home --home /dev/null --shell /bin/nologin --user-group rtkit"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"

PACKAGECONFIG[systemd] = "-Dlibsystemd=enabled,-Dlibsystemd=disabled"
PACKAGECONFIG[tests] = "-Dinstalled_tests=true,-Dinstalled_tests=false"

EXTRA_OEMESON += "-Dsystemd_systemunitdir=${systemd_unitdir}/system"

PACKAGES += "${PN}-systemd ${PN}-polkit ${PN}-dbus"
RDEPENDS:${PN} += "${PN}-systemd ${PN}-polkit ${PN}-dbus"

FILES:${PN}-dbus += "${datadir}/dbus-1"
FILES:${PN}-polkit += "${datadir}/polkit-1"
FILES:${PN}-systemd += "${systemd_unitdir}/system"
