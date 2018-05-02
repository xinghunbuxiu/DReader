package com.duokan.reader.domain.ad;

import java.util.Comparator;
import org.apache.http.NameValuePair;

/* renamed from: com.duokan.reader.domain.ad.d */
class C0747d implements Comparator<NameValuePair> {
    /* renamed from: a */
    final /* synthetic */ C0746c f2515a;

    C0747d(C0746c c0746c) {
        this.f2515a = c0746c;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m3554a((NameValuePair) obj, (NameValuePair) obj2);
    }

    /* renamed from: a */
    public int m3554a(NameValuePair nameValuePair, NameValuePair nameValuePair2) {
        return nameValuePair.getName().compareTo(nameValuePair2.getName());
    }
}
