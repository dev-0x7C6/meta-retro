inherit retroarch-allarch

do_patch() {
	rm -f ${S}/Makefile
	rm -f ${S}/README.md
	rm -f ${S}/configure
}
