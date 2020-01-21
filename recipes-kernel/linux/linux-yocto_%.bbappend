FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto:"

SRC_URI_append = " \
  file://amdgpu.cfg \
  file://hid.cfg \
  file://input.cfg \
  file://joysticks.cfg \
  file://nouveau.cfg \
"
