# meta-retro defaults for retroarch

# Write save files next to rom files
RETROARCH_CONFIG_SAVEFILES_IN_CONTENT_DIR ?= "true"

# Write save states files next to rom files
RETROARCH_CONFIG_SAVESTATES_IN_CONTENT_DIR ?= "true"

# Write screenshot files next to rom files
RETROARCH_CONFIG_SCREENSHOTS_IN_CONTENT_DIR ?= "true"

# Search for system files next to rom files
RETROARCH_CONFIG_SYSTEMFILES_IN_CONTENT_DIR ?= "false"

do_retroarch_config:append() {
  write_comment "Saveing strategy"
  write_cfg "savefiles_in_content_dir" "${RETROARCH_CONFIG_SAVEFILES_IN_CONTENT_DIR}"
  write_cfg "savestates_in_content_dir" "${RETROARCH_CONFIG_SAVESTATES_IN_CONTENT_DIR}"
  write_cfg "screenshots_in_content_dir" "${RETROARCH_CONFIG_SCREENSHOTS_IN_CONTENT_DIR}"
  write_cfg "systemfiles_in_content_dir" "${RETROARCH_CONFIG_SYSTEMFILES_IN_CONTENT_DIR}"
}
