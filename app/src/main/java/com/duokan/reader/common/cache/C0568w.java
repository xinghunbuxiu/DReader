package com.duokan.reader.common.cache;

import com.duokan.core.p029c.C0326b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: com.duokan.reader.common.cache.w */
public interface C0568w<TItem, TFilter extends C0326b<TItem>, TComparator extends Comparator<TItem>> {
    /* renamed from: a */
    C0584z mo756a(String str);

    /* renamed from: a */
    Collection<String> mo757a(int i);

    /* renamed from: a */
    Collection<String> mo758a(TFilter tFilter, TComparator tComparator, C0582t c0582t);

    /* renamed from: a */
    TComparator mo759a();

    /* renamed from: a */
    void mo760a(ArrayList<C0583x> arrayList);

    /* renamed from: a */
    void mo761a(Collection<String> collection);

    /* renamed from: b */
    int mo762b();

    /* renamed from: b */
    Collection<C0584z> mo763b(TFilter tFilter, TComparator tComparator, C0582t c0582t);

    /* renamed from: c */
    int mo764c();

    /* renamed from: c */
    Collection<C0584z> mo765c(TFilter tFilter, TComparator tComparator, C0582t c0582t);

    /* renamed from: d */
    String mo766d();
}
