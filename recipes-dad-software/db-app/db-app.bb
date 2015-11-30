#
# Nautitech DAD DB App recipe
#

DESCRIPTION = "Nautitech DAD DB App application."
DEPENDS = ""
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRCREV = "master"
SRC_URI = " \
	git:///home/harshahs/dad_software;protocol=file;tag=master \
	file://db-app.init \
"
S = "${WORKDIR}/git/db_app"

require recipes-qt/qt5/qt5.inc

inherit update-rc.d

do_install() {
	install -d ${D}/home/root/bin
	install -m 0755 ${B}/db_app ${D}/home/root/bin

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/db-app.init ${D}${sysconfdir}/init.d/db-app

	install -d ${D}/home/root/data/current
	install -d ${D}/home/root/data/completed
}

INITSCRIPT_NAME = "db-app"
INITSCRIPT_PARAMS = "defaults 90 20"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "/home/ /home/root/ /home/root/bin/ /home/root/bin/db_app"
FILES_${PN} += "/home/ /home/root/ /home/root/data/ /home/root/data/current"
FILES_${PN} += "/home/ /home/root/ /home/root/data/ /home/root/data/completed"

RDEPENDS_${PN} = "qtbase qtwebsockets"
