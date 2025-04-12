public class WindowsComputer implements Computer {
    @Override
    public String getType() {
        return "windows";
    }

    @Override
    public String getGpuType() {
        return "nvidia";
    }

    @Override
    public String getCpuType() {
        return "intel";
    }
}
