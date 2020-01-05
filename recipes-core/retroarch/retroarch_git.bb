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
PACKAGECONFIG[caca] = "--enable-caca,--disable-caca,libcaca"
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
PACKAGECONFIG[flac] = "--enable-flac,--disable-flac"
PACKAGECONFIG[floathard] = "--enable-floathard"
PACKAGECONFIG[floatsoftfp] = "--enable-floatsoftfp"
PACKAGECONFIG[freetype] = "--enable-freetype,--disable-freetype,freetype"
PACKAGECONFIG[gles] = "--enable-opengles"
PACKAGECONFIG[gles3] = "--enable-opengles3"
PACKAGECONFIG[jack] = "--enable-jack,--disable-jack"
PACKAGECONFIG[kms] = "--enable-kms,--disable-kms"
PACKAGECONFIG[libusb] = "--enable-dbus"
PACKAGECONFIG[libusb] = "--enable-libusb,--disable-libusb,libusb"
PACKAGECONFIG[mali-fbdev] = "--enable-mali_fbdev"
PACKAGECONFIG[menu-materialui] = "--enable-materialui,--disable-materialui"
PACKAGECONFIG[menu-ozone] = "--enable-ozone,--disable-ozone"
PACKAGECONFIG[menu-rgui] = "--enable-rgui,--disable-rgui"
PACKAGECONFIG[menu-stripes] = "--enable-stripes,--disable-stripes"
PACKAGECONFIG[menu-xmb] = "--enable-xmb,--disable-xmb"
PACKAGECONFIG[miniupnpc] = "--enable-miniupnpc,--disable-miniupnpc"
PACKAGECONFIG[mpv] = "--enable-mpv,,mpv"
PACKAGECONFIG[neon] = "--enable-neon"
PACKAGECONFIG[network] = "--enable-networking,--disable-networking"
PACKAGECONFIG[networkgamepad] = "--enable-networkgamepad,--disable-networkgamepad"
PACKAGECONFIG[no-libretrodb] = "--disable-libretrodb"
PACKAGECONFIG[no-menu-widgets] = "--disable-menu_widgets"
PACKAGECONFIG[no-menu] = "--disable-menu"
PACKAGECONFIG[no-opengl-core] = "--disable-opengl_core"
PACKAGECONFIG[no-opengl1] = "--disable-opengl1"
PACKAGECONFIG[no-runahead] = "--disable-runahead"
PACKAGECONFIG[omap] = "--enable-omap"
PACKAGECONFIG[openal] = "--enable-al,--disable-al"
PACKAGECONFIG[opendingux-fbdev] = "--enable-opendingux_fbdev"
PACKAGECONFIG[opengl] = "--enable-opengl,--disable-opengl"
PACKAGECONFIG[openvg] = "--enable-vg,--disable-vg"
PACKAGECONFIG[oss] = "--enable-oss,--disable-oss"
PACKAGECONFIG[plain-drm] = "--enable-plain_drm"
PACKAGECONFIG[pulse] = "--enable-pulse,--disable-pulse,pulseaudio"
PACKAGECONFIG[roar] = "--enable-roar,--disable-roar"
PACKAGECONFIG[rpiled] = "--enable-rpiled,--disable-rpiled"
PACKAGECONFIG[rsound] = "--enable-rsound,--disable-rsound"
PACKAGECONFIG[sdl] = "--enable-sdl,--disable-sdl,libsdl"
PACKAGECONFIG[sdl2] = "--enable-sdl2,--disable-sdl2,libsdl2"
PACKAGECONFIG[sixel] = "--enable-sixel,--disable-sixel,libsixel"
PACKAGECONFIG[ssa] = "--enable-ssa,--disable-ssa"
PACKAGECONFIG[sse] = "--enable-sse"
PACKAGECONFIG[ssl] = "--enable-ssl,--disable-ssl"
PACKAGECONFIG[sunxi] = "--enable-sunxi"
PACKAGECONFIG[systemd] = "--enable-systemd,--disable-systemd,systemd"
PACKAGECONFIG[threads-storage] = "--enable-thread_storage,--disable-thread_storage"
PACKAGECONFIG[threads] = "--enable-threads,--disable-threads"
PACKAGECONFIG[tinyalsa] = "--enable-tinyalsa,--disable-tinyalsa"
PACKAGECONFIG[udev] = "--enable-udev,--disable-udev,udev"
PACKAGECONFIG[v4l2] = "--enable-v4l2,--disable-v4l2,libv4l"
PACKAGECONFIG[videocore] = "--enable-videocore,--disable-videocore,userland"
PACKAGECONFIG[videoprocessor] = "--enable-videoprocessor,--disable-videoprocessor"
PACKAGECONFIG[vivante-fbdev] = "--enable-vivante_fbdev"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11"
PACKAGECONFIG[xaudio] = "--enable-xaudio,--disable-xaudio"
PACKAGECONFIG[xinerama] = "--enable-xinerama,--disable-xinerama"
PACKAGECONFIG[xrandr] = "--enable-xrandr,--disable-xrandr"
PACKAGECONFIG[xvideo] = "--enable-xvideo,--disable-xvideo"
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib"


