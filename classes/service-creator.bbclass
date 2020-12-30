# Systemd service class helper, can be used as bellow
# 
# service_emit_section "Unit"
# service_emit_variable "Description" "Test"
# service_emit_separator
# service_emit_section "Service"
# service_emit_variable []
# service_emit_variable "ExecStart" "/bin/true"
# service_emit_separator
# service_commit ${B}/example.service
#
# Will result with ${B}/example.service file which contains
# [Unit]
# Description=Test
#
# [Service]
# ExecStart=/bin/true
#
# After service_commit next service file can be prepared
#

TMP_SERVICE_FILE ?= "${WORKDIR}/prepare.service.tmp"

service_emit_section() {
    [ -n "${1}" ] && echo "[$1]" >> ${TMP_SERVICE_FILE}
}

service_emit_variable() {
    [ -n "${1}" ] && [ -n "${2}" ] && echo "$1=$2" >> ${TMP_SERVICE_FILE}
}

service_emit_separator() {
    echo >> ${TMP_SERVICE_FILE}
}

service_commit() {
    mv -f ${TMP_SERVICE_FILE} ${1}
}