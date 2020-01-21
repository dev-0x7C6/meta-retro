FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto:"

SRC_URI_append = " \
  file://amdgpu.cfg \
  file://nouveau.cfg \
"
