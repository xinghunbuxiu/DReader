package com.duokan.reader.domain.social.message;

import android.content.Context;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.C0612j;
import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public abstract class DkMessagesManager implements C0586j, C1137x {
    /* renamed from: a */
    private static Object f5470a = new Object();
    /* renamed from: b */
    private final Context f5471b;
    /* renamed from: c */
    private final C0709k f5472c;
    /* renamed from: d */
    private final int[] f5473d;
    /* renamed from: e */
    private final String f5474e;
    /* renamed from: f */
    private final int f5475f;
    /* renamed from: g */
    private final C1153o f5476g;
    /* renamed from: h */
    private final LinkedList<au> f5477h = new LinkedList();
    /* renamed from: i */
    private final am f5478i = new am();
    /* renamed from: j */
    private al f5479j = al.f2359g;
    /* renamed from: k */
    private String[] f5480k = new String[0];
    /* renamed from: l */
    private boolean f5481l = false;
    /* renamed from: m */
    private boolean f5482m = true;

    class DkMessagesInfo implements Serializable {
        public String mAccountName;
        public String mAccountUuid;
        public String mReadThreshold;
        public String[] mUnreadMessageIds;
        public String mUnreadThreshold;

        private DkMessagesInfo() {
            this.mAccountUuid = null;
            this.mAccountName = null;
            this.mUnreadMessageIds = new String[0];
            this.mUnreadThreshold = "";
            this.mReadThreshold = "";
        }
    }

    protected DkMessagesManager(Context context, C1153o c1153o, C0709k c0709k, int[] iArr, String str, int i) {
        this.f5471b = context;
        this.f5476g = c1153o;
        this.f5472c = c0709k;
        this.f5473d = iArr;
        this.f5474e = str;
        this.f5475f = i;
        this.f5479j = new al(this.f5472c.m3502b(PersonalAccount.class));
        DkApp.get().runPreReady(new ab(this));
    }

    /* renamed from: a */
    public void m8484a(au auVar) {
        if (auVar != null && !this.f5477h.contains(auVar)) {
            this.f5477h.add(auVar);
        }
    }

    /* renamed from: b */
    public void m8490b(au auVar) {
        this.f5477h.remove(auVar);
    }

    /* renamed from: a */
    private void m8466a() {
        Iterator it = this.f5477h.iterator();
        while (it.hasNext()) {
            ((au) it.next()).mo1596b();
        }
    }

    /* renamed from: b */
    public int m8489b() {
        return this.f5480k.length;
    }

    /* renamed from: c */
    public String[] m8491c() {
        return this.f5480k;
    }

    /* renamed from: g */
    private void m8477g() {
        if (!this.f5479j.m3364a()) {
            new ac(this, C0612j.f2035a, this.f5479j).open();
        }
    }

    /* renamed from: a */
    public void m8486a(Collection<String> collection, as asVar) {
        if (this.f5479j.m3364a()) {
            asVar.mo1179a(new C1151k[0], "");
            return;
        }
        if (collection.size() == 0) {
            asVar.mo1180a(new C1151k[0], false);
        }
        new ad(this, C0612j.f2035a, collection, this.f5479j, asVar).open();
    }

    /* renamed from: d */
    public void m8492d() {
        if (!this.f5479j.m3364a() && this.f5480k.length != 0) {
            m8468a(new String[0]);
            new ae(this, ae.f2100a, this.f5479j).open();
        }
    }

    /* renamed from: e */
    protected void m8493e() {
    }

    /* renamed from: a */
    public void m8482a(int i, int i2, boolean z, as asVar) {
        as asVar2;
        if (asVar != null) {
            asVar2 = asVar;
        } else {
            asVar2 = new af(this);
        }
        if (z || !this.f5479j.m3364a()) {
            this.f5472c.m3497a(PersonalAccount.class, new ag(this, i, i2, asVar2, z));
        } else {
            asVar2.mo1179a(new C1151k[0], "");
        }
    }

    /* renamed from: a */
    public void m8487a(List<C1151k> list, ar arVar) {
        if (list.size() == 0) {
            arVar.mo1181a();
        } else {
            this.f5472c.m3497a(PersonalAccount.class, new aj(this, list, arVar));
        }
    }

    /* renamed from: a */
    public boolean mo1514a(C1151k c1151k) {
        for (int i : this.f5473d) {
            if (c1151k.f5556c == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo1513a(ArrayList<C1151k> arrayList, HashMap<String, JSONObject> hashMap, C1140y c1140y) {
        if (this.f5479j.m3364a()) {
            c1140y.mo1519a(false);
        } else if (arrayList.size() == 0) {
            c1140y.mo1519a(true);
        } else {
            Collections.sort(arrayList, new ap());
            new al(this, C0612j.f2035a, this.f5479j, arrayList, hashMap, c1140y).open();
        }
    }

    /* renamed from: a */
    public void m8483a(at atVar) {
        this.f5478i.m8519a(atVar);
        atVar.mo1173a(this);
    }

    /* renamed from: a */
    private void m8468a(String[] strArr) {
        Object obj = null;
        Object obj2 = this.f5480k.length != strArr.length ? 1 : null;
        if (!(this.f5480k.length == 0 && strArr.length == 0)) {
            obj = 1;
        }
        this.f5480k = strArr;
        if (obj != null) {
            this.f5478i.mo1173a(this);
        }
        if (obj2 != null) {
            m8466a();
        }
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f5479j = new al(c0672a);
        m8477g();
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.f5479j = new al(null);
        this.f5481l = false;
        this.f5482m = true;
        m8468a(new String[0]);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}
