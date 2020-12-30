DEPLOYDIR = "${WORKDIR}/deploy-preview-${PN}"
SSTATETASKS += "do_deploy_preview"
do_deploy_preview[sstate-inputdirs] = "${DEPLOYDIR}"
do_deploy_preview[sstate-outputdirs] = "${DEPLOY_DIR_IMAGE}"

python do_deploy_preview_setscene () {
    sstate_setscene(d)
}

addtask do_deploy_preview_setscene

do_deploy_preview[dirs] = "${DEPLOYDIR} ${B} ${D}"
do_deploy_preview[cleandirs] = "${DEPLOYDIR}"
do_deploy_preview[stamp-extra-info] = "${MACHINE_ARCH}"

ARTIFACT_PREVIEW_FILES ?= ""
ARTIFACT_PREVIEW_DIRECTORY ?= "previews/${PN}"

addtask deploy_preview after do_install

do_deploy_preview() {
    if [ -n "${ARTIFACT_PREVIEW_FILES}" ]; then
        install -d ${DEPLOYDIR}/${ARTIFACT_PREVIEW_DIRECTORY}
        install -m 644 ${ARTIFACT_PREVIEW_FILES} ${DEPLOYDIR}/${ARTIFACT_PREVIEW_DIRECTORY}
    fi
}
