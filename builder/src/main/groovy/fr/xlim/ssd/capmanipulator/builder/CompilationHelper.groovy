package fr.xlim.ssd.capmanipulator.builder

import groovy.util.logging.Slf4j

@Slf4j("logger")
class CompilationHelper {

    private boolean executed = false

    private boolean DEBUG = false

    private Map configuration

    private JavaCardVersion javaCardVersion

    CompilationHelper(ProjectConfiguration projectConfiguration, JavaCardVersion javaCardVersion) {
        assert projectConfiguration != null
        assert javaCardVersion != null
        this.configuration = projectConfiguration
        this.javaCardVersion = javaCardVersion
    }

    CompilationHelper(ProjectConfiguration projectConfiguration, JavaCardVersion javaCardVersion, boolean debug) {
        assert projectConfiguration != null
        assert javaCardVersion != null
        this.configuration = projectConfiguration
        this.javaCardVersion = javaCardVersion
        this.DEBUG = debug
    }

    def build() {

        if (executed) {
            throw new IllegalStateException("project already builded")
        }

        executed = true;

        logger.info("starting new javacard build")

        JavaCardHelper javaCardHelper = new JavaCardHelper(javaCardVersion)

        logger.info("javacard version: {}", javaCardVersion)

        javaCardHelper.compile(configuration)

        javaCardHelper.convert(configuration, this.DEBUG)

        // check if files are available
        def pathToOutputFiles = new File(configuration.project.output.directory.absolutePath + File.separator +
                new String(configuration.jc."package".name).replace('.', File.separator) + File.separator + "javacard")
        assert pathToOutputFiles.exists()
        def filePattern = configuration.jc."package".name.substring(configuration.jc."package".name.lastIndexOf('.') + 1,
                configuration.jc."package".name.length())

        def expFile = new File(pathToOutputFiles.absolutePath + File.separator + filePattern + ".exp")
        assert expFile.exists()
        logger.debug("results.exp.file: {}", expFile)
        configuration["results"]["exp"]["file"] = expFile

        def jcaFile = new File(pathToOutputFiles.absolutePath + File.separator + filePattern + ".jca")
        logger.debug("results.jca.file: {}", jcaFile)
        configuration["results"]["jca"]["file"] = jcaFile

        def capFile = new File(pathToOutputFiles.absolutePath + File.separator + filePattern + ".cap")
        logger.debug("results.cap.file: {}", capFile)
        configuration["results"]["cap"]["file"] = capFile
    }

    boolean getExecuted() {
        return executed
    }

    Map getConfiguration() {
        return configuration
    }
}
