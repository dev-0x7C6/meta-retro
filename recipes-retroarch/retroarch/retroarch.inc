SUMMARY = "Cross-platform, sophisticated frontend for the libretro API"
DESCRIPTION = "RetroArch is the reference frontend for the libretro API. \
Popular examples of implementations for this API includes video game system \
emulators and game engines as well as more generalized 3D programs. \
These programs are instantiated as dynamic libraries. \
We refer to these as <libretro cores>."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/RetroArch/issues"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "gitsm://github.com/libretro/RetroArch.git ${RETROARCH_PATCHES}"
S = "${WORKDIR}/git"

RETROARCH_PATCHES ?= ""

inherit autotools-brokensep
inherit deploy
inherit libretro-vulkan-deps
inherit pkgconfig
inherit retro-overrides
inherit retroarch-checks
inherit retroarch-paths

require include/retroarch-deploy.inc
require include/retroarch-directories.inc
require include/retroarch-drivers.inc
require include/retroarch-joystick.inc
require include/retroarch-lakka.inc
require include/retroarch-latency.inc
require include/retroarch-save-strategy.inc
require include/retroarch-theme.inc
require include/retroarch-video.inc

DEPENDS = " \
  ${@bb.utils.contains('PACKAGECONFIG', 'disable-git-version', '', 'git-native', d)} \
  libxml2 \
"
# Package config

RASPBERRYPI_DEFAULT_PACKAGECONFIG ??= ""
RASPBERRYPI_DEFAULT_PACKAGECONFIG_rpi = " \
  ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', 'dispmanx', d)} \
  ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', 'videocore', d)} \
  rpiled \
"

RETROARCH_GRAPHICS_PACKAGECONFIG_DEFAULTS ??= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'egl gles', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'egl gles gles3', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-opengl', 'opengl', '', d)} \
  ${@bb.utils.filter('DISTRO_FEATURES', 'vulkan wayland wifi', d)} \
  glslang \
  kms \
  disable-opengl1 \
  slang \
  spirv-cross \
"

RETROARCH_AUDIO_PACKAGECONFIG_DEFAULTS ??= " \
  ${@bb.utils.filter('DISTRO_FEATURES', 'alsa pulseaudio', d)} \
"

RETROARCH_ONLINE_PACKAGECONFIG_DEFAULTS ??= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-online', '', 'disable-discord', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-updater', '', 'disable-online-updater', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-updater', '', 'disable-update-assets', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-updater', '', 'disable-update-cores', d)} \
"

RETROARCH_CPU_PACKAGECONFIG_ARM_DEFAULTS ??= ""
RETROARCH_CPU_PACKAGECONFIG_ARM_DEFAULTS_arm32 = " \
  ${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'floathard', 'floatsoftfp', d)} \
"

RETROARCH_CPU_PACKAGECONFIG_DEFAULTS ??=" \
  ${@bb.utils.contains('TUNE_FEATURES', 'core2', 'sse', '', d)} \
  ${@bb.utils.contains('TUNE_FEATURES', 'neon', 'neon', '', d)} \
  ${RETROARCH_CPU_PACKAGECONFIG_ARM_DEFAULTS} \
"

RETROARCH_SUPPORTED_MENU ??= "${RETROARCH_DEFAULT_MENU_DRIVER}"

RETROARCH_MENU_PACKAGECONFIG_DEFAULTS ??=" \
  ${@bb.utils.contains('RETROARCH_SUPPORTED_MENU', 'materialui', 'menu-materialui', '', d)} \
  ${@bb.utils.contains('RETROARCH_SUPPORTED_MENU', 'ozone', 'menu-ozone', '', d)} \
  ${@bb.utils.contains('RETROARCH_SUPPORTED_MENU', 'rgui', 'menu-rgui', '', d)} \
  ${@bb.utils.contains('RETROARCH_SUPPORTED_MENU', 'stripes', 'menu-stripes', '', d)} \
  ${@bb.utils.contains('RETROARCH_SUPPORTED_MENU', 'xmb', 'menu-xmb', '', d)} \
"

