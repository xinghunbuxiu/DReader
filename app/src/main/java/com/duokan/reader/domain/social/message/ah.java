package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import org.json.JSONArray;

class ah extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f5502a;
    /* renamed from: b */
    final /* synthetic */ ag f5503b;
    /* renamed from: c */
    private C0621a<JSONArray> f5504c = null;
    /* renamed from: d */
    private C0621a<Void> f5505d = null;
    /* renamed from: e */
    private C1151k[] f5506e = new C1151k[0];
    /* renamed from: f */
    private DkMessagesInfo f5507f = null;
    /* renamed from: g */
    private boolean f5508g = this.f5503b.f5501e.f5481l;
    /* renamed from: h */
    private boolean f5509h = this.f5503b.f5501e.f5482m;

    ah(ag agVar, String str, C0657i c0657i, al alVar) {
        this.f5503b = agVar;
        this.f5502a = alVar;
        super(str, c0657i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo825a() {
        /*
        r9 = this;
        r1 = 0;
        r2 = new com.duokan.reader.common.webservices.duokan.m;
        r0 = r9.f5502a;
        r2.<init>(r9, r0);
        r3 = com.duokan.reader.domain.social.message.DkMessagesManager.f5470a;
        monitor-enter(r3);
        r4 = new com.duokan.reader.domain.social.message.aq;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r0 = r0.f5501e;	 Catch:{ all -> 0x01fc }
        r0 = r0.f5474e;	 Catch:{ all -> 0x01fc }
        r5 = r9.f5502a;	 Catch:{ all -> 0x01fc }
        r6 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r6 = r6.f5501e;	 Catch:{ all -> 0x01fc }
        r6 = r6.f5475f;	 Catch:{ all -> 0x01fc }
        r4.<init>(r0, r5, r6);	 Catch:{ all -> 0x01fc }
        r4.m8529a();	 Catch:{ all -> 0x01fc }
        r0 = r4.m8530b();	 Catch:{ all -> 0x01fc }
        r9.f5507f = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r0 = r0.f5497a;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x0039;
    L_0x0033:
        r0 = 0;
        r9.f5508g = r0;	 Catch:{ all -> 0x01fc }
        r0 = 1;
        r9.f5509h = r0;	 Catch:{ all -> 0x01fc }
    L_0x0039:
        r0 = 0;
        r5 = 0;
        r6 = new com.duokan.reader.common.cache.t;	 Catch:{ all -> 0x01fc }
        r7 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r7 = r7.f5497a;	 Catch:{ all -> 0x01fc }
        r8 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r8 = r8.f5498b;	 Catch:{ all -> 0x01fc }
        r6.<init>(r7, r8);	 Catch:{ all -> 0x01fc }
        r0 = r4.queryItems(r0, r5, r6);	 Catch:{ all -> 0x01fc }
        r5 = r9.f5506e;	 Catch:{ all -> 0x01fc }
        r0 = r0.toArray(r5);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.C1151k[]) r0;	 Catch:{ all -> 0x01fc }
        r9.f5506e = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r0 = r0.mUnreadThreshold;	 Catch:{ all -> 0x01fc }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x00ab;
    L_0x0060:
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r0 = r0.mUnreadThreshold;	 Catch:{ all -> 0x01fc }
        r5 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r5 = r5.f5501e;	 Catch:{ all -> 0x01fc }
        r5 = r5.f5473d;	 Catch:{ all -> 0x01fc }
        r0 = r2.m2902a(r0, r5);	 Catch:{ all -> 0x01fc }
        r9.f5505d = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5505d;	 Catch:{ all -> 0x01fc }
        r0 = r0.b;	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x007a;
    L_0x0078:
        monitor-exit(r3);	 Catch:{ all -> 0x01fc }
    L_0x0079:
        return;
    L_0x007a:
        r0 = r4.m8530b();	 Catch:{ all -> 0x01fc }
        r9.f5507f = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r5 = 0;
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x01fc }
        r0.mUnreadMessageIds = r5;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r5 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r5 = r5.mUnreadThreshold;	 Catch:{ all -> 0x01fc }
        r0.mReadThreshold = r5;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r5 = "";
        r0.mUnreadThreshold = r5;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r4.updateInfo(r0);	 Catch:{ all -> 0x01fc }
        r0 = new android.os.Handler;	 Catch:{ all -> 0x01fc }
        r5 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x01fc }
        r0.<init>(r5);	 Catch:{ all -> 0x01fc }
        r5 = new com.duokan.reader.domain.social.message.ai;	 Catch:{ all -> 0x01fc }
        r5.<init>(r9);	 Catch:{ all -> 0x01fc }
        r0.post(r5);	 Catch:{ all -> 0x01fc }
    L_0x00ab:
        r0 = r9.f5508g;	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x00bc;
    L_0x00af:
        r0 = r9.f5506e;	 Catch:{ all -> 0x01fc }
        r0 = r0.length;	 Catch:{ all -> 0x01fc }
        r5 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r5 = r5.f5498b;	 Catch:{ all -> 0x01fc }
        if (r0 >= r5) goto L_0x01f9;
    L_0x00b8:
        r0 = r9.f5509h;	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x01f9;
    L_0x00bc:
        r0 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r0 = r0.f5497a;	 Catch:{ all -> 0x01fc }
        r5 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r5 = r5.f5498b;	 Catch:{ all -> 0x01fc }
        r6 = r9.f5503b;	 Catch:{ all -> 0x01fc }
        r6 = r6.f5501e;	 Catch:{ all -> 0x01fc }
        r6 = r6.f5473d;	 Catch:{ all -> 0x01fc }
        r0 = r2.m2899a(r0, r5, r6);	 Catch:{ all -> 0x01fc }
        r9.f5504c = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5504c;	 Catch:{ all -> 0x01fc }
        r0 = r0.b;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x01f9;
    L_0x00d8:
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5504c;	 Catch:{ all -> 0x01fc }
        r0 = r0.f2058a;	 Catch:{ all -> 0x01fc }
        r0 = (org.json.JSONArray) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.length();	 Catch:{ all -> 0x01fc }
        r5.<init>(r0);	 Catch:{ all -> 0x01fc }
        r6 = new java.util.HashMap;	 Catch:{ all -> 0x01fc }
        r6.<init>();	 Catch:{ all -> 0x01fc }
    L_0x00ec:
        r0 = r9.f5504c;	 Catch:{ all -> 0x01fc }
        r0 = r0.f2058a;	 Catch:{ all -> 0x01fc }
        r0 = (org.json.JSONArray) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.length();	 Catch:{ all -> 0x01fc }
        if (r1 >= r0) goto L_0x011e;
    L_0x00f8:
        r0 = r9.f5504c;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.f2058a;	 Catch:{ JSONException -> 0x0201 }
        r0 = (org.json.JSONArray) r0;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x0201 }
        r0 = com.duokan.reader.domain.social.message.aa.m8503a(r0);	 Catch:{ JSONException -> 0x0201 }
        if (r0 == 0) goto L_0x011a;
    L_0x0108:
        r5.add(r0);	 Catch:{ JSONException -> 0x0201 }
        r7 = r0.f5555b;	 Catch:{ JSONException -> 0x0201 }
        r0 = r9.f5504c;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.f2058a;	 Catch:{ JSONException -> 0x0201 }
        r0 = (org.json.JSONArray) r0;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x0201 }
        r6.put(r7, r0);	 Catch:{ JSONException -> 0x0201 }
    L_0x011a:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00ec;
    L_0x011e:
        r0 = new com.duokan.reader.domain.social.message.ap;	 Catch:{ all -> 0x01fc }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ all -> 0x01fc }
        java.util.Collections.sort(r5, r0);	 Catch:{ all -> 0x01fc }
        r0 = r9.f5504c;	 Catch:{ all -> 0x01fc }
        r0 = r0.c;	 Catch:{ all -> 0x01fc }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x01fc }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x01fc }
        r9.f5509h = r0;	 Catch:{ all -> 0x01fc }
        r0 = r4.m8530b();	 Catch:{ all -> 0x01fc }
        r9.f5507f = r0;	 Catch:{ all -> 0x01fc }
        r0 = r5.size();	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x0196;
    L_0x0141:
        r0 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r0 = r0.mReadThreshold;	 Catch:{ all -> 0x01fc }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x0196;
    L_0x014b:
        r0 = 0;
        r0 = r5.get(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.C1151k) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.f5555b;	 Catch:{ all -> 0x01fc }
        r1 = r9.f5507f;	 Catch:{ all -> 0x01fc }
        r1 = r1.mReadThreshold;	 Catch:{ all -> 0x01fc }
        r0 = r0.compareTo(r1);	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x0196;
    L_0x015e:
        r0 = 0;
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01ff }
        r0 = (com.duokan.reader.domain.social.message.C1151k) r0;	 Catch:{ Exception -> 0x01ff }
        r0 = r0.f5555b;	 Catch:{ Exception -> 0x01ff }
        r1 = r9.f5503b;	 Catch:{ Exception -> 0x01ff }
        r1 = r1.f5501e;	 Catch:{ Exception -> 0x01ff }
        r1 = r1.f5473d;	 Catch:{ Exception -> 0x01ff }
        r0 = r2.m2902a(r0, r1);	 Catch:{ Exception -> 0x01ff }
        r0 = r0.b;	 Catch:{ Exception -> 0x01ff }
        if (r0 != 0) goto L_0x0196;
    L_0x0177:
        r0 = r9.f5507f;	 Catch:{ Exception -> 0x01ff }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x01ff }
        r0.mUnreadMessageIds = r1;	 Catch:{ Exception -> 0x01ff }
        r1 = r9.f5507f;	 Catch:{ Exception -> 0x01ff }
        r0 = 0;
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x01ff }
        r0 = (com.duokan.reader.domain.social.message.C1151k) r0;	 Catch:{ Exception -> 0x01ff }
        r0 = r0.f5555b;	 Catch:{ Exception -> 0x01ff }
        r1.mReadThreshold = r0;	 Catch:{ Exception -> 0x01ff }
        r0 = r9.f5507f;	 Catch:{ Exception -> 0x01ff }
        r1 = "";
        r0.mUnreadThreshold = r1;	 Catch:{ Exception -> 0x01ff }
        r0 = r9.f5507f;	 Catch:{ Exception -> 0x01ff }
        r4.updateInfo(r0);	 Catch:{ Exception -> 0x01ff }
    L_0x0196:
        r0 = r5.size();	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x01d4;
    L_0x019c:
        r0 = r9.f5506e;	 Catch:{ all -> 0x01fc }
        r0 = r0.length;	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x01d4;
    L_0x01a1:
        r0 = r9.f5508g;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x01d4;
    L_0x01a5:
        r0 = 0;
        r0 = r5.get(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.C1151k) r0;	 Catch:{ all -> 0x01fc }
        r1 = r5.size();	 Catch:{ all -> 0x01fc }
        r1 = r1 + -1;
        r1 = r5.get(r1);	 Catch:{ all -> 0x01fc }
        r1 = (com.duokan.reader.domain.social.message.C1151k) r1;	 Catch:{ all -> 0x01fc }
        r2 = r9.f5506e;	 Catch:{ all -> 0x01fc }
        r7 = 0;
        r2 = r2[r7];	 Catch:{ all -> 0x01fc }
        r7 = r2.f5555b;	 Catch:{ all -> 0x01fc }
        r0 = r0.f5555b;	 Catch:{ all -> 0x01fc }
        r0 = r7.compareTo(r0);	 Catch:{ all -> 0x01fc }
        if (r0 > 0) goto L_0x01d1;
    L_0x01c7:
        r0 = r2.f5555b;	 Catch:{ all -> 0x01fc }
        r1 = r1.f5555b;	 Catch:{ all -> 0x01fc }
        r0 = r0.compareTo(r1);	 Catch:{ all -> 0x01fc }
        if (r0 < 0) goto L_0x01d4;
    L_0x01d1:
        r0 = 1;
        r9.f5508g = r0;	 Catch:{ all -> 0x01fc }
    L_0x01d4:
        r0 = r4.getListCacheHelper();	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.ao) r0;	 Catch:{ all -> 0x01fc }
        r0.m8527a(r6);	 Catch:{ all -> 0x01fc }
        r4.insertItems(r5);	 Catch:{ all -> 0x01fc }
        r6.destroyAnimation();	 Catch:{ all -> 0x01fc }
        r0 = r9.f5509h;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x01ea;
    L_0x01e7:
        r0 = 1;
        r9.f5508g = r0;	 Catch:{ all -> 0x01fc }
    L_0x01ea:
        r0 = 0;
        r0 = new com.duokan.reader.domain.social.message.C1151k[r0];	 Catch:{ all -> 0x01fc }
        r9.f5506e = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.f5506e;	 Catch:{ all -> 0x01fc }
        r0 = r5.toArray(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.C1151k[]) r0;	 Catch:{ all -> 0x01fc }
        r9.f5506e = r0;	 Catch:{ all -> 0x01fc }
    L_0x01f9:
        monitor-exit(r3);	 Catch:{ all -> 0x01fc }
        goto L_0x0079;
    L_0x01fc:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x01fc }
        throw r0;
    L_0x01ff:
        r0 = move-exception;
        goto L_0x0196;
    L_0x0201:
        r0 = move-exception;
        goto L_0x011a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.social.message.ah.a():void");
    }

    /* renamed from: b */
    public void mo827b() {
        int i = 0;
        if (this.f5502a.m3365a(this.f5503b.f5501e.f5479j)) {
            if (this.f5505d != null) {
                i = this.f5505d.b;
            }
            if (this.f5504c != null) {
                i = this.f5504c.b;
            }
            this.f5503b.f5501e.m8468a(this.f5507f.mUnreadMessageIds);
            if (i != 0) {
                this.f5503b.f5499c.mo1179a(this.f5506e, "");
                return;
            }
            this.f5503b.f5501e.f5481l = this.f5508g;
            this.f5503b.f5501e.f5482m = this.f5509h;
            this.f5503b.f5499c.mo1180a(this.f5506e, this.f5503b.f5501e.f5482m);
            return;
        }
        this.f5503b.f5499c.mo1179a(new C1151k[0], "");
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f5503b.f5501e.m8468a(this.f5507f.mUnreadMessageIds);
        this.f5503b.f5499c.mo1179a(this.f5506e, str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        int i;
        if (this.f5505d != null) {
            i = this.f5505d.b;
        } else {
            i = 0;
        }
        if (this.f5504c != null) {
            i = this.f5504c.b;
        }
        if ((i == 1001 || i == ICallback.LOGIN_OAUTH_AIDL || i == ICallback.CLEAR_ACCOUNT_AIDL) && this.f5503b.f5500d) {
            return true;
        }
        return false;
    }
}
