FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI_append = " \
	file://interfaces-custom \
"

# Replace previously installed interfaces file with the one that sets eth0 to static IP
do_install_append () {
	rm ${D}${sysconfdir}/network/interfaces
        install -m 0644 ${WORKDIR}/interfaces-custom ${D}${sysconfdir}/network/interfaces
}
