DESCRIPTION = "NEC PC-8801 emu - Quasi88 port for libretro"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9e54495b2bbbde6f54c556fb76c1698f"

inherit libretro

LIBRETRO_GIT_REPO = "github.com/libretro/quasi88-libretro.git"
LIBRETRO_CORE = "quasi88"

# Unable to compile with -Werror=format-security
SECURITY_STRINGFORMAT = "-Wformat -Wformat-security"