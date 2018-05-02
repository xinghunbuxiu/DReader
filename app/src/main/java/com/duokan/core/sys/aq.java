package com.duokan.core.sys;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class aq {
    /* renamed from: a */
    public static Map<Thread, StackTraceElement[]> m882a() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Thread b = UThread.getCurrentThread();
        if (!allStackTraces.containsKey(b)) {
            allStackTraces.put(b, b.getStackTrace());
        }
        return allStackTraces;
    }

    /* renamed from: b */
    public static List<Entry<Thread, StackTraceElement[]>> m883b() {
        List<Entry<Thread, StackTraceElement[]>> linkedList = new LinkedList(m882a().entrySet());
        Collections.sort(linkedList, new ar(UThread.getCurrentThread()));
        return linkedList;
    }
}
