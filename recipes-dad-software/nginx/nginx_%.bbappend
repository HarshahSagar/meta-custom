FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI_append = " \
	file://nginx.conf-custom \
"

# Replace previously installed nginx.conf file with our custom one.
do_install_append () {
		install -m 600 ${WORKDIR}/nginx.conf-custom ${D}${sysconfdir}/nginx/nginx.conf
}
