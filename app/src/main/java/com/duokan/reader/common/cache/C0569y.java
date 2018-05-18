package com.duokan.reader.common.cache;

import com.duokan.core.p029c.IRunTask;
import java.util.Comparator;

/* renamed from: com.duokan.reader.common.cache.y */
public interface C0569y<TItem, TFilter extends IRunTask<TItem>, TComparator extends Comparator<TItem>> {
    /* renamed from: a */
    C0568w<TItem, TFilter, TComparator> mo767a(String str, TComparator tComparator, int i);

    /* renamed from: a */
    void mo768a(String str);
}
