package com.duokan.core.sys;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class StackTracesInfo {
    public static Map<Thread, StackTraceElement[]> searchAllStack() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Thread b = TaskHandler.getThread();
        if (!allStackTraces.containsKey(b)) {
            allStackTraces.put(b, b.getStackTrace());
        }
        return allStackTraces;
    }

    public static List<Map.Entry> getAllSortStackTraces() {
        List<Map.Entry> linkedList = new LinkedList(searchAllStack().entrySet());
        Thread mainThread = TaskHandler.getThread();
        Collections.sort(linkedList, new compThread(mainThread));
        return linkedList;
    }

    static final class compThread implements Comparator<Map.Entry> {
        final Thread thread;

        compThread(Thread thread) {
            this.thread = thread;
        }


        @Override
        public int compare(Map.Entry o1, Map.Entry o2) {
            return a(o1, o2);
        }

        public int a(Map.Entry entry, Map.Entry entry2) {
            if (entry.getKey() == this.thread) {
                return -1;
            }
            if (entry2.getKey() == this.thread) {
                return 1;
            }
            return entry.getKey().toString().compareTo(entry2.getKey().toString());
        }


    }

}
