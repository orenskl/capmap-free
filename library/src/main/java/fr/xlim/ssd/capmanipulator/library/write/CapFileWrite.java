package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class CapFileWrite {

    private final static Logger logger = LoggerFactory.getLogger(CapFileWrite.class);
    private final CapOutputStream outputStream;

    public CapFileWrite(CapOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void close() throws UnableToWriteCapFileException {
        this.outputStream.close();
    }

    /*
    public void writeFile(CapFile capFile) throws Exception {
        for (Component component : capFile.getComponents()) {
            component.write(outputStream);
        }
    }
    */

    /**
     * Write a CAP File as the order specified by the specification
     *
     * @param capFile The CAP File to write
     * @throws UnableToWriteCapFileException This exception is thrown when a write error is occurred
     */
    public void writeFileOrder(CapFile capFile) throws UnableToWriteCapFileException {
        if (capFile.getHeaderComponent() != null) {
            new HeaderComponentWrite().write(outputStream, capFile.getHeaderComponent());
        }

        if (capFile.getDirectoryComponent() != null) {
            new DirectoryComponentWrite().write(outputStream, capFile.getDirectoryComponent());
        }

        if (capFile.getImportComponent() != null) {
            new ImportComponentWrite().write(outputStream, capFile.getImportComponent());
        }

        // This component can be optional in case of an API or library
        if (capFile.getAppletComponent() != null) {
            new AppletComponentWrite().write(outputStream, capFile.getAppletComponent());
        }

        if (capFile.getClassComponent() != null) {
            new ClassComponentWrite().write(outputStream, capFile.getClassComponent());
        }

        if (capFile.getMethodComponent() != null) {
            new MethodComponentWrite().write(outputStream, capFile.getMethodComponent());
        }

        if (capFile.getStaticFieldComponent() != null) {
            new StaticFieldComponentWrite().write(outputStream, capFile.getStaticFieldComponent());
        }

        if (capFile.getExportComponent() != null) {
            new ExportComponentWrite().write(outputStream, capFile.getExportComponent());
        }

        if (capFile.getConstantPoolComponent() != null) {
            new ConstantPoolComponentWrite().write(outputStream, capFile.getConstantPoolComponent());
        }

        if (capFile.getReferenceLocationComponent() != null) {
            new ReferenceLocationComponentWrite().write(outputStream, capFile.getReferenceLocationComponent());
        }

        if (capFile.getDescriptorComponent() != null) {
            new DescriptorComponentWrite().write(outputStream, capFile.getDescriptorComponent());
        }
    }

    /**
     * Writing a CapFile as a Jar File
     *
     * @param capFile     The CAP File to write
     * @param packageName Outputed Package Name
     * @throws IOException
     * @throws UnableToWriteCapFileException
     */
    public void writeJarFile(CapFile capFile, String packageName) throws IOException, UnableToWriteCapFileException {

        JarOutputStream jar = new JarOutputStream(this.outputStream.getOut());
        CapOutputStream out = new CapOutputStream(jar);

        if (capFile.getHeaderComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Header.cap"));
            new HeaderComponentWrite().write(out, capFile.getHeaderComponent());
            jar.closeEntry();
        }

        if (capFile.getDirectoryComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Directory.cap"));
            new DirectoryComponentWrite().write(out, capFile.getDirectoryComponent());
            jar.closeEntry();
        }

        if (capFile.getImportComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Import.cap"));
            new ImportComponentWrite().write(out, capFile.getImportComponent());
            jar.closeEntry();
        }

        if (capFile.getAppletComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Applet.cap"));
            new AppletComponentWrite().write(out, capFile.getAppletComponent());
            jar.closeEntry();
        }

        if (capFile.getClassComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Class.cap"));
            new ClassComponentWrite().write(out, capFile.getClassComponent());
            jar.closeEntry();
        }

        if (capFile.getMethodComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Method.cap"));
            new MethodComponentWrite().write(out, capFile.getMethodComponent());
            jar.closeEntry();
        }

        if (capFile.getStaticFieldComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/StaticField.cap"));
            new StaticFieldComponentWrite().write(out, capFile.getStaticFieldComponent());
            jar.closeEntry();
        }

        if (capFile.getExportComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Export.cap"));
            new ExportComponentWrite().write(out, capFile.getExportComponent());
            jar.closeEntry();
        }

        if (capFile.getConstantPoolComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/ConstantPool.cap"));
            new ConstantPoolComponentWrite().write(out, capFile.getConstantPoolComponent());
            jar.closeEntry();
        }

        if (capFile.getReferenceLocationComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/RefLocation.cap"));
            new ReferenceLocationComponentWrite().write(out, capFile.getReferenceLocationComponent());
            jar.closeEntry();
        }

        if (capFile.getDescriptorComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Descriptor.cap"));
            new DescriptorComponentWrite().write(out, capFile.getDescriptorComponent());
            jar.closeEntry();
        }

        if (capFile.getDebugComponent() != null) {
            jar.putNextEntry(new JarEntry(packageName + "/javacard/Debug.cap"));
            new DescriptorComponentWrite().write(out, capFile.getDebugComponent());
            jar.closeEntry();
        }

        jar.finish();
    }
}
