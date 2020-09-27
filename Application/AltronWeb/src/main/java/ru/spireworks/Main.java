package ru.spireworks;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        String projectName = ReadPropertyFile.getProperty(
                ConstantNames.APPLICATION_PROPERTY_FILE_PATH, ConstantNames.PROJECT_NAME_PROPERTY);
        String projectVersion = ReadPropertyFile.getProperty(
                ConstantNames.APPLICATION_PROPERTY_FILE_PATH, ConstantNames.PROJECT_VERSION_PROPERTY);

        System.out.println("Run " + projectName + " application!");
        System.out.println("Current version: " + projectVersion);
    }
}
