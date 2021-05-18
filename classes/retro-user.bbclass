inherit useradd

RETRO_USER_ID ?= "1000"
RETRO_USER_GROUPS ?= "video,audio,users,tty,root,dialout,input,disk"
RETRO_USER_NAME ?= "retro"

RETRO_USER_PASSWORD ?= "${RETRO_USER_NAME}"
RETRO_USER_HOMEDIR ?= "/home/${RETRO_USER_NAME}"

RETRO_USER_DEFAULT_TARGET_WANTS ?= "${RETRO_USER_HOMEDIR}/.config/systemd/user/default.target.wants" 
RETRO_USER_SOCKETS_TARGET_WANTS ?= "${RETRO_USER_HOMEDIR}/.config/systemd/user/sockets.target.wants" 

RDEPENDS_${PN}_prepend = "bash "

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
  --create-home \
  --user-group \
  --groups ${RETRO_USER_GROUPS} \
  --uid ${RETRO_USER_ID} \
  --home ${RETRO_USER_HOMEDIR} \
  --shell /bin/bash \
  -P ${RETRO_USER_PASSWORD} \
  ${RETRO_USER_NAME} \
"