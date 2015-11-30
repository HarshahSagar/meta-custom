#
# Nautitech DAD web app recipe
#

DESCRIPTION = "Nautitech DAD web app files."
DEPENDS = ""
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRCREV = "master"
SRC_URI = " \
	git:///home/harshahs/dad_software;protocol=file;tag=master \
	file://sites.enabled.default \
	file://node_modules.tgz \
	file://startnodejs.sh \
	file://dad-web-app.init \
"

#S = "${WORKDIR}/git/conf"

do_install() {
	install -d ${D}/etc/nginx/sites-enabled
	install -m 0664 ${WORKDIR}/sites.enabled.default ${D}/etc/nginx/sites-enabled/default

	install -d ${D}/usr/local/nginx
	cp -r ${WORKDIR}/git/web_app ${D}/usr/local/nginx

	install -d ${D}/usr/local/nginx/web_app
	cp -r ${WORKDIR}/node_modules ${D}/usr/local/nginx/web_app

	install -d ${D}/home/root/bin
	install -m 0755 ${WORKDIR}/startnodejs.sh ${D}/home/root/bin/startnodejs.sh

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/dad-web-app.init ${D}${sysconfdir}/init.d/dad-web-app
}

INITSCRIPT_NAME = "dad-web-app"
INITSCRIPT_PARAMS = "defaults 90 20"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "/etc /etc/nginx /etc/nginx/sites-enabled /etc/nginx/sites-enabled/default"
FILES_${PN} += "/usr /usr/local /usr/local/nginx /usr/local/nginx/web_app/*"
FILES_${PN} += "/home/ /home/root/ /home/root/bin/ /home/root/bin/startnodejs.sh"
