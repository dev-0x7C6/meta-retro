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
#~ MACHINE="raspberrypi4" bitbake retroarch-image-minimal
```

I'm currently testing builds with those machines: 
* genericx86_64
* genericx86
* raspberrypi4

But feel free to test other machines as well.

## Introduced DISTRO_FEATURES

* **retroarch-automount** - added extra automounting in /var/run/media
* **retroarch-autostart** - enabling systemd RetroArch startup as main graphics.target
* **retroarch-gles** - enable for OpenGLES 2.0 support in retroarch and libretro cores
* **retroarch-gles3** - enable for OpenGLES 3.0 support in retroarch and libretro cores
* **retroarch-online** - compile RetroArch with online capabilities
* **retroarch-updater** - compile RetroArch with update capabilities

## Dependencies
This layer depends on:
```
  URI: git://git.yoctoproject.org/poky.git
  layers: meta, meta-poky, meta-yocto-bsp
  branch: zeus
  
  URI: git://git.openembedded.org/meta-openembedded
  layers: meta-oe, meta-multimedia, meta-networking, meta-python
  branch: zeus
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
