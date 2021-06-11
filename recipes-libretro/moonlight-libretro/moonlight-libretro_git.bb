SUMMARY = "GameStream client for RetroArch"
DESCRIPTION = "GameStream client for RetroArch"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit libretro

DEPENDS = "curl ffmpeg opusfile"

LIBRETRO_GIT_REPO = "github.com/rock88/moonlight-libretro"
