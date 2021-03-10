## OpenEmbedded / Yocto software layer for RetroArch and libretro cores

This layer provides RetroArch front-end and libretro cores emulators
recipes for use with OpenEmbedded and/or Yocto.

![Raspberry Pi 4 Poky build](https://devwork.space/wp-content/uploads/2020/01/IMG_20200108_205652-scaled.jpg)

## Building

You can test this layer and distro (retro) with reference build environment on your host computer

```console
user@localhost:~$ git clone --recursive https://github.com/dev-0x7C6/retro-build-environment.git
user@localhost:~$ cd retro-build-environment
user@localhost:~$ source source.me
user@localhost:~$ MACHINE="raspberrypi4" bitbake retro-image-full
```

## Images

| Image (recipe name)                                                 | Retroarch          | Libretro cores     | Shaders            | Titles             | Cheats             | Themes             | Overlays             |
|:--------------------------------------------------------------------|:------------------:|:------------------:|:------------------:|:------------------:|:------------------:|:------------------:|:--------------------:|
| [retro-image-full](recipes-core/images/retro-image-full.bb)         | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark:   |
| [retro-image-standard](recipes-core/images/retro-image-standard.bb) | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |                    |                    |                      |
| [retro-image-minimal](recipes-core/images/retro-image-minimal.bb)   | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |                    |                    |                    |                      |

Recomendation: [retro-image-full](recipes-core/images/retro-image-full.bb)

## Tested platforms

| Machine           | Layer                                                                            | Build against | Runtime testing | Notice                                                                     |
|:------------------|:--------------------------------------------------------------------------------:|:-------------:|:---------------:|:---------------------------------------------------------------------------| 
| `cubietruck`      | [meta-sunxi](https://github.com/linux-sunxi/meta-sunxi)                          |  Often        | Rarely          | Unable to run kms with lima(mesa)                                          |
| `intel-core2-32`  | [meta-intel](https://git.yoctoproject.org/cgit/cgit.cgi/meta-intel/)             |  Often        | Sometimes       | As pendrive dongle                                                         |
| `intel-corei7-64` | [meta-intel](https://git.yoctoproject.org/cgit/cgit.cgi/meta-intel/)             |  Often        | Sometimes       | As pendrive dongle                                                         |
| `orange-pi-pc`    | [meta-sunxi](https://github.com/linux-sunxi/meta-sunxi)                          |  Often        | Rarely          | ---                                                                        |
| `raspberrypi3-64` | [meta-raspberrypi](https://git.yoctoproject.org/cgit/cgit.cgi/meta-raspberrypi/) |  Often        | Sometimes       | ---                                                                        |
| `raspberrypi3`    | [meta-raspberrypi](https://git.yoctoproject.org/cgit/cgit.cgi/meta-raspberrypi/) |  Often        | Sometimes       | ---                                                                        |
| `raspberrypi4-64` | [meta-raspberrypi](https://git.yoctoproject.org/cgit/cgit.cgi/meta-raspberrypi/) |  Always       | Often           | ---                                                                        |
| `raspberrypi4`    | [meta-raspberrypi](https://git.yoctoproject.org/cgit/cgit.cgi/meta-raspberrypi/) |  Always       | Often           | ---                                                                        |
| `rock-pi-4a`      | [meta-rockchip](https://git.yoctoproject.org/cgit/cgit.cgi/meta-rockchip/)       |  Often        | None            | Thanks to [@MarkusVolk](https://github.com/MarkusVolk) for sending patches |

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

## Layer dependencies

| Layer                                                                            | Sublayer           | Required           | Software           | Recommended BSPs   |
|:---------------------------------------------------------------------------------|:-------------------|:------------------:|:------------------:|:------------------:|
| [openembedded-core](https://github.com/openembedded/openembedded-core)           | meta               | :heavy_check_mark: | :heavy_check_mark: |                    |
| [meta-openembedded](https://github.com/openembedded/meta-openembedded)           | meta-oe            | :heavy_check_mark: | :heavy_check_mark: |                    |
| :arrow_right_hook:                                                               | meta-multimedia    | :heavy_check_mark: | :heavy_check_mark: |                    |
| :arrow_right_hook:                                                               | meta-python        | :heavy_check_mark: | :heavy_check_mark: |                    |
| :arrow_right_hook:                                                               | meta-networking    | :heavy_check_mark: | :heavy_check_mark: |                    |
| [meta-python2](https://git.openembedded.org/meta-python2)                        | .                  | :heavy_check_mark: | :heavy_check_mark: |                    |
| [meta-qt5](https://code.qt.io/cgit/yocto/meta-qt5.git)                           | .                  | :heavy_check_mark: | :heavy_check_mark: |                    |
| [meta-kodi](https://github.com/dev-0x7C6/meta-kodi)                              | .                  |                    | :heavy_check_mark: |                    |
| [meta-raspberrypi](https://github.com/agherzan/meta-raspberrypi)                 | .                  |                    | :heavy_check_mark: | :heavy_check_mark: |
| [meta-raspberrypi-extras](https://github.com/dev-0x7C6/meta-raspberrypi-extras)  | .                  |                    | :heavy_check_mark: | :heavy_check_mark: |
| [meta-intel](http://git.yoctoproject.org/cgit/cgit.cgi/meta-intel/tree)          | .                  |                    | :heavy_check_mark: | :heavy_check_mark: |
| [meta-rockchip](http://git.yoctoproject.org/cgit/cgit.cgi/meta-rockchip)         | .                  |                    | :heavy_check_mark: | :heavy_check_mark: |


## Patches

Please submit patches against the [dev-0x7C6/meta-retro](https://github.com/dev-0x7C6/meta-retro) layer by pull requests.

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