PACKAGECONFIG ??= " \
  ${RASPBERRYPI_DEFAULT_PACKAGECONFIG} \
  ${RETROARCH_AUDIO_PACKAGECONFIG_DEFAULTS} \
  ${RETROARCH_CPU_PACKAGECONFIG_DEFAULTS} \
  ${RETROARCH_GRAPHICS_PACKAGECONFIG_DEFAULTS} \
  ${RETROARCH_MENU_PACKAGECONFIG_DEFAULTS} \
  ${RETROARCH_ONLINE_PACKAGECONFIG_DEFAULTS} \
  dbus \
  disable-git-version \
  dynlib \
  ffmpeg \
  freetype \
  libshake \
  libusb \
  lto \
  menu-materialui \
  menu-ozone \
  menu-rgui \
  menu-xmb \
  mmap \
  network \
  networkgamepad \
  ssl \
  threads \
  threads-storage \
  udev \
  v4l2 \
  zlib \
"

RETROARCH_LTO_FLAGS ?= "-flto=${@oe.utils.cpu_count()}"

TARGET_CFLAGS += "${@bb.utils.contains('PACKAGECONFIG', 'lto', '${RETROARCH_LTO_FLAGS}', '', d)}"
TARGET_LDFLAGS += "${@bb.utils.contains('PACKAGECONFIG', 'lto', '${TARGET_CFLAGS}', '', d)}"

