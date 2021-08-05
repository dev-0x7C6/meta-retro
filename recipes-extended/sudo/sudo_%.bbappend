inherit artifact-preview

SUDOERS_FILE = "${D}/${sysconfdir}/sudoers"
ARTIFACT_PREVIEW_FILES += "${SUDOERS_FILE}"

insert_sudo_cfg() {
	echo "$1" >> ${SUDOERS_FILE}
}

# Allow to use shutdown commands without password

do_install:append() {
    insert_sudo_cfg "%users ALL=(ALL) NOPASSWD: /sbin/poweroff, /sbin/reboot, /sbin/shutdown, /sbin/halt"
    insert_sudo_cfg "%users ALL=(ALL) NOPASSWD: /bin/systemctl poweroff, /bin/systemctl halt, /bin/systemctl reboot"
}
