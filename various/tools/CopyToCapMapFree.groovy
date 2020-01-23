import groovy.io.FileType

def capMapFreeDir = new File("../capmap-free")
assert capMapFreeDir.exists()
log.info("found capmap-free")

assert new File(capMapFreeDir.absolutePath + File.separator + "pom.xml").exists()
log.info("found pom.xml")

def failure = false;

new File(capMapFreeDir.absolutePath + File.separator + "src/main/")
        .eachFileRecurse(FileType.FILES) {
    def fileNameFromFreeRootModule = it.absolutePath.substring(it.absolutePath.indexOf("src/"))
    def fileFromNonFreeRootModule = new File("library/" + fileNameFromFreeRootModule)

    assert fileFromNonFreeRootModule.exists()

    if (it.bytes == fileFromNonFreeRootModule.bytes) {
        log.info(fileFromNonFreeRootModule.absolutePath + " => NOT CHANGED")
    } else {
        log.info(fileFromNonFreeRootModule.canonicalPath + " *** CHANGED ***")
        failure = true;
    }
}

if(failure) {
    fail("differences between free and closed version")
}
