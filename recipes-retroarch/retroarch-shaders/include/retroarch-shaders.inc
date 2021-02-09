inherit allarch libretro-version retroarch-paths

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_patch() {
	rm -f ${S}/Makefile
	rm -f ${S}/README.md
	rm -f ${S}/configure
}
