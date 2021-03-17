SUMMARY = "FB Alpha multi-arcade emulator"
DESCRIPTION = "Final Burn Alpha libretro port"

LICENSE = "FB-ALPHA"
LIC_FILES_CHKSUM = "file://docs/license.txt;md5=c700302a5d98b278343c625651db5a48"

inherit libretro

LIBRETRO_CORE = "svn-current/trunk/fbalpha2012"
LIBRETRO_GIT_REPO = "github.com/libretro/fbalpha2012.git"

LIBRETRO_MAKEFILE_PREFIX = "svn-current/trunk"
