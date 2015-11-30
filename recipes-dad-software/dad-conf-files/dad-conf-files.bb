#
# Nautitech DAD configuration files recipe
#

DESCRIPTION = "Nautitech DAD configuration files."
DEPENDS = ""
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRCREV = "master"
SRC_URI = " \
	git:///home/harshahs/dad_software;protocol=file;tag=master \
	file://Users.db \
"
#S = "${WORKDIR}/git/conf"

do_install() {
	install -d ${D}/home/root/conf
	install -m 0664 ${WORKDIR}/git/conf/* ${D}/home/root/conf/

	install -d ${D}/home/root/data
	install -m 0664 ${WORKDIR}/Users.db ${D}/home/root/data/Users.db
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "/home/ /home/root/ /home/root/conf/ /home/root/conf/*"
FILES_${PN} += "/home/ /home/root/ /home/root/data/ /home/root/data/Users.db"
