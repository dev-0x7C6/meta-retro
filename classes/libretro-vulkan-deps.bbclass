# Automaticly populate DEPENDS and RDEPENDS with vulkan deps
VULKAN_AUTO_DEPENDS ?= "1"

VULKAN_DEPENDS = "${@bb.utils.contains_any('DISTRO_FEATURES', 'vulkan', 'vulkan-loader', '', d)}"

DEPENDS += "${@bb.utils.contains('VULKAN_AUTO_DEPENDS', '1', '${VULKAN_DEPENDS}', '', d)}"
RDEPENDS_${PN} += "${@bb.utils.contains('VULKAN_AUTO_DEPENDS', '1', '${VULKAN_DEPENDS}', '', d)} mesa-vulkan-drivers"