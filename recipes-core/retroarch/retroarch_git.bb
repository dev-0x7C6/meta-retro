SUMMARY = "RetroArch is a frontend for emulators, game engines and media players"
HOMEPAGE = "http://www.retroarch.com/"
SECTION = "emulators"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

PR = "r1"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/libretro/RetroArch.git"
SRCREV = "${AUTOREV}"

inherit autotools-brokensep pkgconfig

DEPENDS = "libxml2"

CONFIGUREOPTS = " \
  --build=${BUILD_SYS} \
  --host=${HOST_SYS} \
  --prefix=${prefix} \
  --bindir=${bindir} \
  --sysconfdir=${sysconfdir} \
"

RASPBERRYPI_DEFAULT_PACKAGECONFIG ??= ""
RASPBERRYPI_DEFAULT_PACKAGECONFIG_rpi = " \
  dispmanx \
  rpiled \
  videocore \
"
PACKAGECONFIG ??= " \
  ${RASPBERRYPI_DEFAULT_PACKAGECONFIG} \
  menu-rgui \
  menu-materialui \
  menu-xmb \
  menu-ozone \
  menu-stripes \
  ssl \
  sdl2 \
  libusb \
  dbus \
  threads \
  threads-storage \
  ffmpeg \
  gles \
  gles3 \
  dynlib \
  network \
  networkgamepad \
  kms \
  egl \
  freetype \
  zlib \
  v4l2 \
"

PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa"
PACKAGECONFIG[audioio] = "--enable-audioio,--disable-audioio"
PACKAGECONFIG[builtinflac] = "--enable-builtinflac,--disable-builtinflac "
PACKAGECONFIG[caca] = "--enable-caca,--disable-caca,libcaca"
PACKAGECONFIG[cdrom] = "--enable-cdrom,--disable-cdrom"
PACKAGECONFIG[cg] = "--enable-cg,--disable-cg"
PACKAGECONFIG[coreaudio] = "--enable-coreaudio,--disable-coreaudio"
PACKAGECONFIG[dbus] = "--enable-libusb,--disable-libusb,libusb"
PACKAGECONFIG[debug] = "--enable-debug"
PACKAGECONFIG[dispmanx] = "--enable-dispmanx,,userland"
PACKAGECONFIG[dsound] = "--enable-dsound,--disable-dsound"
PACKAGECONFIG[dynlib] = "--enable-dylib,--disable-dylib"
PACKAGECONFIG[egl] = "--enable-egl,--disable-egl,virtual/egl"
PACKAGECONFIG[exynos] = "--enable-exynos"
PACKAGECONFIG[ffmpeg] = "--enable-ffmpeg,--disable-ffmpeg,ffmpeg"
PACKAGECONFIG[flac] = "--enable-flac,--disable-flac,flac"
PACKAGECONFIG[flac] = "--enable-flac,--disable-flac"
PACKAGECONFIG[floathard] = "--enable-floathard"
PACKAGECONFIG[floatsoftfp] = "--enable-floatsoftfp"
PACKAGECONFIG[freetype] = "--enable-freetype,--disable-freetype,freetype"
PACKAGECONFIG[gles] = "--enable-opengles"
PACKAGECONFIG[gles3] = "--enable-opengles3"
PACKAGECONFIG[glslang] = "--enable-glslang,--disable-glslang"
PACKAGECONFIG[gong] = "--enable-gong"
PACKAGECONFIG[jack] = "--enable-jack,--disable-jack"
PACKAGECONFIG[kms] = "--enable-kms,--disable-kms"
PACKAGECONFIG[libusb] = "--enable-dbus"
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
PACKAGECONFIG[opengl] = "--enable-opengl,--disable-opengl"
PACKAGECONFIG[openvg] = "--enable-vg,--disable-vg"
PACKAGECONFIG[oss] = "--enable-oss,--disable-oss"
PACKAGECONFIG[parport] = "--enable-parport,--disable-parport"
PACKAGECONFIG[plain-drm] = "--enable-plain_drm"
PACKAGECONFIG[pulse] = "--enable-pulse,--disable-pulse,pulseaudio"
PACKAGECONFIG[qt] = "--enable-qt,--disable-qt"
PACKAGECONFIG[roar] = "--enable-roar,--disable-roar"
PACKAGECONFIG[rpiled] = "--enable-rpiled,--disable-rpiled"
PACKAGECONFIG[rsound] = "--enable-rsound,--disable-rsound"
PACKAGECONFIG[sdl] = "--enable-sdl,--disable-sdl,libsdl"
PACKAGECONFIG[sdl2] = "--enable-sdl2,--disable-sdl2,libsdl2"
PACKAGECONFIG[sixel] = "--enable-sixel,--disable-sixel,libsixel"
PACKAGECONFIG[slang] = "--enable-slang,--disable-slang,slang"
PACKAGECONFIG[spirv-cross] = "--enable-spirv_cross,--disable-spirv_cross"
PACKAGECONFIG[spirv-cross] = "--enable-spirv_cross,--disable-spirv_cross"
PACKAGECONFIG[ssa] = "--enable-ssa,--disable-ssa"
PACKAGECONFIG[sse] = "--enable-sse"
PACKAGECONFIG[ssl] = "--enable-ssl,--disable-ssl"
PACKAGECONFIG[steam] = "--enable-steam"
PACKAGECONFIG[sunxi] = "--enable-sunxi"
PACKAGECONFIG[systemd] = "--enable-systemd,--disable-systemd,systemd"
PACKAGECONFIG[threads-storage] = "--enable-thread_storage,--disable-thread_storage"
PACKAGECONFIG[threads] = "--enable-threads,--disable-threads"
PACKAGECONFIG[tinyalsa] = "--enable-tinyalsa,--disable-tinyalsa"
PACKAGECONFIG[udev] = "--enable-udev,--disable-udev,udev"
PACKAGECONFIG[v4l2] = "--enable-v4l2,--disable-v4l2,libv4l"
PACKAGECONFIG[valgrind] = "--enable-preserve_dylib"
PACKAGECONFIG[videocore] = "--enable-videocore,--disable-videocore,userland"
PACKAGECONFIG[videoprocessor] = "--enable-videoprocessor,--disable-videoprocessor"
PACKAGECONFIG[vivante-fbdev] = "--enable-vivante_fbdev"
PACKAGECONFIG[vulkan] = "--enable-vulkan,--disable-vulkan"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11"
PACKAGECONFIG[xaudio] = "--enable-xaudio,--disable-xaudio"
PACKAGECONFIG[xinerama] = "--enable-xinerama,--disable-xinerama"
PACKAGECONFIG[xrandr] = "--enable-xrandr,--disable-xrandr"
PACKAGECONFIG[xshm] = "--enable-xshm"
PACKAGECONFIG[xvideo] = "--enable-xvideo,--disable-xvideo"
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib"

EXTRA_OECONF = "${PACKAGECONFIG_CONFARGS}"

do_configure() {
  CROSS_COMPILE="${STAGING_DIR_NATIVE}/usr/bin/" ./configure --build=${BUILD_SYS} --host=${HOST_SYS} --prefix=${prefix} --bindir=${bindir} --sysconfdir=${sysconfdir} ${PACKAGECONFIG_CONFARGS}
}

#PACKAGECONFIG[openal]          = "--enable-openal,--disable-openal,openal-soft"


#do_configure() {
#./configure  --build=x86_64-linux --host=aarch64-poky-linux --prefix=/usr --enable-egl --enable-materialui --enable-sdl2 --enable-ffmpeg --enable-zlib
#}
