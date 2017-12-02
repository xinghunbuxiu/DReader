package com.duokan.core.sys;

import java.util.Comparator;
import java.util.Map.Entry;

final class ar implements Comparator {
    final /* synthetic */ Thread a;

    ar(Thread thread) {
        this.a = thread;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Entry) obj, (Entry) obj2);
    }

    public int a(Entry entry, Entry entry2) {
        if (entry.getKey() == this.a) {
            return -1;
        }
        if (entry2.getKey() == this.a) {
            return 1;
        }
        return ((Thread) entry.getKey()).toString().compareTo(((Thread) entry2.getKey()).toString());
    }
}
