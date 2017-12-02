package com.duokan.reader.domain.social.message;

import android.text.TextUtils;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import miuipub.date.Calendar;

class aq extends j {
    final /* synthetic */ ab a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ aa d;
    final /* synthetic */ DkMessagesManager e;
    private DkMessagesInfo f = null;

    aq(DkMessagesManager dkMessagesManager, ab abVar, ArrayList arrayList, HashMap hashMap, aa aaVar) {
        this.e = dkMessagesManager;
        this.a = abVar;
        this.b = arrayList;
        this.c = hashMap;
        this.d = aaVar;
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.a) {
            av avVar = new av(this.e.e, this.a, this.e.f);
            avVar.a();
            this.f = avVar.b();
            if (TextUtils.isEmpty(this.f.mUnreadThreshold) || this.f.mUnreadThreshold.compareTo(((k) this.b.get(0)).b) < 0) {
                this.f.mUnreadThreshold = ((k) this.b.get(0)).b;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList(this.f.mUnreadMessageIds.length + this.b.size());
            for (Object obj : this.f.mUnreadMessageIds) {
                hashSet.add(obj);
                arrayList.add(obj);
            }
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (!hashSet.contains(kVar.b)) {
                    arrayList.add(kVar.b);
                }
            }
            int f = (this.e.f <= 0 || this.e.f >= Calendar.MILLISECOND_OF_SECOND) ? Calendar.MILLISECOND_OF_SECOND : this.e.f;
            if (arrayList.size() > f) {
                int size = arrayList.size() - f;
                for (f = 0; f < size; f++) {
                    arrayList.remove(f);
                }
            }
            this.f.mUnreadMessageIds = (String[]) arrayList.toArray(new String[0]);
            avVar.updateInfo(this.f);
            ((at) avVar.getListCacheHelper()).a(this.c);
            avVar.insertItems(this.b);
            this.c.clear();
            this.f = avVar.b();
        }
    }

    protected void onSessionSucceeded() {
        if (this.e.k.a(this.a)) {
            this.e.a(this.f.mUnreadMessageIds);
            this.e.j.a(this.e, this.b, this.d);
            return;
        }
        this.d.a(false);
    }

    protected void onSessionFailed() {
        this.d.a(false);
    }

    protected void onSessionCancelled() {
        super.onSessionCancelled();
        this.d.a(false);
    }
}
