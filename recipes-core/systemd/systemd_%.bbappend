OVERRIDES .= "${@bb.utils.contains('DISTRO_FEATURES', 'gpt', ':gpt', '', d)}"

PACKAGECONFIG:append:retro:gpt = " repart openssl"

PACKAGECONFIG[repart] = "-Drepart=true,-Drepart=false"
