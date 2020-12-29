insert_sudo_cfg() {
	echo "$1" >>  ${D}/${sysconfdir}/sudoers
}

# Allow to use shutdown commands without password

do_install_append() {
    insert_sudo_cfg "%users ALL=(ALL) NOPASSWD: /sbin/poweroff, /sbin/reboot, /sbin/shutdown, /sbin/halt"
    insert_sudo_cfg "%users ALL=(ALL) NOPASSWD: /bin/systemctl poweroff, /bin/systemctl halt, /bin/systemctl reboot"
}

inherit deploy

addtask deploy after do_install

do_deploy() {
  install -d ${DEPLOYDIR}/config
  install -m 644 ${D}/${sysconfdir}/sudoers ${DEPLOYDIR}/config/sudoers
}
