package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class bd implements ah, h, av {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final LinkedList d = new LinkedList();
    private bk e = new bk();
    private ab f = null;
    private j g = null;

    private bd(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
        this.f = new ab(this.c.b(PersonalAccount.class));
        DkApp.get().runPreReady(new be(this));
    }

    public static void a(Context context, i iVar) {
        a.a(new bd(context, iVar));
    }

    public static bd a() {
        return (bd) a.a();
    }

    public bk b() {
        return this.e;
    }

    public void c() {
        a(false, true, null);
    }

    public void a(bl blVar) {
        this.d.add(blVar);
    }

    public void b(bl blVar) {
        this.d.remove(blVar);
    }

    public void a(a aVar) {
        this.f = new ab(aVar);
    }

    public void b(a aVar) {
        a(false, true, null);
    }

    public void c(a aVar) {
        this.f = ab.g;
        this.e = new bk();
        DkSharedStorageManager.a().b(SharedKey.USER_PRIVILEGE);
    }

    public void d(a aVar) {
    }

    public void a(SharedKey sharedKey, Serializable serializable) {
        if (sharedKey == SharedKey.USER_PRIVILEGE) {
            if (this.g != null) {
                this.g.close();
                this.g = null;
            }
            this.g = new bf(this, serializable);
            this.g.open(1000);
        }
    }

    public void a(SharedKey sharedKey) {
        if (sharedKey == SharedKey.USER_PRIVILEGE) {
            this.e = new bk();
        }
    }

    private void d() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((bl) it.next()).a(this.e);
        }
    }

    private bk a(String str, String str2) {
        bk bkVar = new bk();
        if (TextUtils.isEmpty(str2)) {
            return bkVar;
        }
        JSONObject jSONObject = new JSONObject(str2).getJSONObject("__data__");
        int i = jSONObject.getInt(Mipay.KEY_RESULT);
        CharSequence string = jSONObject.getString("key");
        if (i == 0 && TextUtils.equals(str, string)) {
            return a(jSONObject);
        }
        return bkVar;
    }

    private bk a(JSONObject jSONObject) {
        bk bkVar = new bk();
        long optLong = jSONObject.optLong("time", 0) * 1000;
        bkVar.a = Math.max(optLong, jSONObject.optLong("book", 0) * 1000);
        bkVar.b = Math.max(optLong, jSONObject.optLong("fiction", 0) * 1000);
        bkVar.c = Math.max(optLong, jSONObject.optLong("comic", 0) * 1000);
        return bkVar;
    }

    private void a(boolean z) {
        UserAccount c = this.c.c();
        if (c != null && !c.i()) {
            new bg(this, z).open();
        }
    }

    private void a(boolean z, boolean z2, com.duokan.reader.common.async.a.a aVar) {
        if (z || this.c.a() != AccountType.NONE) {
            this.c.a(PersonalAccount.class, new bh(this, z, aVar, z2));
        } else if (aVar != null) {
            aVar.a(-1, "");
        }
    }
}
