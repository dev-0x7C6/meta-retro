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

SRC_URI += "git://github.com/heftig/rtkit.git;protocol=https"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit meson systemd useradd features_check

DEPENDS += "dbus polkit systemd vim-native"
REQUIRED_DISTRO_FEATURES = "polkit systemd"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --no-create-home --user-group rtkit"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"

PACKAGECONFIG[systemd] = "-Dlibsystemd=enabled,-Dlibsystemd=disabled"
PACKAGECONFIG[tests] = "-Dinstalled_tests=true,-Dinstalled_tests=false"

EXTRA_OEMESON += "-Dsystemd_systemunitdir=${systemd_unitdir}/system"

PACKAGES += "${PN}-systemd ${PN}-polkit ${PN}-dbus"
RDEPENDS_${PN} += "${PN}-systemd ${PN}-polkit ${PN}-dbus"

FILES_${PN}-dbus += "${datadir}/dbus-1"
FILES_${PN}-polkit += "${datadir}/polkit-1"
FILES_${PN}-systemd += "${systemd_unitdir}/system"