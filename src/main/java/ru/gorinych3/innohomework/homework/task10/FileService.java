package ru.gorinych3.innohomework.homework.task10;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class FileService {

    private final String interfaceFileName;
    private final String someClassFileName;
    private static final String EXT_JAVA = ".java";
    final Logger log = LogManager.getLogger(this.getClass().getName());
    private final MyClassLoader classLoader = new MyClassLoader();

    public FileService(String interfaceFileName, String someClassFileName) {
        this.interfaceFileName = interfaceFileName;
        this.someClassFileName = someClassFileName;
    }

    public void startProcess() {
        String interfaceText = injectRealisation();
        CustomFileWriter.write2JavaFile(new File(someClassFileName + EXT_JAVA), interfaceText);
        compileSomeClass();
        try {
            Class<?> clazz = loadClass();
            runMethod(clazz);
        } catch (ClassNotFoundException exception) {
            log.error("exception при загрузке класса");
            log.error(exception);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String injectRealisation() {
        String interfaceText = getTextFromList(CustomFileReader.readFile(
                new File(interfaceFileName + EXT_JAVA)))
                .replace("interface Worker", "class SomeClass");

        interfaceText = interfaceText.replace("package ru.gorinych3.innohomework.homework.task10;\n", "");

        String methodText = "public void doWork() {" + getTextFromList(ConsoleReader.readLines()) + "}";
        interfaceText = interfaceText.replace("void doWork();", methodText);
        return interfaceText;
    }

    private void compileSomeClass() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, someClassFileName + EXT_JAVA);
    }

    private Class<?> loadClass() throws ClassNotFoundException {
        return Class.forName(someClassFileName, true, classLoader);
    }

    private void runMethod(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method method = clazz.getMethod("doWork");
        method.invoke(clazz.newInstance());
    }

    private String getTextFromList(List<String> strings) {
        StringBuilder text = new StringBuilder();
        for (String line : strings) {
            text.append(line);
        }
        return text.toString();
    }
}