# Switches updated from v1.9.1
# Mon Mar 29 21:33:32 CEST 2021
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[audioio] = "--enable-audioio,--disable-audioio"
PACKAGECONFIG[blissbox] = "--enable-blissbox,--disable-blissbox"
PACKAGECONFIG[builtinflac] = "--enable-builtinflac,--disable-builtinflac "
PACKAGECONFIG[caca] = "--enable-caca,--disable-caca,libcaca"
PACKAGECONFIG[cdrom] = "--enable-cdrom,--disable-cdrom"
PACKAGECONFIG[cg] = "--enable-cg,--disable-cg"
PACKAGECONFIG[coreaudio] = "--enable-coreaudio,--disable-coreaudio"
PACKAGECONFIG[dbus] = "--enable-dbus,,dbus"
PACKAGECONFIG[debug] = "--enable-debug"
PACKAGECONFIG[dispmanx] = "--enable-dispmanx,,userland"
PACKAGECONFIG[dsound] = "--enable-dsound,--disable-dsound"
PACKAGECONFIG[dynlib] = "--enable-dylib,--disable-dylib"
PACKAGECONFIG[egl] = "--enable-egl,--disable-egl,virtual/egl"
PACKAGECONFIG[exynos] = "--enable-exynos"
PACKAGECONFIG[ffmpeg] = "--enable-ffmpeg,--disable-ffmpeg,ffmpeg"
PACKAGECONFIG[flac] = "--enable-flac,--disable-flac,flac"
PACKAGECONFIG[floathard] = "--enable-floathard"
PACKAGECONFIG[floatsoftfp] = "--enable-floatsoftfp"
PACKAGECONFIG[freetype] = "--enable-freetype,--disable-freetype,freetype"
PACKAGECONFIG[gl] = "--enable-opengl,--disable-opengl,virtual/libgl"
PACKAGECONFIG[gles3] = "--enable-opengles3,,virtual/libgles2"
PACKAGECONFIG[gles3_1] = "--enable-opengles3_1,,virtual/libgles2"
PACKAGECONFIG[gles3_2] = "--enable-opengles3_2,,virtual/libgles2"
PACKAGECONFIG[gles] = "--enable-opengles,,virtual/libgles2"
PACKAGECONFIG[glslang] = "--enable-glslang --disable-builtinglslang,--disable-glslang --enable-builtinglslang,glslang"
PACKAGECONFIG[gong] = "--enable-gong"
PACKAGECONFIG[jack] = "--enable-jack,--disable-jack,jack"
PACKAGECONFIG[kms] = "--enable-kms,--disable-kms,libdrm virtual/libgbm"
PACKAGECONFIG[lakka] = ",,fontconfig"
PACKAGECONFIG[libusb] = "--enable-libusb,--disable-libusb,libusb"
PACKAGECONFIG[libshake] = "--enable-libshake,--disable-libshake,libshake"
PACKAGECONFIG[lua] = "--enable-lua"
PACKAGECONFIG[lto] = ",,"
PACKAGECONFIG[mali-fbdev] = "--enable-mali_fbdev"
PACKAGECONFIG[menu-materialui] = "--enable-materialui,--disable-materialui"
PACKAGECONFIG[menu-ozone] = "--enable-ozone,--disable-ozone"
PACKAGECONFIG[menu-rgui] = "--enable-rgui,--disable-rgui"
PACKAGECONFIG[menu-stripes] = "--enable-stripes,--disable-stripes"
PACKAGECONFIG[menu-xmb] = "--enable-xmb,--disable-xmb"
PACKAGECONFIG[miniupnpc] = "--enable-miniupnpc,--disable-miniupnpc"
PACKAGECONFIG[mmap] = "--enable-mmap,--disable-mmap"
PACKAGECONFIG[mpv] = "--enable-mpv,,mpv"
PACKAGECONFIG[neon] = "--enable-neon"
PACKAGECONFIG[system-mbedtls] = "--enable-systemmbedtls ,--disable-systemmbedtls,mbedtls"
PACKAGECONFIG[network-video] = "--enable-network_video"
PACKAGECONFIG[network] = "--enable-networking,--disable-networking"
PACKAGECONFIG[networkgamepad] = "--enable-networkgamepad,--disable-networkgamepad"
PACKAGECONFIG[odroidgo2] = "--enable-odroidgo2"
PACKAGECONFIG[offscreen] = "--enable-osmesa"
PACKAGECONFIG[omap] = "--enable-omap"
PACKAGECONFIG[openal] = "--enable-al,--disable-al"
PACKAGECONFIG[opendingux-fbdev] = "--enable-opendingux_fbdev"
PACKAGECONFIG[openvg] = "--enable-vg,--disable-vg,openvg"
PACKAGECONFIG[oss] = "--enable-oss,--disable-oss"
PACKAGECONFIG[parport] = "--enable-parport,--disable-parport"
PACKAGECONFIG[plain-drm] = "--enable-plain_drm"
PACKAGECONFIG[pulseaudio] = "--enable-pulse,--disable-pulse,pulseaudio"
PACKAGECONFIG[qt] = "--enable-qt,--disable-qt"
PACKAGECONFIG[roar] = "--enable-roar,--disable-roar"
PACKAGECONFIG[rpiled] = "--enable-rpiled,--disable-rpiled"
PACKAGECONFIG[rsound] = "--enable-rsound,--disable-rsound"
PACKAGECONFIG[sdl2] = "--enable-sdl2,--disable-sdl2,libsdl2"
PACKAGECONFIG[sdl] = "--enable-sdl,--disable-sdl,libsdl"
PACKAGECONFIG[sixel] = "--enable-sixel,--disable-sixel,libsixel"
PACKAGECONFIG[slang] = "--enable-slang,--disable-slang,slang"
PACKAGECONFIG[spirv-cross] = "--enable-spirv_cross,--disable-spirv_cross,spirv-tools"
PACKAGECONFIG[ssa] = "--enable-ssa,--disable-ssa"
PACKAGECONFIG[sse] = "--enable-sse"
PACKAGECONFIG[ssl] = "--enable-ssl,--disable-ssl"
PACKAGECONFIG[steam] = "--enable-steam"
PACKAGECONFIG[sunxi] = "--enable-sunxi"
PACKAGECONFIG[systemd] = "--enable-systemd,--disable-systemd,systemd"
PACKAGECONFIG[threads-storage] = "--enable-thread_storage,--disable-thread_storage"
PACKAGECONFIG[threads] = "--enable-threads,--disable-threads"
PACKAGECONFIG[tinyalsa] = "--enable-tinyalsa,--disable-tinyalsa,tinyalsa"
PACKAGECONFIG[udev] = "--enable-udev,--disable-udev,udev"
PACKAGECONFIG[v4l2] = "--enable-v4l2,--disable-v4l2,libv4l"
PACKAGECONFIG[valgrind] = "--enable-preserve_dylib"
PACKAGECONFIG[videocore] = "--enable-videocore,--disable-videocore,userland"
PACKAGECONFIG[videoprocessor] = "--enable-videoprocessor,--disable-videoprocessor"
PACKAGECONFIG[vivante-fbdev] = "--enable-vivante_fbdev"
PACKAGECONFIG[vulkan] = "--enable-vulkan,--disable-vulkan"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland-native wayland wayland-protocols"
PACKAGECONFIG[wifi] = ",,connman,connman-client"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11,libx11"
PACKAGECONFIG[xaudio] = "--enable-xaudio,--disable-xaudio"
PACKAGECONFIG[xinerama] = "--enable-xinerama,--disable-xinerama,libxinerama"
PACKAGECONFIG[xrandr] = "--enable-xrandr,--disable-xrandr,libxrandr"
PACKAGECONFIG[xshm] = "--enable-xshm,--disable-xshm,libxext"
PACKAGECONFIG[xvideo] = "--enable-xvideo,--disable-xvideo"
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib"

