DESCRIPTION = "Arcade emu - Final Burn Alpha (0.2.97.30) port for libretro"

LICENSE = "FB-ALPHA"
LIC_FILES_CHKSUM = "file://docs/license.txt;md5=c700302a5d98b278343c625651db5a48"

inherit libretro

LIBRETRO_CORE = "svn-current/trunk/fbalpha2012"
LIBRETRO_GIT_REPO = "github.com/libretro/fbalpha2012.git"

LIBRETRO_MAKEFILE_PREFIX = "svn-current/trunk"
