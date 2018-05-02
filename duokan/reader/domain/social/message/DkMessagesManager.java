package com.duokan.reader.domain.social.message;

import android.content.Context;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class DkMessagesManager implements z {
    private static Object a = new Object();
    private final Context b;
    private final i c;
    private final int[] d;
    private final String e;
    private final int f;
    private final o g;
    private final h h;
    private final LinkedList i = new LinkedList();
    private final ar j = new ar();
    private ab k;
    private String[] l = new String[0];
    private boolean m = false;
    private boolean n = true;

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

    protected DkMessagesManager(Context context, o oVar, i iVar, int[] iArr, String str, int i) {
        this.b = context;
        this.g = oVar;
        this.c = iVar;
        this.d = iArr;
        this.e = str;
        this.f = i;
        this.k = new ab(this.c.b(PersonalAccount.class));
        this.h = new ad(this);
        DkApp.get().runPreReady(new ae(this));
    }

    public void a(az azVar) {
        if (azVar != null && !this.i.contains(azVar)) {
            this.i.add(azVar);
        }
    }

    public void b(az azVar) {
        this.i.remove(azVar);
    }

    private void a() {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            ((az) it.next()).b();
        }
    }

    public int b() {
        return this.l.length;
    }

    public String[] c() {
        return this.l;
    }

    private void g() {
        if (!this.k.a()) {
            new af(this, this.k).open();
        }
    }

    public void a(Collection collection, ax axVar) {
        if (this.k.a()) {
            axVar.a(new k[0], "");
            return;
        }
        if (collection.size() == 0) {
            axVar.a(new k[0], false);
        }
        new ag(this, collection, this.k, axVar).open();
    }

    public void d() {
        if (!this.k.a() && this.l.length != 0) {
            a(new String[0]);
            new ah(this, this.k).open();
        }
    }

    protected void e() {
    }

    public void a(int i, int i2, boolean z, ax axVar) {
        ax axVar2;
        if (axVar != null) {
            axVar2 = axVar;
        } else {
            axVar2 = new ai(this);
        }
        if (z || !this.k.a()) {
            this.c.a(PersonalAccount.class, new aj(this, i, i2, axVar2, z));
        } else {
            axVar2.a(new k[0], "");
        }
    }

    public void a(List list, aw awVar) {
        if (list.size() == 0) {
            awVar.a();
        } else {
            this.c.a(PersonalAccount.class, new an(this, list, awVar));
        }
    }

    public boolean a(k kVar) {
        for (int i : this.d) {
            if (kVar.c == i) {
                return true;
            }
        }
        return false;
    }

    public final void a(ArrayList arrayList, HashMap hashMap, aa aaVar) {
        if (this.k.a()) {
            aaVar.a(false);
        } else if (arrayList.size() == 0) {
            aaVar.a(true);
        } else {
            Collections.sort(arrayList, new au());
            new aq(this, this.k, arrayList, hashMap, aaVar).open();
        }
    }

    public void a(ay ayVar) {
        this.j.a(ayVar);
        ayVar.a(this);
    }

    private void a(String[] strArr) {
        Object obj = null;
        Object obj2 = this.l.length != strArr.length ? 1 : null;
        if (!(this.l.length == 0 && strArr.length == 0)) {
            obj = 1;
        }
        this.l = strArr;
        if (obj != null) {
            this.j.a(this);
        }
        if (obj2 != null) {
            a();
        }
    }
}
