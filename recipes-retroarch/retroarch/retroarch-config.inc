# Default retroarch drivers

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
RETROARCH_DEFAULT_AUDIO_DRIVER ??= "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulse', 'alsathread', d)}"

# Audio resampler driver backend. Which audio resampler to use.
# Default will use "sinc".
RETROARCH_DEFAULT_RESAMPLER_DRIVER ??= "sinc"

# Menu driver to use. ("rgui", "xmb", "glui")
RETROARCH_DEFAULT_MENU_DRIVER ??= "xmb"

# Start in fullscreen. Can be changed at runtime.
RETROARCH_CONFIG_FULLSCREEN ??= "true"

# Use threaded video driver. Using this might improve performance at possible cost of latency and more video stuttering.
RETROARCH_CONFIG_THREADED_VIDEO ??= "true"

# Desired audio latency in milliseconds. Might not be honored if driver can't provide given latency.
RETROARCH_CONFIG_AUDIO_LATENCY ??= "256"
