package com.duokan.core.sys;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class aq {
    public static Map a() {
        Map allStackTraces = Thread.getAllStackTraces();
        Thread b = t.b();
        if (!allStackTraces.containsKey(b)) {
            allStackTraces.put(b, b.getStackTrace());
        }
        return allStackTraces;
    }

    public static List b() {
        List linkedList = new LinkedList(a().entrySet());
        Collections.sort(linkedList, new ar(t.b()));
        return linkedList;
    }
}
