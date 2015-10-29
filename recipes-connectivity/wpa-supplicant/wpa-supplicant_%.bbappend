FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI_append = " \
	file://wpa_supplicant.conf-custom \
"

# Replace previously installed wpa_supplicant.conf file with the one that can join ingenuity 2.4 wifi
do_install_append () {
        install -m 600 ${WORKDIR}/wpa_supplicant.conf-custom ${D}${sysconfdir}/wpa_supplicant.conf
}
