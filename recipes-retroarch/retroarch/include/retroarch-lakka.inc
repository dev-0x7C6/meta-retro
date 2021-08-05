# meta-retro defaults for retroarch

# Custom paths for lakka customization

# empty will fallback to "/storage/.cache/services/bluez.conf"
RETROARCH_LAKKA_BLUETOOTH_PATH ??= ""

# empty will fallback to "/storage/.cache/connman/"
RETROARCH_LAKKA_CONNMAN_DIR ??= ""

# empty will fallback to "/storage/.cache/services/localap.conf"
RETROARCH_LAKKA_LOCALAP_PATH ??= ""

# empty will fallback to "/storage/.cache/services/samba.conf"
RETROARCH_LAKKA_SAMBA_PATH ??= ""

# empty will fallback to "/storage/.cache/services/sshd.conf"
RETROARCH_LAKKA_SSH_PATH ??= ""

# empty will fallback to "/storage/.cache/timezone"
RETROARCH_LAKKA_TIMEZONE_PATH ??= ""

# empty will fallback to "/storage/.update/"
RETROARCH_LAKKA_UPDATE_DIR ??= ""

RETROARCH_LAKKA_HEADER_NAME ?= "lakka.h"
RETROARCH_LAKKA_HEADER_PATH ?= "${S}/${RETROARCH_LAKKA_HEADER_NAME}"

lakka_define_replace() {
  define_replace "${1}" "${2}" "${RETROARCH_LAKKA_HEADER_PATH}"
}

do_retroarch_config:append() {
  cd ${S}
  git checkout -- "${RETROARCH_LAKKA_HEADER_PATH}"
  cp "${RETROARCH_LAKKA_HEADER_NAME}" "${RETROARCH_LAKKA_HEADER_NAME}.stock"

  lakka_define_replace "LAKKA_BLUETOOTH_PATH" "${RETROARCH_LAKKA_BLUETOOTH_PATH}"
  lakka_define_replace "LAKKA_CONNMAN_DIR" "${RETROARCH_LAKKA_CONNMAN_DIR}"
  lakka_define_replace "LAKKA_LOCALAP_PATH" "${RETROARCH_LAKKA_LOCALAP_PATH}"
  lakka_define_replace "LAKKA_SAMBA_PATH" "${RETROARCH_LAKKA_SAMBA_PATH}"
  lakka_define_replace "LAKKA_SSH_PATH" "${RETROARCH_LAKKA_SSH_PATH}"
  lakka_define_replace "LAKKA_TIMEZONE_PATH" "${RETROARCH_LAKKA_TIMEZONE_PATH}"
  lakka_define_replace "LAKKA_UPDATE_DIR" "${RETROARCH_LAKKA_UPDATE_DIR}"
}
