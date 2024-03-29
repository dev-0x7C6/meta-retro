inherit useradd extrausers

RETRO_USER_ID ?= "1000"
RETRO_USER_GROUPS ?= "audio dialout disk i2c input netdev plugdev shutdown sudo tty users video"
RETRO_USER_NAME ??= "retro"
RETRO_USER_PASSWORD ??= "retro"
RETRO_USER_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${RETRO_USER_PASSWORD})"

ROOT_PASSWORD ??= "root"
ROOT_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${ROOT_PASSWORD})"

RETRO_USER_HOMEDIR ?= "/home/${RETRO_USER_NAME}"

RETRO_USER_DEFAULT_TARGET_WANTS ?= "${RETRO_USER_HOMEDIR}/.config/systemd/user/default.target.wants"
RETRO_USER_SOCKETS_TARGET_WANTS ?= "${RETRO_USER_HOMEDIR}/.config/systemd/user/sockets.target.wants"

RDEPENDS:${PN}:prepend = "bash "

RETRO_USERADD_CREATE_HOME ?= "--create-home"
RETRO_USERADD_SET_USER_GROUP ?= "--user-group"
RETRO_USERADD_SET_GROUPS ?= "--groups ${@','.join('${RETRO_USER_GROUPS}'.split())}"
RETRO_USERADD_SET_UID ?= "--uid ${RETRO_USER_ID}"
RETRO_USERADD_SET_HOMEDIR ?= "--home ${RETRO_USER_HOMEDIR}"
RETRO_USERADD_SET_SHELL ?= "--shell /bin/bash"

GROUPADD_PARAM:${PN} = "i2c; netdev"

RETRO_USERADD_COMMAND ?= " \
  ${RETRO_USERADD_CREATE_HOME} \
  ${RETRO_USERADD_SET_USER_GROUP} \
  ${RETRO_USERADD_SET_GROUPS} \
  ${RETRO_USERADD_SET_UID} \
  ${RETRO_USERADD_SET_HOMEDIR} \
  ${RETRO_USERADD_SET_SHELL} \
  ${RETRO_USER_NAME} \
"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "${@' '.join('${RETRO_USERADD_COMMAND}'.split())}"

EXTRA_USERS_PARAMS += "usermod -p '${ROOT_PASSWORD_ENCRYPTED}' root;"
EXTRA_USERS_PARAMS += "usermod -p '${RETRO_USER_PASSWORD_ENCRYPTED}' ${RETRO_USER_NAME};"
