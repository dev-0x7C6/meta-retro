# meta-retro defaults for retroarch

# Font size
RETROARCH_CONFIG_FONT_SIZE ?= "10"

# Start in fullscreen. Can be changed at runtime.
RETROARCH_CONFIG_FULLSCREEN ??= "true"

do_retroarch_config:append() {
  write_cfg_replace "video_fullscreen" "${RETROARCH_CONFIG_FULLSCREEN}"
  write_cfg_replace "video_font_size" "${RETROARCH_CONFIG_FONT_SIZE}"
}