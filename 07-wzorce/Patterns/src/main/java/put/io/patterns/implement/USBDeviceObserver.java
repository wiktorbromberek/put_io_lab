package put.io.patterns.implement;

public class USBDeviceObserver  implements SystemMonitor.SystemStateObserver{
    @Override
    public void update(SystemMonitor monitor) {
        SystemState lastSystemState = monitor.getLastSystemState();
        System.out.println(String.format("USB devices: %d", lastSystemState.getUsbDevices()));
    }
}
