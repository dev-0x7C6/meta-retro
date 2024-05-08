inherit allarch libretro-version retroarch-paths

do_configure[noexec] = "1"
do_compile[noexec] = "1"

SRCREV ?= "${AUTOREV}"
S = "${WORKDIR}/git"
