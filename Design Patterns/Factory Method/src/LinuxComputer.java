public class LinuxComputer implements Computer {
    @Override
    public String getType() {
        return "linux";
    }

    @Override
    public String getGpuType() {
        return "";
    }

    @Override
    public String getCpuType() {
        return "";
    }
}
