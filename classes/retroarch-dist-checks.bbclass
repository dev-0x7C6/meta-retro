# Allow checking of required and conflicting DISTRO_FEATURES
#
# ANY_OF_DISTRO_FEATURES:   ensure at least one item on this list is included
#                           in DISTRO_FEATURES.
# REQUIRED_DISTRO_FEATURES: ensure every item on this list is included
#                           in DISTRO_FEATURES.
# CONFLICT_DISTRO_FEATURES: ensure no item in this list is included in
#                           DISTRO_FEATURES.

inherit distro_features_check

ANY_OF_DISTRO_FEATURES = " \
  retroarch-gles \
  retroarch-gles3 \
  retroarch-opengl \
  retroarch-vulkan \
"

CONFLICT_DISTRO_FEATURES = " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles', 'retroarch-gles3', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'retroarch-gles3', 'retroarch-gles ', '', d)} \
"
