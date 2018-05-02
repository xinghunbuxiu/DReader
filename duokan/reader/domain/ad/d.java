package com.duokan.reader.domain.ad;

import org.apache.http.NameValuePair;

import java.util.Comparator;

class d implements Comparator {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((NameValuePair) obj, (NameValuePair) obj2);
    }

    public int a(NameValuePair nameValuePair, NameValuePair nameValuePair2) {
        return nameValuePair.getName().compareTo(nameValuePair2.getName());
    }
}