# TODO:
# --disable-chd               Disable  Compile in chd support
# --disable-7zip              Disable  Compile in 7z support
# --enable-flac               Enable   Compile in flac support
# --disable-flac              Disable  Compile in flac support
# --disable-dr_mp3            Disable  Compile in Dr. MP3 support
# --enable-builtinflac        Enable   Bake in flac support
# --disable-builtinflac       Disable  Bake in flac support
# --disable-online_updater    Disable  Disable the online updater
# --disable-update_cores      Disable  Disable downloading cores  with online updater
# --disable-update_assets     Disable  Disable downloading assets with online updater
# --enable-preserve_dylib     Enable   Enable dlclose() for Valgrind support
# --enable-parport            Enable   Parallel port joypad support
# --disable-parport           Disable  Parallel port joypad support
# --disable-imageviewer       Disable  Built-in image viewer support.
# --enable-mmap               Enable   MMAP support
# --disable-mmap              Disable  MMAP support
# --enable-qt                 Enable   Qt companion support
# --disable-qt                Disable  Qt companion support
# --enable-xshm               Enable   XShm video driver support
# --disable-cheevos           Disable  Retro Achievements
# --enable-lua                Enable   Lua support (for Retro Achievements)
# --disable-discord           Disable  Discord Integration
# --disable-translate         Disable  OCR and Translation Server Integration
# --disable-shaderpipeline    Disable  Additional shader-based pipelines
# --enable-vulkan             Enable   Vulkan support
# --disable-vulkan            Disable  Vulkan support
# --disable-vulkan_display    Disable  Vulkan KHR display backend support
# --disable-rpng              Disable  RPNG support
# --disable-rbmp              Disable  RBMP support
# --disable-rjpeg             Disable  RJPEG support
# --disable-rtga              Disable  RTGA support
# --disable-hid               Disable  Low-level HID (Human Interface Device) support
# --disable-audiomixer        Disable  Audio Mixer
# --disable-langextra         Disable  Multi-language support
# --enable-osmesa             Enable   Off-screen Mesa rendering
# --enable-drmingw            Enable   DrMingw exception handler
# --enable-gong               Enable   Gong core embedded
# --enable-cdrom              Enable   CD-ROM support
# --disable-cdrom             Disable  CD-ROM support
# --disable-glsl              Disable  GLSL shaders support
# --enable-slang              Enable   slang support
# --disable-slang             Disable  slang support
# --enable-glslang            Enable   glslang support (requires C++11)
# --disable-glslang           Disable  glslang support (requires C++11)
# --enable-spirv_cross        Enable   SPIRV-Cross support (requires C++11)
# --disable-spirv_cross       Disable  SPIRV-Cross support (requires C++11)
# --enable-metal              Enable   Metal support (macOS-only)
# --enable-network_video      Enable
# --enable-steam              Enable   Enable Steam build

EXTRA_OECONF = "${PACKAGECONFIG_CONFARGS}"

do_configure() {
  CROSS_COMPILE="${STAGING_DIR_NATIVE}/usr/bin/" ./configure --build=${BUILD_SYS} --host=${HOST_SYS} --prefix=${prefix} --bindir=${bindir} --sysconfdir=${sysconfdir} ${PACKAGECONFIG_CONFARGS}
}

#PACKAGECONFIG[openal]          = "--enable-openal,--disable-openal,openal-soft"


#do_configure() {
#./configure  --build=x86_64-linux --host=aarch64-poky-linux --prefix=/usr --enable-egl --enable-materialui --enable-sdl2 --enable-ffmpeg --enable-zlib
#}
