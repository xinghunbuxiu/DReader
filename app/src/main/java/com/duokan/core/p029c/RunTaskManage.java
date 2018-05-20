package com.duokan.core.p029c;

import java.util.Iterator;


public class RunTaskManage {
    
    public static <T> T m738a(Iterable<T> iterable, IRunTask<T> runTask) {
        if (iterable == null || runTask == null) {
            return null;
        }
        for (T next : iterable) {
            if (runTask.isExitRunTask(next)) {
                return next;
            }
        }
        return null;
    }

    
    public static <T> T removeRunTask(Iterable<T> iterable, IRunTask<T> runTask) {
        if (iterable == null || runTask == null) {
            return null;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (runTask.isExitRunTask(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }
}
