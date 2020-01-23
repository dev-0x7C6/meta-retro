# Root directory for stuff
RETROARCH_ROOT_DIR ?= "${datadir}/retroarch"

# Autoconfiguration for common joystick devices
RETROARCH_AUTOCONFIG_DIR ?= "${RETROARCH_ROOT_DIR}/autoconfig"

# Graphics used by RetroArch frontend
RETROARCH_ASSETS_DIR ?= "${RETROARCH_ROOT_DIR}/assets"

# Shaders used by RetroArch to achive common effects
RETROARCH_SHADERS_DIR ?= "${RETROARCH_ROOT_DIR}/shaders"

# Home directory for libretro core, contains bioses, system assets and configs
RETROARCH_SYSTEM_DIR ?= "${RETROARCH_ROOT_DIR}/bios"

# Database path
RETROARCH_DATABASE_DIR ?= "${RETROARCH_ROOT_DIR}/database"

# Cheats for RetroArch
RETROARCH_DATABASE_CHEATS_DIR ?= "${RETROARCH_DATABASE_DIR}/cheats"

# Title database for RetroArch
RETROARCH_DATABASE_TITLES_DIR ?= "${RETROARCH_DATABASE_DIR}/titles"

# Cursors for RetroArch
RETROARCH_DATABASE_CURSORS_DIR ?= "${RETROARCH_DATABASE_DIR}/cursors"

# Libretro core info
RETROARCH_LIBRETRO_CORES_INFO_DIR ?= "${RETROARCH_ROOT_DIR}/info"

# Overlay for RetroArch
RETROARCH_OVERLAY_DIR ?= "${RETROARCH_ROOT_DIR}/overlay"

# Libretro plugin directory
RETROARCH_LIBRETRO_CORES_DIR ?= "${libdir}/libretro"
