# meta-retro defaults for retroarch

# Use threaded video driver. Using this might improve performance at possible cost of latency and more video stuttering.
RETROARCH_CONFIG_THREADED_VIDEO ??= "true"

# Desired audio latency in milliseconds. Might not be honored if driver can't provide given latency.
RETROARCH_CONFIG_AUDIO_LATENCY ??= "256"

do_retroarch_config_append() {
  write_cfg_replace "audio_latency" "${RETROARCH_CONFIG_AUDIO_LATENCY}"
  write_cfg_replace "video_threaded" "${RETROARCH_CONFIG_THREADED_VIDEO}"
}