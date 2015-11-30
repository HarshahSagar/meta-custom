#
# Nautitech DAD data manager recipe
#

DESCRIPTION = "Nautitech DAD data manager application."
DEPENDS = ""
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

#SRC_URI = "file:///home/harshahs/dad_software/"
#S = "${WORKDIR}/home/harshahs/dad_software/data_manager"

SRCREV = "master"
#SRC_URI = "git:///media/nautitech_software/dad_software.git;protocol=file"
#SRC_URI = "git:///home/harshahs/dad_software;protocol=file;tag=master"
SRC_URI = " \
	git:///home/harshahs/dad_software;protocol=file;tag=master \
	file://data-manager.init \
"

#SRC_URI_append = " \
#	file://data-manager.init \
#"

S = "${WORKDIR}/git/data_manager"

require recipes-qt/qt5/qt5.inc

inherit update-rc.d

do_install() {
	install -d ${D}/home/root/bin
	install -m 0755 ${B}/data_manager ${D}/home/root/bin

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/data-manager.init ${D}${sysconfdir}/init.d/data-manager
#	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/data-manager
#	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/data-manager
}

INITSCRIPT_NAME = "data-manager"
INITSCRIPT_PARAMS = "defaults 90 20"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "/home/ /home/root/ /home/root/bin/ /home/root/bin/data_manager"

RDEPENDS_${PN} = "qtbase qtwebsockets"