PACKAGECONFIG[disable-7zip] = "--disable-7zip,,,7z"
PACKAGECONFIG[disable-accessibility] = "--disable-accessibility"
PACKAGECONFIG[disable-audiomixer] = "--disable-audiomixer"
PACKAGECONFIG[disable-chd] = "--disable-chd"
PACKAGECONFIG[disable-cheats] = "--disable-cheats"
PACKAGECONFIG[disable-cheevos] = "--disable-cheevos"
PACKAGECONFIG[disable-configfile] = "--disable-configfile"
PACKAGECONFIG[disable-discord] = "--disable-discord"
PACKAGECONFIG[disable-dr_mp3] = "--disable-dr_mp3"
PACKAGECONFIG[disable-dsp-filter] = "--disable-dsp_filter"
PACKAGECONFIG[disable-git-version] = "--disable-git_version,,"
PACKAGECONFIG[disable-glsl] = "--disable-glsl"
PACKAGECONFIG[disable-hid] = "--disable-hid"
PACKAGECONFIG[disable-image-viewer] = "--disable-imageviewer"
PACKAGECONFIG[disable-langextra] = "--disable-langextra"
PACKAGECONFIG[disable-libretrodb] = "--disable-libretrodb"
PACKAGECONFIG[disable-menu-widgets] = "--disable-gfx_widgets"
PACKAGECONFIG[disable-menu] = "--disable-menu"
PACKAGECONFIG[disable-online-updater] = "--disable-online_updater"
PACKAGECONFIG[disable-opengl-core] = "--disable-opengl_core"
PACKAGECONFIG[disable-opengl1] = "--disable-opengl1"
PACKAGECONFIG[disable-rbmp] = "--disable-rbmp"
PACKAGECONFIG[disable-rewind] = "--disable-rewind"
PACKAGECONFIG[disable-rjpeg] = "--disable-rjpeg"
PACKAGECONFIG[disable-rpng] = "--disable-rpng"
PACKAGECONFIG[disable-rtga] = "--disable-rtga"
PACKAGECONFIG[disable-runahead] = "--disable-runahead"
PACKAGECONFIG[disable-screenshots] = "--disable-screenshots"
PACKAGECONFIG[disable-shaderpipeline] = "--disable-shaderpipeline"
PACKAGECONFIG[disable-translate] = "--disable-translate"
PACKAGECONFIG[disable-update-assets] = "--disable-update_assets"
PACKAGECONFIG[disable-update-cores] = "--disable-update_cores"
PACKAGECONFIG[disable-vulkan-display] = "--disable-vulkan_display"

EXTRA_OECONF = "${PACKAGECONFIG_CONFARGS}"
EXTRA_OEMAKE += "NEED_CXX_LINKER=1 HAVE_LAKKA=${@bb.utils.contains('PACKAGECONFIG', 'lakka', '1', '0', d)}"

CONFIGUREOPTS = " \
  --build=${BUILD_SYS} \
  --host=${HOST_SYS} \
  --bindir=${bindir} \
  --prefix=${prefix} \
  --sysconfdir=${sysconfdir} \
"

FILES_${PN} += "/usr/share/metainfo"

RETROARCH_CONFIG_FILE = "${S}/retroarch.cfg"

write_comment() {
  echo -e "\n# ${1}" >> ${RETROARCH_CONFIG_FILE}
}

write_cfg() {
  echo -e "${1} = \"${2}\""  >> ${RETROARCH_CONFIG_FILE}
}

define_replace() {
  [ -z "${2}" ] || sed -i -e "s:^#define.*${1}.*$:#define ${1} \"${2}\":g" ${3} || exit 1
}

write_cfg_replace() {
  sed -i -e "s:# \(${1} =\).*:\1 \"${2}\":g" ${RETROARCH_CONFIG_FILE} || exit 1
}

do_retroarch_config() {
  cd ${S}
  git checkout -- "retroarch.cfg"
  cp "retroarch.cfg" "retroarch.cfg.stock"
}

do_configure() {
  export PKG_CONF_PATH="pkg-config"
  ./configure ${CONFIGUREOPTS} ${PACKAGECONFIG_CONFARGS}
}
