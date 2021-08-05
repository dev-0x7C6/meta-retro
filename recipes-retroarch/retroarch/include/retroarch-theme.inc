# meta-retro defaults for retroarch

# XMB Theme settings
RETROARCH_CONFIG_XMB_SHADOWS ?= "true"
RETROARCH_CONFIG_XMB_THEME_COLOR ?= "3"
RETROARCH_CONFIG_XMB_THEME_INDEX ?= "0"

do_retroarch_config:append() {
  write_comment "Themes"
  write_cfg "xmb_menu_color_theme" "${RETROARCH_CONFIG_XMB_THEME_COLOR}"
  write_cfg "xmb_shadows_enable" "${RETROARCH_CONFIG_XMB_SHADOWS}"
  write_cfg "xmb_theme" "${RETROARCH_CONFIG_XMB_THEME_INDEX}"
}