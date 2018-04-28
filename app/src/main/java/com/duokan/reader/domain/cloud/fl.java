package com.duokan.reader.domain.cloud;

import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class fl implements ai, ao {
    /* renamed from: a */
    private static final aj<fl> f4002a = new aj();
    /* renamed from: b */
    private final C0709k f4003b;
    /* renamed from: c */
    private final C0586j f4004c;
    /* renamed from: d */
    private final LinkedList<fq> f4005d = new LinkedList();
    /* renamed from: e */
    private fr f4006e = new fp(this);
    /* renamed from: f */
    private int f4007f = 0;

    private fl(C0709k c0709k) {
        this.f4003b = c0709k;
        this.f4004c = new fm(this);
        DkApp.get().runPreReady(new fn(this));
        this.f4007f = m5552a(DkSharedStorageManager.m5016a().m5022a(SharedKey.CART_CACHE));
        switch (ReaderEnv.get().getShoppingCartSituation()) {
            case 0:
                this.f4006e = new fo(this);
                return;
            case 1:
                this.f4006e = new fs(this);
                return;
            default:
                this.f4006e = new fp(this);
                return;
        }
    }

    /* renamed from: a */
    public static void m5555a(C0709k c0709k) {
        f4002a.m709a(new fl(c0709k));
    }

    /* renamed from: a */
    public static fl m5554a() {
        return (fl) f4002a.m707a();
    }

    /* renamed from: b */
    public fr m5562b() {
        return this.f4006e;
    }

    /* renamed from: a */
    public void m5561a(fq fqVar) {
        this.f4005d.add(fqVar);
    }

    /* renamed from: b */
    public void m5563b(fq fqVar) {
        this.f4005d.remove(fqVar);
    }

    /* renamed from: c */
    public void m5564c() {
        this.f4006e.mo1166a(this);
    }

    /* renamed from: a */
    public void mo1154a(SharedKey sharedKey, Serializable serializable) {
        if (sharedKey == SharedKey.CART_CACHE) {
            int a = m5552a((String) serializable);
            if (this.f4007f != a) {
                if (a > this.f4007f || a == 0) {
                    this.f4006e.mo1167a(this, a);
                }
                this.f4007f = a;
            }
        }
    }

    /* renamed from: a */
    public void mo1153a(SharedKey sharedKey) {
        if (sharedKey == SharedKey.CART_CACHE) {
            this.f4007f = 0;
            this.f4006e.mo1167a(this, this.f4007f);
        }
    }

    /* renamed from: a */
    private void m5557a(fr frVar) {
        if (!this.f4006e.equals(frVar)) {
            int i;
            this.f4006e = frVar;
            if (this.f4006e instanceof fo) {
                i = 0;
            } else if (this.f4006e instanceof fs) {
                i = 1;
            } else {
                i = 2;
            }
            ReaderEnv.get().setShoppingCartSituation(i);
            Iterator it = this.f4005d.iterator();
            while (it.hasNext()) {
                ((fq) it.next()).mo1915a(this.f4006e);
            }
        }
    }

    /* renamed from: a */
    private int m5552a(String str) {
        try {
            return new JSONObject(str).optJSONObject("__data__").optJSONArray("items").length();
        } catch (Exception e) {
            return 0;
        }
    }
}
