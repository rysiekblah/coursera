package com.kozlowst.management;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

/**
 * Created by tomek on 10/19/14.
 */
public class MemMonitor {
    public static void main(String[] args) {
        System.out.println("NonHeapMemUsage: " + ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage());
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println("Item: " + memoryPoolMXBean.getName() + ", type: " + memoryPoolMXBean.getType());
            System.out.println(" Usage            : " + memoryPoolMXBean.getUsage());
            System.out.println(" Peak             : " + memoryPoolMXBean.getPeakUsage());
            System.out.println(" Collection usage : " + memoryPoolMXBean.getCollectionUsage());
        }

    }

    /*
    * Setting PermSize larger then available mem throw this err:
OpenJDK 64-Bit Server VM warning: INFO: os::commit_memory(0x00007f6d3f800000, 34359738368, 0) failed; error='Cannot allocate memory' (errno=12)
#
# There is insufficient memory for the Java Runtime Environment to continue.
# Native memory allocation (malloc) failed to allocate 34359738368 bytes for committing reserved memory.
# An error report file with more information is saved as:
# /home/tomek/IdeaProjects/coursera/playground/hs_err_pid19307.log

Process finished with exit code 1
    * */
}
