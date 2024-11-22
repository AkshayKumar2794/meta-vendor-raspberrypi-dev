SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = " \
                 packagegroup-core-boot \
                 ${CORE_IMAGE_EXTRA_INSTALL} \
                 packagegroup-vendor-layer \
                 virtual/ca-certificates-trust-store \
                 dropbear \
                "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
