package com.duokan.reader.domain.social.message;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.r */
class C1156r extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f5573a;
    /* renamed from: b */
    final /* synthetic */ C1155q f5574b;
    /* renamed from: c */
    private long f5575c = this.f5574b.f5572b.f5566d;
    /* renamed from: d */
    private int f5576d = 0;
    /* renamed from: e */
    private String f5577e = "";
    /* renamed from: f */
    private boolean f5578f = true;
    /* renamed from: g */
    private int f5579g = 0;
    /* renamed from: h */
    private ArrayList<C1151k> f5580h = new ArrayList();
    /* renamed from: i */
    private HashMap<String, JSONObject> f5581i = new HashMap();

    C1156r(C1155q c1155q, String str, C0657i c0657i, al alVar) {
        this.f5574b = c1155q;
        this.f5573a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        C0639m c0639m = new C0639m((WebSession) this, this.f5573a);
        C0621a a = c0639m.m2904a(this.f5574b.f5572b.f5565c, this.f5574b.f5572b.f5569g);
        if (a.b != 0) {
            this.f5579g = a.b;
            return;
        }
        this.f5576d = ((JSONObject) a.f2058a).getInt("count");
        this.f5577e = ((JSONObject) a.f2058a).getString("deletion_threshold");
        this.f5575c = ((JSONObject) a.f2058a).getLong("interval") * 1000;
        if (this.f5576d == 0 || this.f5574b.f5572b.f5569g.compareTo(this.f5577e) >= 0) {
            this.f5578f = false;
            return;
        }
        JSONObject jSONObject = ((JSONObject) a.f2058a).getJSONObject("detailed_count");
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (int i2 : this.f5574b.f5572b.f5565c) {
            int i3;
            if (jSONObject.has(String.valueOf(i2))) {
                i3 = jSONObject.getInt(String.valueOf(i2));
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                i += i3;
                linkedList.add(Integer.valueOf(i2));
            }
        }
        int[] iArr = new int[linkedList.size()];
        for (i3 = 0; i3 < linkedList.size(); i3++) {
            iArr[i3] = ((Integer) linkedList.get(i3)).intValue();
        }
        C0621a a2 = c0639m.m2899a(0, i, iArr);
        if (a2.b != 0) {
            this.f5579g = a2.b;
            return;
        }
        this.f5580h = new ArrayList(((JSONArray) a2.f2058a).length());
        this.f5581i = new HashMap();
        for (i = 0; i < ((JSONArray) a2.f2058a).length(); i++) {
            try {
                C1151k a3 = aa.m8503a(((JSONArray) a2.f2058a).getJSONObject(i));
                if (a3 != null) {
                    this.f5580h.add(a3);
                    this.f5581i.put(a3.f5555b, ((JSONArray) a2.f2058a).getJSONObject(i));
                }
            } catch (JSONException e) {
            }
        }
        this.f5578f = false;
    }

    /* renamed from: b */
    public void mo827b() {
        boolean z = true;
        this.f5574b.f5572b.f5566d = this.f5575c;
        if (!this.f5574b.f5572b.f5568f.m3365a(this.f5573a)) {
            this.f5574b.f5571a.mo1521a(false, false);
        } else if (this.f5578f) {
            C1158z c1158z = this.f5574b.f5571a;
            if (this.f5579g != ICallback.THIRD_PART_LOGIN) {
                z = false;
            }
            c1158z.mo1521a(false, z);
        } else if (this.f5580h.size() > 0) {
            this.f5574b.f5572b.f5567e.mo1513a(this.f5580h, this.f5581i, new C1157s(this));
        } else {
            this.f5574b.f5571a.mo1521a(true, false);
            this.f5574b.f5572b.f5569g = this.f5577e;
            ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.f5573a.f2362c, this.f5574b.f5572b.f5569g);
        }
    }

    protected void onSessionCancelled() {
        super.onSessionCancelled();
        this.f5574b.f5571a.mo1521a(false, false);
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f5574b.f5571a.mo1521a(false, false);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f5579g == 1001 || this.f5579g == ICallback.LOGIN_OAUTH_AIDL || this.f5579g == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
