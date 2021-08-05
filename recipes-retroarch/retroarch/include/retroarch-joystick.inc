# meta-retro defaults for retroarch

# /* Input disabled. */
# #define RETRO_DEVICE_NONE         0

# /* The JOYPAD is called RetroPad. It is essentially a Super Nintendo
#  * controller, but with additional L2/R2/L3/R3 buttons, similar to a
#  * PS1 DualShock. */
# #define RETRO_DEVICE_JOYPAD       1

# /* The mouse is a simple mouse, similar to Super Nintendo's mouse.
#  * X and Y coordinates are reported relatively to last poll (poll callback).
#  * It is up to the libretro implementation to keep track of where the mouse
#  * pointer is supposed to be on the screen.
#  * The frontend must make sure not to interfere with its own hardware
#  * mouse pointer.
#  */
# #define RETRO_DEVICE_MOUSE        2

# /* KEYBOARD device lets one poll for raw key pressed.
#  * It is poll based, so input callback will return with the current
#  * pressed state.
#  * For event/text based keyboard input, see
#  * RETRO_ENVIRONMENT_SET_KEYBOARD_CALLBACK.
#  */
# #define RETRO_DEVICE_KEYBOARD     3

# /* LIGHTGUN device is similar to Guncon-2 for PlayStation 2.
#  * It reports X/Y coordinates in screen space (similar to the pointer)
#  * in the range [-0x8000, 0x7fff] in both axes, with zero being center and
#  * -0x8000 being out of bounds.
#  * As well as reporting on/off screen state. It features a trigger,
#  * start/select buttons, auxiliary action buttons and a
#  * directional pad. A forced off-screen shot can be requested for
#  * auto-reloading function in some games.
#  */
# #define RETRO_DEVICE_LIGHTGUN     4

# /* The ANALOG device is an extension to JOYPAD (RetroPad).
#  * Similar to DualShock2 it adds two analog sticks and all buttons can
#  * be analog. This is treated as a separate device type as it returns
#  * axis values in the full analog range of [-0x7fff, 0x7fff],
#  * although some devices may return -0x8000.
#  * Positive X axis is right. Positive Y axis is down.
#  * Buttons are returned in the range [0, 0x7fff].
#  * Only use ANALOG type when polling for analog values.
#  */
# #define RETRO_DEVICE_ANALOG       5

# /* Abstracts the concept of a pointing mechanism, e.g. touch.
#  * This allows libretro to query in absolute coordinates where on the
#  * screen a mouse (or something similar) is being placed.
#  * For a touch centric device, coordinates reported are the coordinates
#  * of the press.
#  *
#  * Coordinates in X and Y are reported as:
#  * [-0x7fff, 0x7fff]: -0x7fff corresponds to the far left/top of the screen,
#  * and 0x7fff corresponds to the far right/bottom of the screen.
#  * The "screen" is here defined as area that is passed to the frontend and
#  * later displayed on the monitor.
#  *
#  * The frontend is free to scale/resize this screen as it sees fit, however,
#  * (X, Y) = (-0x7fff, -0x7fff) will correspond to the top-left pixel of the
#  * game image, etc.
#  *
#  * To check if the pointer coordinates are valid (e.g. a touch display
#  * actually being touched), PRESSED returns 1 or 0.
#  *
#  * If using a mouse on a desktop, PRESSED will usually correspond to the
#  * left mouse button, but this is a frontend decision.
#  * PRESSED will only return 1 if the pointer is inside the game screen.
#  *
#  * For multi-touch, the index variable can be used to successively query
#  * more presses.
#  * If index = 0 returns true for _PRESSED, coordinates can be extracted
#  * with _X, _Y for index = 0. One can then query _PRESSED, _X, _Y with
#  * index = 1, and so on.
#  * Eventually _PRESSED will return false for an index. No further presses
#  * are registered at this point. */
# #define RETRO_DEVICE_POINTER      6

RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT ?= "5"

RETROARCH_CONFIG_INPUT_TYPE_PLAYER_1 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_2 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_3 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_4 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_5 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_6 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_7 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_8 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_9 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_10 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_11 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_12 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_13 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_14 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_15 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"
RETROARCH_CONFIG_INPUT_TYPE_PLAYER_16 ?= "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_DEFAULT}"

do_retroarch_config:append() {
  write_comment "Input"
  for index in `seq 16`; do
    write_cfg "input_player${index}_left" "left"
  done

  write_comment "Controller types"
  write_cfg "input_libretro_device_p1" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_1}"
  write_cfg "input_libretro_device_p2" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_2}"
  write_cfg "input_libretro_device_p3" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_3}"
  write_cfg "input_libretro_device_p4" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_4}"
  write_cfg "input_libretro_device_p5" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_5}"
  write_cfg "input_libretro_device_p6" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_6}"
  write_cfg "input_libretro_device_p7" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_7}"
  write_cfg "input_libretro_device_p8" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_8}"
  write_cfg "input_libretro_device_p9" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_9}"
  write_cfg "input_libretro_device_p10" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_10}"
  write_cfg "input_libretro_device_p11" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_11}"
  write_cfg "input_libretro_device_p12" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_12}"
  write_cfg "input_libretro_device_p13" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_13}"
  write_cfg "input_libretro_device_p14" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_14}"
  write_cfg "input_libretro_device_p15" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_15}"
  write_cfg "input_libretro_device_p16" "${RETROARCH_CONFIG_INPUT_TYPE_PLAYER_16}"
}