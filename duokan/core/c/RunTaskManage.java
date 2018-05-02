package com.duokan.core.c;

import java.util.Iterator;

/**
 * 任务管理
 */
public class RunTaskManage {
    //队列查询 任务
    public static <T> T findRunTask(Iterable<T> iterable, IRunTask<T> bVar) {
        if (iterable == null || bVar == null) {
            return null;
        }
        for (T next : iterable) {
            if (bVar.isRunTask(next)) {
                return next;
            }
        }
        return null;
    }
    //删除任务
    public static <T> T removeRunTask(Iterable<T> iterable, IRunTask<T> bVar) {
        if (iterable == null || bVar == null) {
            return null;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (bVar.isRunTask(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }
}