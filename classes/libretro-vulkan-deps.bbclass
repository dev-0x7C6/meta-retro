# Automaticly populate DEPENDS and RDEPENDS with vulkan deps
VULKAN_AUTO_DEPENDS ?= "1"

VULKAN_DEPENDS = "${@bb.utils.contains_any('DISTRO_FEATURES', 'vulkan', 'vulkan-loader', '', d)}"
VULKAN_RDEPENDS = "${@bb.utils.contains_any('DISTRO_FEATURES', 'vulkan', 'mesa-vulkan-drivers', '', d)} ${VULKAN_DEPENDS}"

DEPENDS_append = " ${@bb.utils.contains('VULKAN_AUTO_DEPENDS', '1', '${VULKAN_DEPENDS}', '', d)}"
RDEPENDS_${PN}_append = " ${@bb.utils.contains('VULKAN_AUTO_DEPENDS', '1', '${VULKAN_RDEPENDS}', '', d)}"
