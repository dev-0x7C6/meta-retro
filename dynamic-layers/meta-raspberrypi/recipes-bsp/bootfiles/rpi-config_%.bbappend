do_deploy_append() {
    local configfile=${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

    if [ "${DISABLE_BLUETOOTH}" = "1" ]; then
        echo "# Disable bluetooth" >> ${configfile}
        echo "dtoverlay=pi3-disable-bt" >> ${configfile}
        echo >> ${configfile}
    fi

    if [ "${RPI_ALWAYS_FULLHD}" = "1" ]; then
        echo "# Always run in 1080p@60hz HDMI with audio" >> ${configfile}
        echo "hdmi_group=1" >> ${configfile}
        echo "hdmi_mode=16" >> ${configfile}
        echo "hdmi_force_hotplug=1" >> ${configfile}
        echo "disable_overscan=1" >> ${configfile}
        echo "hdmi_drive=2" >> ${configfile}
        echo >> ${configfile}
    fi

    if [ "${RPI_ENABLE_AUDIO}" = "1" ]; then
        echo "# Enable audio" >> ${configfile}
        echo "dtparam=audio=on" >> ${configfile}
        echo >> ${configfile}
    fi

    if [ "${RPI_OVERCLOCK_SD}" = "1" ]; then
        echo "# Overclock sd" >> ${configfile}
        echo "dtparam=sd_overclock=100" >> ${configfile}
        echo >> ${configfile}
    fi

    if [ "${RPI4_OVERCLOCK}" = "1" ]; then
        echo "# Overclock " >> ${configfile}
        echo "over_voltage=4" >> ${configfile}
        echo "arm_freq=2000" >> ${configfile}
        echo "gpu_freq=600" >> ${configfile}
        echo >> ${configfile}
    fi

    if [ "${RPI4_OVERCLOCK_HIGH}" = "1" ]; then
        echo "# Overclock " >> ${configfile}
        echo "over_voltage=6" >> ${configfile}
        echo "arm_freq=2100" >> ${configfile}
        echo "gpu_freq=750" >> ${configfile}
        echo >> ${configfile}
    fi
}
