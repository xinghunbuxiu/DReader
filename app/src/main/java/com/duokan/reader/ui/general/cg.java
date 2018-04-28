package com.duokan.reader.ui.general;

import com.duokan.reader.InputContentCache;
import com.duokan.reader.common.cache.C0444r;
import com.duokan.reader.common.cache.C0446p;
import org.json.JSONObject;

public class cg {
    /* renamed from: a */
    private static C0444r<cj, JSONObject> f7030a = new ch();
    /* renamed from: b */
    private static C0446p<cj, JSONObject> f7031b = new ci();
    /* renamed from: c */
    private final String f7032c;

    /* renamed from: a */
    public void m10364a(cj cjVar) {
        InputContentCache.putObject(this.f7032c, cjVar, f7030a);
    }

    /* renamed from: a */
    public void m10363a() {
        InputContentCache.remove(this.f7032c);
    }
}
