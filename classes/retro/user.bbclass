RETRO_USER_ID ?= "1000"
RETRO_USER_GROUPS ?= "video,audio,users,tty,root,dialout,input,disk"
RETRO_USER_NAME ?= "retro"

RETRO_USER_PASSWORD ?= "${RETRO_USER_NAME}"
RETRO_USER_HOMEDIR ?= "/home/${RETRO_USER_NAME}"

RETRO_USER_DEFAULT_TARGET_WANTS ?= "${RETRO_USER_HOMEDIR}/.config/systemd/user/default.target.wants" 
RETRO_USER_SOCKETS_TARGET_WANTS ?= "${RETRO_USER_HOMEDIR}/.config/systemd/user/sockets.target.wants" 

