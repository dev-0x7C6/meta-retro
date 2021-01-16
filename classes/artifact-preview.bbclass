DEPLOYPREVIEWDIR = "${WORKDIR}/deploy-preview-${PN}"
SSTATETASKS += "do_deploy_preview"
do_deploy_preview[sstate-inputdirs] = "${DEPLOYPREVIEWDIR}"
do_deploy_preview[sstate-outputdirs] = "${DEPLOY_DIR_IMAGE}"

python do_deploy_preview_setscene () {
    sstate_setscene(d)
}

addtask do_deploy_preview_setscene

do_deploy_preview[dirs] = "${DEPLOYPREVIEWDIR} ${B} ${D}"
do_deploy_preview[cleandirs] = "${DEPLOYPREVIEWDIR}"
do_deploy_preview[stamp-extra-info] = "${MACHINE_ARCH}"

ARTIFACT_PREVIEW_FILES ?= ""
ARTIFACT_PREVIEW_DIRECTORY ?= "previews/${PN}"

do_deploy_preview() {
    if [ -n "${ARTIFACT_PREVIEW_FILES}" ]; then
        install -d ${DEPLOYPREVIEWDIR}/${ARTIFACT_PREVIEW_DIRECTORY}
        cp -R --no-dereference --preserve=mode,links -v ${ARTIFACT_PREVIEW_FILES} ${DEPLOYPREVIEWDIR}/${ARTIFACT_PREVIEW_DIRECTORY}
    fi
}

addtask deploy_preview before do_package after do_install
