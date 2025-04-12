public class ComputerFactory {

    public static Computer makeComputer(String computerName) {
        switch (computerName) {
            case "windows":
                return new WindowsComputer();
            case "mac":
                return new MacComputer();
            case "linux":
                return new LinuxComputer();
            default:
                throw new IllegalArgumentException("Unknown computer type: " + computerName);
        }
    }
}
