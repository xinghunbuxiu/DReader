package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.C0612j;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import com.mipay.sdk.Mipay;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class av implements ai, C0586j, ao {
    /* renamed from: a */
    private static final aj<av> f3713a = new aj();
    /* renamed from: b */
    private final Context f3714b;
    /* renamed from: c */
    private final C0709k f3715c;
    /* renamed from: d */
    private final LinkedList<bc> f3716d = new LinkedList();
    /* renamed from: e */
    private bb f3717e = new bb();
    /* renamed from: f */
    private al f3718f = null;
    /* renamed from: g */
    private WebSession f3719g = null;

    private av(Context context, C0709k c0709k) {
        this.f3714b = context;
        this.f3715c = c0709k;
        this.f3718f = new al(this.f3715c.m3502b(PersonalAccount.class));
        DkApp.get().runPreReady(new aw(this));
    }

    /* renamed from: a */
    public static void m5322a(Context context, C0709k c0709k) {
        f3713a.m709a(new av(context, c0709k));
    }

    /* renamed from: a */
    public static av m5316a() {
        return (av) f3713a.m707a();
    }

    /* renamed from: b */
    public bb m5334b() {
        return this.f3717e;
    }

    /* renamed from: c */
    public void m5336c() {
        m5326a(false, true, null);
    }

    /* renamed from: a */
    public void m5333a(bc bcVar) {
        this.f3716d.add(bcVar);
    }

    /* renamed from: b */
    public void m5335b(bc bcVar) {
        this.f3716d.remove(bcVar);
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3718f = new al(c0672a);
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m5326a(false, true, null);
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.f3718f = al.f2359g;
        this.f3717e = new bb();
        DkSharedStorageManager.m5016a().m5027b(SharedKey.USER_PRIVILEGE);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public void mo1154a(SharedKey sharedKey, Serializable serializable) {
        if (sharedKey == SharedKey.USER_PRIVILEGE) {
            if (this.f3719g != null) {
                this.f3719g.close();
                this.f3719g = null;
            }
            this.f3719g = new ax(this, C0612j.f2035a, serializable);
            this.f3719g.open(1000);
        }
    }

    /* renamed from: a */
    public void mo1153a(SharedKey sharedKey) {
        if (sharedKey == SharedKey.USER_PRIVILEGE) {
            this.f3717e = new bb();
        }
    }

    /* renamed from: d */
    private void m5329d() {
        Iterator it = this.f3716d.iterator();
        while (it.hasNext()) {
            ((bc) it.next()).mo1914a(this.f3717e);
        }
    }

    /* renamed from: a */
    private bb m5320a(String str, String str2) {
        bb bbVar = new bb();
        if (TextUtils.isEmpty(str2)) {
            return bbVar;
        }
        JSONObject jSONObject = new JSONObject(str2).getJSONObject("__data__");
        int i = jSONObject.getInt(Mipay.KEY_RESULT);
        CharSequence string = jSONObject.getString("key");
        if (i == 0 && TextUtils.equals(str, string)) {
            return m5321a(jSONObject);
        }
        return bbVar;
    }

    /* renamed from: a */
    private bb m5321a(JSONObject jSONObject) {
        bb bbVar = new bb();
        long optLong = jSONObject.optLong("time", 0) * 1000;
        bbVar.f3740a = Math.max(optLong, jSONObject.optLong("book", 0) * 1000);
        bbVar.f3741b = Math.max(optLong, jSONObject.optLong("fiction", 0) * 1000);
        bbVar.f3742c = Math.max(optLong, jSONObject.optLong("comic", 0) * 1000);
        return bbVar;
    }

    /* renamed from: a */
    private void m5325a(boolean z) {
        UserAccount d = this.f3715c.m3508d();
        if (d != null && !d.mo839i()) {
            new ay(this, C0612j.f2035a, z).open();
        }
    }

    /* renamed from: a */
    private void m5326a(boolean z, boolean z2, C0517a c0517a) {
        if (z || this.f3715c.m3501b() != AccountType.NONE) {
            this.f3715c.m3497a(PersonalAccount.class, new az(this, c0517a, z));
        } else if (c0517a != null) {
            c0517a.mo729a(-1, "");
        }
    }
}
