package com.duokan.core.sys;

import java.util.Comparator;
import java.util.Map.Entry;

final class ar implements Comparator<Entry<Thread, StackTraceElement[]>> {
    /* renamed from: a */
    final /* synthetic */ Thread f654a;

    ar(Thread thread) {
        this.f654a = thread;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m884a((Entry) obj, (Entry) obj2);
    }

    /* renamed from: a */
    public int m884a(Entry<Thread, StackTraceElement[]> entry, Entry<Thread, StackTraceElement[]> entry2) {
        if (entry.getKey() == this.f654a) {
            return -1;
        }
        if (entry2.getKey() == this.f654a) {
            return 1;
        }
        return ((Thread) entry.getKey()).toString().compareTo(((Thread) entry2.getKey()).toString());
    }
}
