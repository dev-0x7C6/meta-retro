inherit artifact-preview deploy

addtask retroarch_config after do_unpack before do_patch

ARTIFACT_PREVIEW_FILES += "${S}/retroarch.cfg.stock ${S}/retroarch.cfg"
