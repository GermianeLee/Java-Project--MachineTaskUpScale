public class MachineTaskUpScale {
    private String machineId;
    private String taskDescription;
    private int capacity;
    private int currentLoad;

    public MachineTaskUpScale(String id, String taskDesc, int taskTime, int cap) {
        this.machineId = id;
        this.taskDescription = taskDesc;
        this.capacity = cap;
        this.currentLoad = 0;
    }

    public boolean canAssign(int taskTime) {
        return currentLoad + taskTime <= capacity;
    }

    public void assignTask(int taskTime) {
        currentLoad += taskTime;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}