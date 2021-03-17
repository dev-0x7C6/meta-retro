TUNE_FEATURES_BLACKLIST ?= ""

python () {
    warnings = list()
    pn = d.getVar("PN")
    tunes = d.getVar("TUNE_FEATURES")
    values = d.getVar("TUNE_FEATURES_BLACKLIST").split()
    for value in values:
        if value in tunes:
            warnings.append("TUNE_FEATURES contains '" + value + "' feature which is blacklisted for this recipe")
            warnings.append("skipping '" + value + "' feature")
            tunes = tunes.replace(value, '')

    d.setVar("TUNE_FEATURES", tunes.replace('  ', ' '))
    d.setVar("__TUNE_FEATURES_CHECK_WARNINGS", warnings)
}

addtask check_tunes after do_unpack before do_configure

python do_check_tunes() {
    for warning in d.getVar("__TUNE_FEATURES_CHECK_WARNINGS"):
        bb.warn(warning)
}