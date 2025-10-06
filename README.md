# Java-Project--MachineTaskUpScale
The Java program simulates task distribution across multiple machines in a smart factory.
It initializes 12 machines, each with a specific capacity and task type, then generates 
150 random tasks with execution times between 1 and 300 milliseconds. Using a greedy algorithm, 
the program assigns each task to the machine with the lowest current workload that can still handle it within capacity. 
If no machine can fit the task, it assigns it to the least loaded one. Finally, it displays each machine’s total workload,
overall task time, and the total completion time for all tasks.
