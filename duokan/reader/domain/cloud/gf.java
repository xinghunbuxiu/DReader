package com.duokan.reader.domain.cloud;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class gf implements ah, av {
    private static final ai a = new ai();
    private final i b;
    private final h c;
    private final LinkedList d = new LinkedList();
    private gl e = new gj(this);
    private int f = 0;

    private gf(i iVar) {
        this.b = iVar;
        this.c = new gg(this);
        DkApp.get().runPreReady(new gh(this));
        this.f = a(DkSharedStorageManager.a().a(SharedKey.CART_CACHE));
        switch (ReaderEnv.get().getShoppingCartSituation()) {
            case 0:
                this.e = new gi(this);
                return;
            case 1:
                this.e = new gm(this);
                return;
            default:
                this.e = new gj(this);
                return;
        }
    }

    public static void a(i iVar) {
        a.a(new gf(iVar));
    }

    public static gf a() {
        return (gf) a.a();
    }

    public gl b() {
        return this.e;
    }

    public void a(gk gkVar) {
        this.d.add(gkVar);
    }

    public void b(gk gkVar) {
        this.d.remove(gkVar);
    }

    public void c() {
        this.e.a(this);
    }

    public void a(SharedKey sharedKey, Serializable serializable) {
        if (sharedKey == SharedKey.CART_CACHE) {
            int a = a((String) serializable);
            if (this.f != a) {
                if (a > this.f || a == 0) {
                    this.e.a(this, a);
                }
                this.f = a;
            }
        }
    }

    public void a(SharedKey sharedKey) {
        if (sharedKey == SharedKey.CART_CACHE) {
            this.f = 0;
            this.e.a(this, this.f);
        }
    }

    private void a(gl glVar) {
        if (!this.e.equals(glVar)) {
            int i;
            this.e = glVar;
            if (this.e instanceof gi) {
                i = 0;
            } else if (this.e instanceof gm) {
                i = 1;
            } else {
                i = 2;
            }
            ReaderEnv.get().setShoppingCartSituation(i);
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((gk) it.next()).a(this.e);
            }
        }
    }

    private int a(String str) {
        try {
            return new JSONObject(str).optJSONObject("__data__").optJSONArray("items").length();
        } catch (Exception e) {
            return 0;
        }
    }
}
