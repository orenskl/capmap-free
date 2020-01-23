package fr.xlim.ssd.capmanipulator.builder

import groovy.util.logging.Slf4j

@Slf4j("logger")
public class JavaCardHelper {

    private AntBuilder ant = new AntBuilder();

    private JavaCardVersion javaCardVersion;

    JavaCardHelper(JavaCardVersion javaCardVersion) {
        assert javaCardVersion != null
        this.javaCardVersion = javaCardVersion
    }

    public void compile(ConfigObject configuration) {

        def compilationClassPath = null;
        def javaTarget = null;

        if (javaCardVersion.version21) {
            compilationClassPath = FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/jcdk/${javaCardVersion.version}/libs/api21.jar"
            javaTarget = "1.1";
        } else if (javaCardVersion.version22) {
            compilationClassPath = FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/jcdk/${javaCardVersion.version}/libs/api.jar" + File.pathSeparator + FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/global-platform/r6/libs/gse_Usim_Card_R6.jar"
            javaTarget = "1.2"
        } else {
            throw IllegalStateException("javacard version not supported: " + javaCardVersion);
        }

        // get libraries
        checkClassPath(compilationClassPath)
        logger.trace("Compilation classpath: {}", compilationClassPath)

        // compile sources
        ant.property(name: "build.compiler", value: "extJavac")
        ant.javac(source: "1.3", target: javaTarget, debug: true,
                classpath: compilationClassPath,
                srcdir: configuration.project.sources.directory,
                destdir: configuration.project.classes.directory,
                includeantruntime: false)
    }

    public void convert(ConfigObject configuration, boolean debug) {
        // declaring javacard ant tasks
        def antTaskClassPath = FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/jcdk/2.2.2/libs/jctasks.jar";
        checkClassPath(antTaskClassPath)

        ant.path(id: "javacard-ant-tasks-classpath") {
            pathelement(path: antTaskClassPath)
        }
        ant.taskdef(name: "convert", classname: "com.sun.javacard.ant.tasks.ConverterTask",
                classpathref: "javacard-ant-tasks-classpath")
        logger.trace("Ant task classpath: {}", antTaskClassPath)
        // convert to cap file
        def converterClassPath = FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/jcdk/${javaCardVersion.version}/libs/converter.jar"
        checkClassPath(converterClassPath)
        logger.trace("Converter classpath: {}", converterClassPath)
        def verifierClassPath = FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/jcdk/${javaCardVersion.version}/libs/offcardverifier.jar"
        checkClassPath(verifierClassPath)
        logger.trace("Verifier classpath: {}", verifierClassPath)
        ant.path(id: "javacard-converter-classpath") {
            pathelement(path: converterClassPath)
            pathelement(path: verifierClassPath)
        }

        ant.convert(
                debug: debug,
                packagename: configuration.jc."package".name,
                packageaid: configuration.jc."package".AID,
                majorminorversion: configuration.jc."package".version,
                classpathref: "javacard-converter-classpath",
                nobanner: false, JCA: true, EXP: true, CAP: true,
                dir: configuration.project.classes.directory,
                exportpath: FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/jcdk/${javaCardVersion.version}/exports/" + File.pathSeparator + FileManagement.getProjectRoot().absolutePath + File.separator + "javacard/global-platform/r6/exports/",
                outputdirectory: configuration.project.output.directory) {
            AppletNameAID(
                    appletname: configuration.jc."package".name + '.' + configuration.jc.applet.name,
                    aid: configuration.jc.applet.AID)
        }
    }

    private void checkClassPath(String classpath) {
        classpath.split(".").each {
            def lib = new File(it)
            assert lib.exists()
            assert lib.canRead()
        }
    }
}