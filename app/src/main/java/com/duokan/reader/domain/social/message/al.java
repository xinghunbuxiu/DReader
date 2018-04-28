package com.duokan.reader.domain.social.message;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class al extends WebSession {
    /* renamed from: a */
    final /* synthetic */ com.duokan.reader.domain.account.al f5517a;
    /* renamed from: b */
    final /* synthetic */ ArrayList f5518b;
    /* renamed from: c */
    final /* synthetic */ HashMap f5519c;
    /* renamed from: d */
    final /* synthetic */ C1140y f5520d;
    /* renamed from: e */
    final /* synthetic */ DkMessagesManager f5521e;
    /* renamed from: f */
    private DkMessagesInfo f5522f = null;

    al(DkMessagesManager dkMessagesManager, C0657i c0657i, com.duokan.reader.domain.account.al alVar, ArrayList arrayList, HashMap hashMap, C1140y c1140y) {
        this.f5521e = dkMessagesManager;
        this.f5517a = alVar;
        this.f5518b = arrayList;
        this.f5519c = hashMap;
        this.f5520d = c1140y;
        super(c0657i);
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.f5470a) {
            int i;
            aq aqVar = new aq(this.f5521e.f5474e, this.f5517a, this.f5521e.f5475f);
            aqVar.m8529a();
            this.f5522f = aqVar.m8530b();
            if (TextUtils.isEmpty(this.f5522f.mUnreadThreshold) || this.f5522f.mUnreadThreshold.compareTo(((C1151k) this.f5518b.get(0)).f5555b) < 0) {
                this.f5522f.mUnreadThreshold = ((C1151k) this.f5518b.get(0)).f5555b;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList(this.f5522f.mUnreadMessageIds.length + this.f5518b.size());
            for (Object obj : this.f5522f.mUnreadMessageIds) {
                hashSet.add(obj);
                arrayList.add(obj);
            }
            Iterator it = this.f5518b.iterator();
            while (it.hasNext()) {
                C1151k c1151k = (C1151k) it.next();
                if (!hashSet.contains(c1151k.f5555b)) {
                    arrayList.add(c1151k.f5555b);
                }
            }
            if (this.f5521e.f5475f <= 0 || this.f5521e.f5475f >= 1000) {
                i = 1000;
            } else {
                i = this.f5521e.f5475f;
            }
            if (arrayList.size() > i) {
                int size = arrayList.size() - i;
                for (i = 0; i < size; i++) {
                    arrayList.remove(i);
                }
            }
            this.f5522f.mUnreadMessageIds = (String[]) arrayList.toArray(new String[0]);
            aqVar.updateInfo(this.f5522f);
            ((ao) aqVar.getListCacheHelper()).m8527a(this.f5519c);
            aqVar.insertItems(this.f5518b);
            this.f5519c.clear();
            this.f5522f = aqVar.m8530b();
        }
    }

    protected void onSessionSucceeded() {
        if (this.f5517a.m3365a(this.f5521e.f5479j)) {
            this.f5521e.m8468a(this.f5522f.mUnreadMessageIds);
            this.f5521e.f5478i.mo1174a(this.f5521e, this.f5518b, this.f5520d);
            return;
        }
        this.f5520d.mo1519a(false);
    }

    protected void onSessionFailed() {
        this.f5520d.mo1519a(false);
    }

    protected void onSessionCancelled() {
        super.onSessionCancelled();
        this.f5520d.mo1519a(false);
    }
}
