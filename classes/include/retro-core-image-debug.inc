BENCHMARK_COLLECTION ?= " \
    nbench-byte \
"

DEBUG_TOOLS_COLLECTION ?= " \
    alsa-utils \
    binutils \
    blktrace \
    bzip2 \
    elfutils \
    gptfdisk \
    hdparm \
    htop \
    iotop \
    mc \
    net-tools \
    procps \
    strace \
    tar \
    util-linux \
    vim \
    wget \
"

IMAGE_INSTALL += "${@bb.utils.contains('EXTRA_IMAGE_FEATURES', 'tools-debug', '${BENCHMARK_COLLECTION}', '', d)}"
IMAGE_INSTALL += "${@bb.utils.contains('EXTRA_IMAGE_FEATURES', 'tools-debug', '${DEBUG_TOOLS_COLLECTION}', '', d)}"