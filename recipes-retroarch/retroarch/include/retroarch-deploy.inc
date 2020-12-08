inherit deploy

addtask retroarch_config after do_unpack before do_patch

do_deploy() {
  install -d ${DEPLOYDIR}/config
  install -m 644 ${S}/retroarch.cfg.stock ${DEPLOYDIR}/config
  install -m 644 ${S}/retroarch.cfg ${DEPLOYDIR}/config
}

addtask deploy after do_install