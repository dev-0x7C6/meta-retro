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

PR ?= "r105"
S = "${WORKDIR}/git"

# Any version >= 572611f1ca63f3b4d60c117432ef8ff1419d38f7 (>= v.1.8.3) should
# compile due upstream fixes
#   https://github.com/libretro/RetroArch/pull/9959
#   https://github.com/libretro/RetroArch/pull/9944

SRC_URI = "gitsm://github.com/libretro/RetroArch.git"
SRCREV = "v${PV}"

inherit autotools-brokensep pkgconfig common-overrides retroarch-paths retroarch-dist-checks

DEPENDS = "libxml2"

# Default retroarch drivers

# Input driver. Depending on video driver, it might force a different input driver.
RETROARCH_DEFAULT_INPUT_DRIVER ??= "udev"

# Joypad driver. ("udev", "linuxraw", "paraport", "sdl2", "hid", "dinput")
RETROARCH_DEFAULT_JOYPAD_DRIVER ??= "udev"

# Video driver to use. "gl", "xvideo", "sdl", "d3d"
RETROARCH_DEFAULT_VIDEO_DRIVER ??= "gl"

# Which context implementation to use.
# Possible ones for desktop are: glx, x-egl, kms-egl, sdl-gl, wgl.
# By default, tries to use first suitable driver.
RETROARCH_DEFAULT_VIDEO_CONTEXT ??= "kms-egl"

# Audio driver backend. Depending on configuration possible candidates are: alsa, alsathread, pulse, oss, jack, rsound, roar, openal, sdl, xaudio.
RETROARCH_DEFAULT_AUDIO_DRIVER ??= "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulse', 'alsathread', d)}"

# Audio resampler driver backend. Which audio resampler to use.
# Default will use "sinc".
RETROARCH_DEFAULT_RESAMPLER_DRIVER ??= "sinc"

# Menu driver to use. ("rgui", "xmb", "glui")
RETROARCH_DEFAULT_MENU_DRIVER ??= "xmb"


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
  ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'vulkan', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
  glslang \
  kms \
  no-opengl1 \
  slang \
  spirv-cross \
"

RETROARCH_AUDIO_PACKAGECONFIG_DEFAULTS ??= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'alsa', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'tinyalsa', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio', '', d)} \
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

# Switches updated from ea49348db2917b893f298d755a2dd8e82fb4436a
# Wed Jan 8 19:09:03 CET 2020
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[audioio] = "--enable-audioio,--disable-audioio"
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
PACKAGECONFIG[gles] = "--enable-opengles,,virtual/libgles2"
PACKAGECONFIG[gles3] = "--enable-opengles3,,virtual/libgles2"
PACKAGECONFIG[glslang] = "--enable-glslang,--disable-glslang"
PACKAGECONFIG[gong] = "--enable-gong"
PACKAGECONFIG[jack] = "--enable-jack,--disable-jack,jack"
PACKAGECONFIG[kms] = "--enable-kms,--disable-kms,libdrm virtual/libgbm"
PACKAGECONFIG[libusb] = "--enable-libusb,--disable-libusb,libusb"
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
PACKAGECONFIG[no-audiomixer] = "--disable-audiomixer"
PACKAGECONFIG[no-chd] = "--disable-chd"
PACKAGECONFIG[no-cheevos] = "--disable-cheevos"
PACKAGECONFIG[no-discord] = "--disable-discord"
PACKAGECONFIG[no-dr_mp3] = "--disable-dr_mp3"
PACKAGECONFIG[no-glsl] = "--disable-glsl"
PACKAGECONFIG[no-hid] = "--disable-hid"
PACKAGECONFIG[no-image-viewer] = "--disable-imageviewer"
PACKAGECONFIG[no-langextra] = "--disable-langextra"
PACKAGECONFIG[no-libretrodb] = "--disable-libretrodb"
PACKAGECONFIG[no-menu-widgets] = "--disable-menu_widgets"
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
PACKAGECONFIG[sdl] = "--enable-sdl,--disable-sdl,libsdl"
PACKAGECONFIG[sdl2] = "--enable-sdl2,--disable-sdl2,libsdl2"
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
PACKAGECONFIG[vulkan] = "--enable-vulkan,--disable-vulkan,vulkan-loader virtual/mesa"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland-native wayland wayland-protocols"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11"
PACKAGECONFIG[xaudio] = "--enable-xaudio,--disable-xaudio"
PACKAGECONFIG[xinerama] = "--enable-xinerama,--disable-xinerama"
PACKAGECONFIG[xrandr] = "--enable-xrandr,--disable-xrandr"
PACKAGECONFIG[xshm] = "--enable-xshm"
PACKAGECONFIG[xvideo] = "--enable-xvideo,--disable-xvideo"
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib"

