inherit deploy

ARTIFACT_PREVIEW_FILES ?= ""
ARTIFACT_PREVIEW_DIRECTORY ?= "${DEPLOYDIR}/previews"

addtask deploy_preview after do_install

do_deploy_preview() {
	if [ -n "${ARTIFACT_PREVIEW_FILES}" ]; then
    	install -d "${ARTIFACT_PREVIEW_DIRECTORY}"
    	install -m 644 "${ARTIFACT_PREVIEW_FILES}" ${ARTIFACT_PREVIEW_DIRECTORY}
	fi
}
