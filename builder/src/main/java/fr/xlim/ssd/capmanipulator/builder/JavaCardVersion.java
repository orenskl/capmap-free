package fr.xlim.ssd.capmanipulator.builder;

public enum JavaCardVersion {
    VERSION_2_1_1("2.1.1", false),
    VERSION_2_1_2("2.1.2", false),
    VERSION_2_2_1("2.2.1", true),
    VERSION_2_2_2("2.2.2", true);

    private String version;

    private boolean version22;

    JavaCardVersion(String version, boolean version22) {
        this.version = version;
        this.version22 = version22;
    }

    boolean isVersion21() {
        return !version22;
    }

    boolean isVersion22() {
        return version22;
    }

    public String getVersion() {
        return version;
    }
}
