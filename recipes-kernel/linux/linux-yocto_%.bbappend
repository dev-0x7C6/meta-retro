FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append = " \
  file://amdgpu.cfg \
  file://hid.cfg \
  file://input.cfg \
  file://joysticks.cfg \
  file://nouveau.cfg \
"
