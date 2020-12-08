SUMMARY = "Cross-platform, sophisticated frontend for the libretro API"
DESCRIPTION = "RetroArch is the reference frontend for the libretro API. \
Popular examples of implementations for this API includes video game system \
emulators and game engines as well as more generalized 3D programs. \
These programs are instantiated as dynamic libraries. \
We refer to these as <libretro cores>."

HOMEPAGE = "https://www.retroarch.com/"
BUGTRACKER = "https://github.com/libretro/RetroArch/issues"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

S = "${WORKDIR}/git"

# Any version >= 572611f1ca63f3b4d60c117432ef8ff1419d38f7 (>= v.1.8.3) should
# compile due upstream fixes
#   https://github.com/libretro/RetroArch/pull/9959
#   https://github.com/libretro/RetroArch/pull/9944

SRC_URI = "gitsm://github.com/libretro/RetroArch.git ${RETROARCH_PATCHES}"

RETROARCH_PATCHES ?= ""

inherit autotools-brokensep pkgconfig retro-overrides retroarch-paths retroarch-checks deploy

require include/retroarch-deploy.inc
require include/retroarch-directories.inc
require include/retroarch-drivers.inc
require include/retroarch-joystick.inc
require include/retroarch-latency.inc
require include/retroarch-theme.inc
require include/retroarch-video.inc

DEPENDS = " \
  git-native \
  libxml2 \
  mbedtls \
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
  no-opengl1 \
  slang \
  spirv-cross \
"

RETROARCH_AUDIO_PACKAGECONFIG_DEFAULTS ??= " \
  ${@bb.utils.filter('DISTRO_FEATURES', 'alsa pulseaudio', d)} \
"

RETROARCH_ONLINE_PACKAGECONFIG_DEFAULTS ??= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-online', '', 'no-discord', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-updater', '', 'no-online-updater', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-updater', '', 'no-update-assets', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-updater', '', 'no-update-cores', d)} \
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
  dynlib \
  ffmpeg \
  freetype \
  libusb \
  lto \
  menu-materialui \
  menu-ozone \
  menu-rgui \
  menu-xmb \
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

# Switches updated from v1.8.5
# Mon Mar 30 01:56:31 CEST 2020
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
PACKAGECONFIG[gles3] = "--enable-opengles3,,virtual/libgles2"
PACKAGECONFIG[gles] = "--enable-opengles,,virtual/libgles2"
PACKAGECONFIG[glslang] = "--enable-glslang --disable-builtinglslang,--disable-glslang --enable-builtinglslang,glslang"
PACKAGECONFIG[gong] = "--enable-gong"
PACKAGECONFIG[jack] = "--enable-jack,--disable-jack,jack"
PACKAGECONFIG[kms] = "--enable-kms,--disable-kms,libdrm virtual/libgbm"
PACKAGECONFIG[libusb] = "--enable-libusb,--disable-libusb,libusb"
PACKAGECONFIG[lto] = ",,"
PACKAGECONFIG[lua] = "--enable-lua"
PACKAGECONFIG[mali-fbdev] = "--enable-mali_fbdev"
PACKAGECONFIG[menu-materialui] = "--enable-materialui,--disable-materialui"
PACKAGECONFIG[menu-ozone] = "--enable-ozone,--disable-ozone"
PACKAGECONFIG[menu-rgui] = "--enable-rgui,--disable-rgui"
PACKAGECONFIG[menu-stripes] = "--enable-stripes,--disable-stripes"
PACKAGECONFIG[menu-xmb] = "--enable-xmb,--disable-xmb"
PACKAGECONFIG[miniupnpc] = "--enable-miniupnpc,--disable-miniupnpc"
PACKAGECONFIG[mmap] = "--enable-mmap,--disable-mmap,nmap"
PACKAGECONFIG[mpv] = "--enable-mpv,,mpv"
PACKAGECONFIG[neon] = "--enable-neon"
PACKAGECONFIG[network-video] = "--enable-network_video"
PACKAGECONFIG[network] = "--enable-networking,--disable-networking"
PACKAGECONFIG[networkgamepad] = "--enable-networkgamepad,--disable-networkgamepad"
PACKAGECONFIG[no-7zip] = "--disable-7zip,,,7z"
PACKAGECONFIG[no-accessibility] = "--disable-accessibility"
PACKAGECONFIG[no-audiomixer] = "--disable-audiomixer"
PACKAGECONFIG[no-chd] = "--disable-chd"
PACKAGECONFIG[no-cheevos] = "--disable-cheevos"
PACKAGECONFIG[no-configfile] = "--disable-configfile"
PACKAGECONFIG[no-discord] = "--disable-discord"
PACKAGECONFIG[no-dr_mp3] = "--disable-dr_mp3"
PACKAGECONFIG[no-glsl] = "--disable-glsl"
PACKAGECONFIG[no-hid] = "--disable-hid"
PACKAGECONFIG[no-image-viewer] = "--disable-imageviewer"
PACKAGECONFIG[no-langextra] = "--disable-langextra"
PACKAGECONFIG[no-libretrodb] = "--disable-libretrodb"
PACKAGECONFIG[no-menu-widgets] = "--disable-gfx_widgets"
PACKAGECONFIG[no-menu] = "--disable-menu"
PACKAGECONFIG[no-online-updater] = "--disable-online_updater"
PACKAGECONFIG[no-opengl-core] = "--disable-opengl_core"
PACKAGECONFIG[no-opengl1] = "--disable-opengl1"
PACKAGECONFIG[no-rbmp] = "--disable-rbmp"
PACKAGECONFIG[no-rjpeg] = "--disable-rjpeg"
PACKAGECONFIG[no-rpng] = "--disable-rpng"
PACKAGECONFIG[no-rtga] = "--disable-rtga"
PACKAGECONFIG[no-runahead] = "--disable-runahead"
PACKAGECONFIG[no-shaderpipeline] = "--disable-shaderpipeline"
PACKAGECONFIG[no-translate] = "--disable-translate"
PACKAGECONFIG[no-update-assets] = "--disable-update_assets"
PACKAGECONFIG[no-update-cores] = "--disable-update_cores"
PACKAGECONFIG[no-vulkan-display] = "--disable-vulkan_display"
PACKAGECONFIG[odroidgo2] = "--enable-odroidgo2"
PACKAGECONFIG[offscreen] = "--enable-osmesa"
PACKAGECONFIG[omap] = "--enable-omap"
PACKAGECONFIG[openal] = "--enable-al,--disable-al"
PACKAGECONFIG[opendingux-fbdev] = "--enable-opendingux_fbdev"
PACKAGECONFIG[opengl] = "--enable-opengl,--disable-opengl,virtual/libgl"
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

inherit libretro-vulkan-deps
PACKAGECONFIG[vulkan] = "--enable-vulkan,--disable-vulkan"

PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland-native wayland wayland-protocols"
PACKAGECONFIG[wifi] = ",,connman,connman-client"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11,libx11"
PACKAGECONFIG[xaudio] = "--enable-xaudio,--disable-xaudio"
PACKAGECONFIG[xinerama] = "--enable-xinerama,--disable-xinerama,libxinerama"
PACKAGECONFIG[xrandr] = "--enable-xrandr,--disable-xrandr,libxrandr"
PACKAGECONFIG[xshm] = "--enable-xshm,,libxext"
PACKAGECONFIG[xvideo] = "--enable-xvideo,--disable-xvideo"
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib"

EXTRA_OECONF = "${PACKAGECONFIG_CONFARGS}"

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
