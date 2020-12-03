IMAGE_FEATURES += "${@bb.utils.contains('EXTRA_IMAGE_FEATURES', 'debug-tweaks', 'ssh-server-dropbear', '', d)}"
