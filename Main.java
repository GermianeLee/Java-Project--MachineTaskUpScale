import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initialize 12 machines with their capacities
        List<MachineTaskUpScale> machines = Arrays.asList(
            new MachineTaskUpScale("SteelForm", "Press steel sheets", 30000, 30000),
            new MachineTaskUpScale("AutoAssem", "Assemble main structure", 360000, 360000),
            new MachineTaskUpScale("ElectroFit", "Install electrical components", 180000, 180000),
            new MachineTaskUpScale("CompTester", "Test components", 90000, 90000),
            new MachineTaskUpScale("LogicCore", "Install control units", 120000, 120000),
            new MachineTaskUpScale("FinalVerif", "Final appliance testing", 300000, 300000),
            new MachineTaskUpScale("MetalCutter", "Cut metal parts", 20000, 20000),
            new MachineTaskUpScale("WeldBot", "Weld components", 240000, 240000),
            new MachineTaskUpScale("PaintStation", "Apply protective coating", 120000, 120000),
            new MachineTaskUpScale("CircuitLoader", "Load circuit boards", 60000, 60000),
            new MachineTaskUpScale("QualityCheck", "Perform quality inspection", 180000, 180000),
            new MachineTaskUpScale("Packager", "Package final product", 120000, 120000)
        );

        // Generate 150 random tasks (1-300ms)
        List<Integer> tasks = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 150; i++) {
            tasks.add(rand.nextInt(300) + 1);
        }

        // Calculate total task time
        int totalTaskTime = tasks.stream().mapToInt(Integer::intValue).sum();

        // Sort tasks in descending order for greedy assignment
        Collections.sort(tasks, Collections.reverseOrder());

        // Assign tasks using greedy algorithm
        for (int task : tasks) {
            // Find machine with least load that can handle the task
            MachineTaskUpScale selectedMachine = null;
            int minLoad = Integer.MAX_VALUE;
            for (MachineTaskUpScale machine : machines) {
                if (machine.canAssign(task) && machine.getCurrentLoad() < minLoad) {
                    selectedMachine = machine;
                    minLoad = machine.getCurrentLoad();
                }
            }
            // If no machine can handle within capacity, assign to least loaded
            if (selectedMachine == null) {
                selectedMachine = Collections.min(machines, 
                    Comparator.comparingInt(MachineTaskUpScale::getCurrentLoad));
            }
            selectedMachine.assignTask(task);
        }

        // Output results
        System.out.println("Machine Task Assignments:");
        int totalCompletionTime = 0;
        for (MachineTaskUpScale machine : machines) {
            System.out.printf("%s (%s): %d milliseconds\n", 
                machine.getMachineId(), machine.getTaskDescription(), machine.getCurrentLoad());
            totalCompletionTime = Math.max(totalCompletionTime, machine.getCurrentLoad());
        }
        System.out.printf("Total task time: %d milliseconds\n", totalTaskTime);
        System.out.printf("Total completion time: %d milliseconds (%.2f minutes)\n", 
            totalCompletionTime, totalCompletionTime / 60000.0);
    }
}