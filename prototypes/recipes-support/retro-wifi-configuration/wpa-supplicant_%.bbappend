FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
  file://wpa_supplicant-nl80211-wlan0.conf \ 
  file://wpa_supplicant-nl80211@.service \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN}:append = " wpa_supplicant-nl80211@.service"

do_install:append () {
   install -d ${D}${sysconfdir}/wpa_supplicant/
   install -D -m 600 ${WORKDIR}/wpa_supplicant-nl80211-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/

   install -d ${D}${systemd_unitdir}/system/
   install -D -m 644 ${WORKDIR}/wpa_supplicant-nl80211@.service ${D}${systemd_unitdir}/system/

   install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
   ln -s ${systemd_unitdir}/system/wpa_supplicant-nl80211@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant-nl80211@wlan0.service
}