EXTRA_OECONF = "${PACKAGECONFIG_CONFARGS}"

do_patch() {
  LIBRETRO_LIB_DIR="${libdir}/libretro"
  LIBRETRO_DATA_DIR="${datadir}/libretro"
  RETROARCH_DATA_DIR="${datadir}/${PN}"

  sed -i \
    -e "s:# \(assets_directory =\):\1 \"${RETROARCH_ASSETS_DIR}\":g" \
    -e "s:# \(audio_driver =\):\1 \"${RETROARCH_DEFAULT_AUDIO_DRIVER}\":g" \
    -e "s:# \(audio_resampler =\):\1 \"${RETROARCH_DEFAULT_RESAMPLER_DRIVER}\":g" \
    -e "s:# \(cheat_database_path =\):\1 \"${RETROARCH_DATABASE_CHEATS_DIR}\":g" \
    -e "s:# \(content_database_path =\):\1 \"${RETROARCH_DATABASE_TITLES_DIR}\":g" \
    -e "s:# \(cursor_directory =\):\1 \"${RETROARCH_DATABASE_CURSORS_DIR}\":g" \
    -e "s:# \(input_driver =\):\1 \"${RETROARCH_DEFAULT_INPUT_DRIVER}\":g" \
    -e "s:# \(input_joypad_driver =\):\1 \"${RETROARCH_DEFAULT_JOYPAD_DRIVER}\":g" \
    -e "s:# \(joypad_autoconfig_dir =\):\1 \"${RETROARCH_AUTOCONFIG_DIR}\":g" \
    -e "s:# \(libretro_directory =\):\1 \"${RETROARCH_LIBRETRO_CORES_DIR}\":g" \
    -e "s:# \(libretro_info_path =\):\1 \"${RETROARCH_LIBRETRO_CORES_INFO_DIR}\":g" \
    -e "s:# \(menu_driver =\):\1 \"${RETROARCH_DEFAULT_MENU_DRIVER}\":g" \
    -e "s:# \(overlay_directory =\):\1 \"${RETROARCH_OVERLAY_DIR}\":g" \
    -e "s:# \(rgui_browser_directory =\):\1 \"${RETROARCH_MEDIA_DIR}\":g" \
    -e "s:# \(system_directory =\):\1 \"${RETROARCH_SYSTEM_DIR}\":g" \
    -e "s:# \(video_context_driver =\):\1 \"${RETROARCH_DEFAULT_VIDEO_CONTEXT}\":g" \
    -e "s:# \(video_driver =\):\1 \"${RETROARCH_DEFAULT_VIDEO_DRIVER}\":g" \
    -e "s:# \(video_shader_dir =\):\1 \"${RETROARCH_SHADERS_DIR}\":g" \
    ${S}/retroarch.cfg || exit 1
}

CONFIGUREOPTS = " \
  --build=${BUILD_SYS} \
  --host=${HOST_SYS} \
  --bindir=${bindir} \
  --prefix=${prefix} \
  --sysconfdir=${sysconfdir} \
"

do_configure() {
  export PKG_CONF_PATH="pkg-config"
  ./configure ${CONFIGUREOPTS} ${PACKAGECONFIG_CONFARGS}
}
