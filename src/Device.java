public class Device {

    private String name;
    private String version;

    public Device (String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getDevice() {
        return "Device name : " + this.name + " version : " + this.version;
    }
}
