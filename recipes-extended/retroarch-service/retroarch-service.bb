SUMMARY = "RetroArch systemd service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit deploy retro-user service-creator systemd

PV = "2.1"

# https://www.freedesktop.org/software/systemd/man/systemd.unit.html
#
# FailureAction=, SuccessAction=
# Configure the action to take when the unit stops and enters a failed state or inactive state.
# Takes one of none, reboot, reboot-force, reboot-immediate, poweroff, poweroff-force,
# poweroff-immediate, exit, and exit-force. In system mode, all options are allowed.
# In user mode, only none, exit, and exit-force are allowed. Both options default to none.

RETROARCH_SERVICE_FAILURE_ACTION ?= "none"
RETROARCH_SERVICE_SUCCESS_ACTION ?= "none"

RETROARCH_SERVICE_USER ?= "${RETRO_USER_NAME}"
RETROARCH_SERVICE_BINARY ?= "${bindir}/retroarch"
RETROARCH_SERVICE_FILE ?= "retroarch.service"

# Verbose mode by default
RETROARCH_SERVICE_PARAMETERS ?= "-v"
RETROARCH_SERVICE_EXTRA_PARAMETERS ?= ""

# Expand command line, remove unneeded spaces
RETROARCH_SERVICE_START_COMMAND = "${@' '.join('${RETROARCH_SERVICE_BINARY} ${RETROARCH_SERVICE_PARAMETERS} ${RETROARCH_SERVICE_EXTRA_PARAMETERS}'.split())}"

# FIXME: psplash is holding kms context and retroarch is unable to start
# this do not mix well with RETROARCH_SERVICE_FAILURE_ACTION that is
# set to reboot or poweroff
RCONFLICTS_${PN} += "psplash"

RDEPENDS_${PN} += "retroarch"
SYSTEMD_SERVICE_${PN} = "${RETROARCH_SERVICE_FILE}"

do_compile() {
    service_emit_section "Unit"
    service_emit_variable "Description" "${SUMMARY}"

    if [ "${RETROARCH_SERVICE_FAILURE_ACTION}" != "none" ]; then
        service_emit_variable "FailureAction" "${RETROARCH_SERVICE_FAILURE_ACTION}"
    fi

    if [ "${RETROARCH_SERVICE_SUCCESS_ACTION}" != "none" ]; then
        service_emit_variable "SuccessAction" "${RETROARCH_SERVICE_SUCCESS_ACTION}"
    fi

    service_emit_separator

    service_emit_section "Service"
    service_emit_variable "Type" "exec"
    service_emit_variable "ExecStart" "${RETROARCH_SERVICE_START_COMMAND}"

    if [ "${RETROARCH_SERVICE_FAILURE_ACTION}" == "none" ]; then
        service_emit_variable "RestartSec" "1"
        service_emit_variable "Restart" "on-failure"
    fi

    service_emit_variable "User" "${RETROARCH_SERVICE_USER}"
    service_emit_separator

    service_emit_section "Install"
    service_emit_variable "WantedBy" "multi-user.target"

    service_commit ${B}/${RETROARCH_SERVICE_FILE}
}

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${B}/${RETROARCH_SERVICE_FILE} ${D}${systemd_unitdir}/system
}

addtask deploy after do_install

do_deploy() {
    install -d ${DEPLOYDIR}/config
    install -m 644 ${B}/${RETROARCH_SERVICE_FILE} ${DEPLOYDIR}/config
}
