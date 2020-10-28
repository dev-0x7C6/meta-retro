## OpenEmbedded / Yocto software layer for RetroArch and libretro cores

This layer provides RetroArch front-end and libretro cores emulators
recipes for use with OpenEmbedded and/or Yocto.

![Raspberry Pi 4 Poky build](https://devwork.space/wp-content/uploads/2020/01/IMG_20200108_205652-scaled.jpg)

## Building

You can test this layer and distro (retro) with reference build environment on your host computer

```sh
#~ git clone --recursive https://github.com/dev-0x7C6/retro-build-environment.git
#~ cd retro-build-environment
#~ source source.me
#~ MACHINE="raspberrypi4" bitbake retro-image-full
```

## Images

There are:
* **[retro-image-full](recipes-core/images/retro-image-full.bb)** - retroarch, all libretro cores, cheats, titles, themes and more
* **[retro-image-standard](recipes-core/images/retro-image-standard.bb)** - retroarch, all libretro cores, titles
* **[retro-image-minimal](recipes-core/images/retro-image-minimal.bb)** - retroarch, all libretro cores, minimal build 

It's recommended to use **[retro-image-full](recipes-core/images/retro-image-full.bb)**.

## Tested platforms

I'm currently testing builds with those machines: 
* intel-core2-32 *(meta-intel)*
* intel-corei7-64 *(meta-intel)*
* raspberrypi3 *(meta-raspberrypi)*
* raspberrypi3-64 *(meta-raspberrypi)*
* raspberrypi4 *(meta-raspberrypi)*
* raspberrypi4-64 *(meta-raspberrypi)*
* orange-pi-pc *(meta-sunxi)*
* cubietruck *(meta-sunxi)* - unfortunately unable to run kms with lima(mesa) driver, probably some silicon issues.

## Distro features

Meta-retro introduced a collection of switches that can be set by **DISTRO_FEATURES** in *local.conf* or *distro.conf*

#### RetroArch and system features:

* **retroarch-automount** - added extra automounting in /var/run/media
* **retroarch-autostart** - enabling systemd RetroArch startup as main graphics.target
* **retroarch-online** - compile RetroArch with online capabilities
* **retroarch-updater** - compile RetroArch with update capabilities

#### Graphical capabilities:
* **retroarch-gles** - enable for OpenGLES 2.0 support in retroarch and libretro cores
* **retroarch-gles3** - enable for OpenGLES 3.0 support in retroarch and libretro cores
* **retroarch-opengl** - enable for OpenGL >= 2.0 support in retroarch and libretro cores
* **vulkan** - enable for Vulkan support in retroarch and libretro cores

## Customizable variables

There is a collection of variables that can be set in *local.conf* or *distro.conf*:

#### Default drivers
* **RETROARCH_DEFAULT_INPUT_DRIVER** - default is udev
* **RETROARCH_DEFAULT_JOYPAD_DRIVER** - default is udev
* **RETROARCH_DEFAULT_VIDEO_DRIVER** - default is gl
* **RETROARCH_DEFAULT_VIDEO_CONTEXT** - default is kms-egl
* **RETROARCH_DEFAULT_AUDIO_DRIVER** - default is pulseaudio or alsathread
* **RETROARCH_DEFAULT_RESAMPLER_DRIVER** - default is sinc
* **RETROARCH_DEFAULT_MENU_DRIVER** - default is xmb

#### Configuration
* **RETROARCH_CONFIG_FULLSCREEN** - default is true, go for fullscreen mode, this respects initial resolutions (tested with rpi4)
* **RETROARCH_CONFIG_THREADED_VIDEO** - default is true, use another thread for renderer
* **RETROARCH_CONFIG_AUDIO_LATENCY** - default is 256, stock value is 64, I got better performance with higher values on rpi platforms

#### Video settings
* **RETROARCH_CONFIG_FONT_SIZE**

#### Themes
* **RETROARCH_CONFIG_XMB_SHADOWS**
* **RETROARCH_CONFIG_XMB_THEME_COLOR**
* **RETROARCH_CONFIG_XMB_THEME_INDEX**

For more information see file: [retroarch.inc](recipes-retroarch/retroarch/retroarch.inc)

## Dependencies
This layer depends on:
```
  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  
  URI: git://git.openembedded.org/meta-openembedded
  layers: meta-oe, meta-multimedia, meta-networking, meta-python
```

## Patches

Please submit any patches against the meta-retro layer by pull requests.

## Adding the meta-retro layer to your build

In order to use this layer, you need to make the build system aware of
it.

Assuming the meta-retro layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the meta-retro layer to bblayers.conf, along with any
other layers needed. e.g.:
```
BBLAYERS ?= " \
  /path/to/yocto/meta \
  /path/to/yocto/meta-yocto \
  /path/to/yocto/meta-yocto-bsp \
  /path/to/yocto/meta-retro \
"
```
