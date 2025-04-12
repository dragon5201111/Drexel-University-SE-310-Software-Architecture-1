public class MacComputer implements Computer {
    @Override
    public String getType() {
        return "mac";
    }

    @Override
    public String getGpuType() {
        return "nvidia";
    }

    @Override
    public String getCpuType() {
        return "amd";
    }
}
