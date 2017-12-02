package com.duokan.reader.domain.social.message;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.ab;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class t extends n {
    final /* synthetic */ ab a;
    final /* synthetic */ s b;
    private long c = this.b.c.d;
    private int d = 0;
    private String e = "";
    private boolean f = true;
    private int g = 0;
    private ArrayList h = new ArrayList();
    private HashMap i = new HashMap();

    t(s sVar, ab abVar) {
        this.b = sVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        m mVar = new m((n) this, this.a);
        b a = mVar.a(this.b.c.c, this.b.c.g);
        if (a.b != 0) {
            this.g = a.b;
            return;
        }
        this.d = ((JSONObject) a.a).getInt("count");
        this.e = ((JSONObject) a.a).getString("deletion_threshold");
        this.c = ((JSONObject) a.a).getLong("interval") * 1000;
        if (this.d == 0 || this.b.c.g.compareTo(this.e) >= 0) {
            this.f = false;
            return;
        }
        JSONObject jSONObject = ((JSONObject) a.a).getJSONObject("detailed_count");
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (int i2 : this.b.c.c) {
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
        b a2 = mVar.a(0, i, iArr);
        if (a2.b != 0) {
            this.g = a2.b;
            return;
        }
        this.h = new ArrayList(((JSONArray) a2.a).length());
        this.i = new HashMap();
        for (i = 0; i < ((JSONArray) a2.a).length(); i++) {
            try {
                k a3 = ac.a(((JSONArray) a2.a).getJSONObject(i));
                if (a3 != null) {
                    this.h.add(a3);
                    this.i.put(a3.b, ((JSONArray) a2.a).getJSONObject(i));
                }
            } catch (JSONException e) {
            }
        }
        this.f = false;
    }

    protected void onSessionSucceeded() {
        boolean z = true;
        this.b.c.d = this.c;
        if (!this.b.c.f.a(this.a)) {
            this.b.a.a(false, false);
        } else if (this.f) {
            if (this.g != 1001 && this.g != 1002 && this.g != 1003) {
                ab abVar = this.b.a;
                if (this.g != 1004) {
                    z = false;
                }
                abVar.a(false, z);
            } else if (this.b.b) {
                i.f().a(this.b.c.f.a, new v(this));
            } else {
                this.b.a.a(false, false);
            }
        } else if (this.h.size() > 0) {
            this.b.c.e.a(this.h, this.i, new u(this));
        } else {
            this.b.a.a(true, false);
            this.b.c.g = this.e;
            ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.a.c, this.b.c.g);
        }
    }

    protected void onSessionFailed() {
        this.b.a.a(false, false);
    }

    protected void onSessionCancelled() {
        super.onSessionCancelled();
        this.b.a.a(false, false);
    }
}
