# meta-retro defaults for retroarch

inherit retroarch-paths

do_retroarch_config_append() {
  write_cfg_replace "assets_directory" "${RETROARCH_ASSETS_DIR}"
  write_cfg_replace "cheat_database_path" "${RETROARCH_DATABASE_CHEATS_DIR}"
  write_cfg_replace "content_database_path" "${RETROARCH_DATABASE_TITLES_DIR}"
  write_cfg_replace "cursor_directory" "${RETROARCH_DATABASE_CURSORS_DIR}"
  write_cfg_replace "joypad_autoconfig_dir" "${RETROARCH_AUTOCONFIG_DIR}"
  write_cfg_replace "libretro_directory" "${RETROARCH_LIBRETRO_CORES_DIR}"
  write_cfg_replace "libretro_info_path" "${RETROARCH_LIBRETRO_CORES_INFO_DIR}"
  write_cfg_replace "overlay_directory" "${RETROARCH_OVERLAY_DIR}"
  write_cfg_replace "rgui_browser_directory" "${RETROARCH_MEDIA_DIR}"
  write_cfg_replace "system_directory" "${RETROARCH_SYSTEM_DIR}"
  write_cfg_replace "video_shader_dir" "${RETROARCH_SHADERS_DIR}"
}