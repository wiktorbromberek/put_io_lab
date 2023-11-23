package put.io.patterns.implement;

public class SystemGarbageCollectorObserver  implements SystemMonitor.SystemStateObserver {

    @Override
    public void update(SystemMonitor monitor) {
        SystemState lastSystemState = monitor.getLastSystemState();
        System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
    }
}
