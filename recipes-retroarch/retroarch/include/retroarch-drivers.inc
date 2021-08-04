# meta-retro defaults for retroarch

# Input driver. Depending on video driver, it might force a different input driver.
RETROARCH_DEFAULT_INPUT_DRIVER ??= "udev"

# Joypad driver. ("udev", "linuxraw", "paraport", "sdl2", "hid", "dinput")
RETROARCH_DEFAULT_JOYPAD_DRIVER ??= "udev"

# Video driver to use. "gl", "xvideo", "sdl", "d3d", "vulkan"
RETROARCH_DEFAULT_VIDEO_DRIVER ??= "gl"

# Which context implementation to use.
# Possible ones for desktop are: glx, x-egl, kms-egl, sdl-gl, wgl.
# By default, tries to use first suitable driver.
RETROARCH_DEFAULT_VIDEO_CONTEXT ??= "kms-egl"

# Audio driver backend. Depending on configuration possible candidates are: alsa, alsathread, pulse, oss, jack, rsound, roar, openal, sdl, xaudio.
RETROARCH_DEFAULT_AUDIO_DRIVER ??= "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulse', 'alsa', d)}"

# Audio resampler driver backend. Which audio resampler to use.
# Default will use "sinc".
RETROARCH_DEFAULT_RESAMPLER_DRIVER ??= "sinc"

# Menu driver to use. ("rgui", "xmb", "glui")
RETROARCH_DEFAULT_MENU_DRIVER ??= "xmb"

do_retroarch_config_append() {
  write_cfg_replace "audio_driver" "${RETROARCH_DEFAULT_AUDIO_DRIVER}"
  write_cfg_replace "audio_resampler" "${RETROARCH_DEFAULT_RESAMPLER_DRIVER}"
  write_cfg_replace "input_driver" "${RETROARCH_DEFAULT_INPUT_DRIVER}"
  write_cfg_replace "input_joypad_driver" "${RETROARCH_DEFAULT_JOYPAD_DRIVER}"
  write_cfg_replace "menu_driver" "${RETROARCH_DEFAULT_MENU_DRIVER}"
  write_cfg_replace "video_context_driver" "${RETROARCH_DEFAULT_VIDEO_CONTEXT}"
  write_cfg_replace "video_driver" "${RETROARCH_DEFAULT_VIDEO_DRIVER}"
}
