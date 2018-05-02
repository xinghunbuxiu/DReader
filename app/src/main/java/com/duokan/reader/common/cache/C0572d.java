package com.duokan.reader.common.cache;

/* renamed from: com.duokan.reader.common.cache.d */
public class C0572d<TInfo, TItem, TItemJson> extends ListCache<TInfo, TItem, TItemJson, ad<TItem>, ae<TItem>> {
    public C0572d(String str, C0575q<TItemJson> c0575q, C0447u<TInfo, TItem, TItemJson> c0447u, int i) {
        this(str, c0575q, c0447u, null, i);
    }

    public C0572d(String str, C0575q<TItemJson> c0575q, C0447u<TInfo, TItem, TItemJson> c0447u, ae<TItem> aeVar, int i) {
        super(str, c0575q, c0447u, aeVar, new af(c0447u, C0573e.m2572a()), i);
    }
}
