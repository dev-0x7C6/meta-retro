OVERRIDES .= "${@bb.utils.contains('DISTRO_FEATURES', 'gpt', ':gpt', '', d)}"

PACKAGECONFIG_append_retro_gpt = " repart openssl"

PACKAGECONFIG[repart] = "-Drepart=true,-Drepart=false"
