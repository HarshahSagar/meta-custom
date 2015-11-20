#
# Nautitech DAD DB App recipe
#

DESCRIPTION = "Nautitech DAD DB App application."
DEPENDS = ""
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRCREV = "master"
SRC_URI = "git:///home/harshahs/dad_software;protocol=file;tag=master"
S = "${WORKDIR}/git/db_app"

require recipes-qt/qt5/qt5.inc

do_install() {
	install -d ${D}/home/root/bin
	install -m 0755 ${B}/db_app ${D}/home/root/bin
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "/home/ /home/root/ /home/root/bin/ /home/root/bin/db_app"

RDEPENDS_${PN} = "qtbase qtwebsockets"
