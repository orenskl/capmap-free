package fr.xlim.ssd.capmanipulator.builder

import groovy.util.logging.Slf4j

@Slf4j("logger")
class ProjectConfiguration extends ConfigObject {

    ProjectConfiguration(File projectDir, File buildDir) {
        assert projectDir.exists()
        assert projectDir.isDirectory()
        assert projectDir.canRead()

        AntBuilder ant = new AntBuilder()

        def propertiesFile = new File(projectDir.absolutePath + File.separator + "project.properties")
        assert propertiesFile.exists()
        assert propertiesFile.isFile()
        assert propertiesFile.canRead()

        def props = new Properties()
        props.load(propertiesFile.newReader())
        def config = new ConfigSlurper().parse(props)

        logger.debug("project.directory: {}", projectDir)
        config["project"]["directory"] = projectDir

        logger.debug("project.properties: {}", propertiesFile)
        config["project"]["properties"] = propertiesFile

        def srcDir = new File(projectDir.absolutePath + File.separator + "src")
        assert srcDir.exists()
        assert srcDir.isDirectory()
        assert srcDir.canRead()
        logger.debug("project.sources.directory: {}", srcDir)
        config["project"]["sources"]["directory"] = srcDir

        // create build directory
        ant.delete(dir: buildDir)
        ant.mkdir(dir: buildDir)
        logger.debug("project.build.directory: {}", buildDir)
        config["project"]["build"]["directory"] = buildDir

        // create build directory
        def classesDir = new File(buildDir.absolutePath + File.separator + "classes")
        ant.mkdir(dir: classesDir)
        logger.debug("project.classes.directory: {}", classesDir)
        config["project"]["classes"]["directory"] = classesDir

        // create output directory
        def outputDir = new File(buildDir.getAbsolutePath() + File.separator + "output")
        ant.mkdir(dir: outputDir)
        logger.debug("project.output.directory: {}", outputDir)
        config["project"]["output"]["directory"] = outputDir

        putAll(config)
    }

    public File getJcaFile() {
        return this["results"]["jca"]["file"];
    }

    public File getCapFile() {
        return this["results"]["cap"]["file"];
    }

    public File getExpFile() {
        return this["results"]["exp"]["file"];
    }
}