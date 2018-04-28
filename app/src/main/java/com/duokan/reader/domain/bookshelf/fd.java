package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.domain.account.al;
import com.mipay.sdk.Mipay;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
public class fd extends ac {
    /* renamed from: a */
    private final al f3160a;

    public fd(WebSession webSession, al alVar) {
        super(webSession, alVar);
        this.f3160a = alVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public com.duokan.reader.common.webservices.C0621a<java.util.HashMap<java.lang.Integer, com.duokan.reader.domain.bookshelf.fm>> m4456a(java.util.List<com.duokan.reader.domain.bookshelf.fi> r13) {
        /*
        r12 = this;
        r8 = 0;
        r3 = new com.duokan.reader.common.webservices.a;
        r3.<init>();
        r3.b = r8;
        r0 = "";
        r3.c = r0;
        r4 = new java.util.HashMap;
        r4.<init>();
        r3.f2058a = r4;
        r5 = new java.util.HashMap;
        r5.<init>();
        r1 = r13.iterator();
    L_0x001c:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0065;
    L_0x0022:
        r0 = r1.next();
        r0 = (com.duokan.reader.domain.bookshelf.fi) r0;
        r2 = new com.duokan.reader.domain.bookshelf.fm;
        r2.<init>();
        r6 = r0.f3167a;
        r2.f3176a = r6;
        r6 = new java.util.ArrayList;
        r6.<init>();
        r2.f3177b = r6;
        r6 = 1;
        r2.f3178c = r6;
        r6 = -1;
        r2.f3179d = r6;
        r6 = r0.f3167a;
        r6 = java.lang.Integer.valueOf(r6);
        r4.put(r6, r2);
        r2 = new com.duokan.reader.domain.bookshelf.fh;
        r2.<init>();
        r6 = r0.f3167a;
        r2.f3163a = r6;
        r6 = r0.f3168b;
        r2.f3166d = r6;
        r2.f3164b = r8;
        r6 = 100;
        r2.f3165c = r6;
        r0 = r0.f3167a;
        r0 = java.lang.Integer.valueOf(r0);
        r5.put(r0, r2);
        goto L_0x001c;
    L_0x0065:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r6 = r13.iterator();
    L_0x006e:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0098;
    L_0x0074:
        r0 = r6.next();
        r0 = (com.duokan.reader.domain.bookshelf.fi) r0;
        r1 = r0.f3167a;
        r1 = java.lang.Integer.valueOf(r1);
        r1 = r4.get(r1);
        r1 = (com.duokan.reader.domain.bookshelf.fm) r1;
        r1 = r1.f3178c;
        if (r1 == 0) goto L_0x006e;
    L_0x008a:
        r0 = r0.f3167a;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r5.get(r0);
        r2.add(r0);
        goto L_0x006e;
    L_0x0098:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x009f;
    L_0x009e:
        return r3;
    L_0x009f:
        r6 = r12.m4458b(r2);
        r0 = r6.b;
        if (r0 != 0) goto L_0x00f8;
    L_0x00a7:
        r0 = r6.f2058a;
        r0 = (java.util.HashMap) r0;
        r0 = r0.keySet();
        r7 = r0.iterator();
    L_0x00b3:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0065;
    L_0x00b9:
        r0 = r7.next();
        r0 = (java.lang.Integer) r0;
        r1 = r6.f2058a;
        r1 = (java.util.HashMap) r1;
        r1 = r1.get(r0);
        r1 = (com.duokan.reader.domain.bookshelf.fm) r1;
        r2 = r4.get(r0);
        r2 = (com.duokan.reader.domain.bookshelf.fm) r2;
        r8 = r1.f3178c;
        r2.f3178c = r8;
        r8 = r2.f3179d;
        r10 = 0;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 >= 0) goto L_0x00df;
    L_0x00db:
        r8 = r1.f3179d;
        r2.f3179d = r8;
    L_0x00df:
        r2 = r2.f3177b;
        r8 = r1.f3177b;
        r2.addAll(r8);
        r0 = r5.get(r0);
        r0 = (com.duokan.reader.domain.bookshelf.fh) r0;
        r2 = r0.f3164b;
        r1 = r1.f3177b;
        r1 = r1.size();
        r1 = r1 + r2;
        r0.f3164b = r1;
        goto L_0x00b3;
    L_0x00f8:
        r0 = r6.b;
        r3.b = r0;
        r0 = r6.c;
        r3.c = r0;
        r0 = r3.f2058a;
        r0 = (java.util.HashMap) r0;
        r0.destroyAnimation();
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.fd.a(java.util.List):com.duokan.reader.common.webservices.a<java.util.HashMap<java.lang.Integer, com.duokan.reader.domain.bookshelf.fm>>");
    }

    /* renamed from: b */
    public C0621a<HashMap<Integer, fm>> m4458b(List<fh> list) {
        JSONObject jSONObject = new JSONObject();
        for (fh fhVar : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(String.valueOf(fhVar.f3163a), jSONObject2);
            jSONObject2.put("offset", String.valueOf(fhVar.f3164b));
            jSONObject2.put("count", String.valueOf(fhVar.f3165c));
            jSONObject2.put("t", String.valueOf(fhVar.f3166d));
        }
        JSONObject a = m547a(mo376a(m562b(true, m4448a() + "/shelf", "data", URLEncoder.encode(jSONObject.toString()))));
        C0621a<HashMap<Integer, fm>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_CODE);
        c0621a.c = a.optString(Mipay.KEY_MESSAGE);
        if (c0621a.b == 0) {
            c0621a.f2058a = new HashMap();
            jSONObject2 = a.getJSONObject("data");
            for (fh fhVar2 : list) {
                jSONObject = jSONObject2.optJSONObject(String.valueOf(fhVar2.f3163a));
                if (jSONObject != null) {
                    fm fmVar = new fm();
                    fmVar.f3176a = fhVar2.f3163a;
                    fmVar.f3178c = jSONObject.optBoolean("more");
                    fmVar.f3179d = jSONObject.optLong(ClientCookie.VERSION_ATTR);
                    JSONArray optJSONArray = jSONObject.optJSONArray("books");
                    if (optJSONArray != null) {
                        fmVar.f3177b = bt.m4066a(fmVar.f3176a, optJSONArray);
                    } else {
                        fmVar.f3177b = new ArrayList();
                    }
                    ((HashMap) c0621a.f2058a).put(Integer.valueOf(fhVar2.f3163a), fmVar);
                }
            }
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<HashMap<Integer, fn>> m4455a(Collection<fj> collection) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base", m4450c((Collection) collection));
        JSONObject d = m4451d(collection);
        if (d.length() > 0) {
            jSONObject.put("delete_from_shelf", d);
        }
        d = m4452e(collection);
        if (d.length() > 0) {
            jSONObject.put("update_group", d);
        }
        jSONObject = m547a(mo376a(m555a(true, m4448a() + "/shelf", "data", jSONObject.toString())));
        C0621a<HashMap<Integer, fn>> c0621a = new C0621a();
        c0621a.b = jSONObject.getInt(Mipay.KEY_CODE);
        c0621a.c = jSONObject.optString(Mipay.KEY_MESSAGE);
        if (c0621a.b == 0) {
            c0621a.f2058a = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            for (fj fjVar : collection) {
                d = jSONObject2.optJSONObject(String.valueOf(fjVar.f3169a));
                if (d != null) {
                    fn fnVar = new fn();
                    fnVar.f3180a = fjVar.f3169a;
                    fnVar.f3181b = d.optLong(ClientCookie.VERSION_ATTR);
                    fnVar.f3182c = d.optLong("server_change_time");
                    ((HashMap) c0621a.f2058a).put(Integer.valueOf(fjVar.f3169a), fnVar);
                }
            }
        }
        return c0621a;
    }

    /* renamed from: c */
    private JSONObject m4450c(Collection<fj> collection) {
        JSONObject jSONObject = new JSONObject();
        for (fj fjVar : collection) {
            jSONObject.put(String.valueOf(fjVar.f3169a), String.valueOf(fjVar.f3170b));
        }
        return jSONObject;
    }

    /* renamed from: d */
    private JSONObject m4451d(Collection<fj> collection) {
        return m4449a(collection, new fe(this));
    }

    /* renamed from: e */
    private JSONObject m4452e(Collection<fj> collection) {
        return m4449a(collection, new ff(this));
    }

    /* renamed from: a */
    private JSONObject m4449a(Collection<fj> collection, fg fgVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (fj fjVar : collection) {
            JSONArray jSONArray = new JSONArray();
            for (bt a : fjVar.f3171c) {
                JSONObject a2 = fgVar.mo1025a(a);
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            if (jSONArray.length() > 0) {
                hashMap.put(Integer.valueOf(fjVar.f3169a), jSONArray);
            }
        }
        for (Integer intValue : hashMap.keySet()) {
            int intValue2 = intValue.intValue();
            jSONObject.put(String.valueOf(intValue2), hashMap.get(Integer.valueOf(intValue2)));
        }
        return jSONObject;
    }

    /* renamed from: c */
    public C0621a<HashMap<Integer, fo>> m4459c(List<fk> list) {
        JSONObject jSONObject = new JSONObject();
        for (fk fkVar : list) {
            jSONObject.put(String.valueOf(fkVar.f3172a), String.valueOf(fkVar.f3173b));
        }
        JSONObject a = m547a(mo376a(m562b(true, m4448a() + "/history", "data", URLEncoder.encode(jSONObject.toString()))));
        C0621a<HashMap<Integer, fo>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_CODE);
        c0621a.c = a.optString(Mipay.KEY_MESSAGE);
        if (c0621a.b == 0) {
            c0621a.f2058a = new HashMap();
            JSONObject jSONObject2 = a.getJSONObject("data");
            for (fk fkVar2 : list) {
                JSONArray optJSONArray = jSONObject2.optJSONArray(String.valueOf(fkVar2.f3172a));
                if (optJSONArray != null) {
                    fo foVar = new fo();
                    foVar.f3183a = fkVar2.f3172a;
                    foVar.f3184b = dd.m4303a(foVar.f3183a, optJSONArray);
                    ((HashMap) c0621a.f2058a).put(Integer.valueOf(fkVar2.f3172a), foVar);
                }
            }
        }
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<Void> m4457b(Collection<fl> collection) {
        JSONObject jSONObject = new JSONObject();
        JSONObject f = m4453f(collection);
        if (f.length() > 0) {
            jSONObject.put("added", f);
        }
        f = m4454g(collection);
        if (f.length() > 0) {
            jSONObject.put("deleted", f);
        }
        jSONObject = m547a(mo376a(m555a(true, m4448a() + "/history", "data", jSONObject.toString())));
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = jSONObject.getInt(Mipay.KEY_CODE);
        c0621a.c = jSONObject.optString(Mipay.KEY_MESSAGE);
        return c0621a;
    }

    /* renamed from: f */
    private JSONObject m4453f(Collection<fl> collection) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (fl flVar : collection) {
            JSONArray jSONArray = new JSONArray();
            for (dd ddVar : flVar.f3175b) {
                Object obj;
                if (ddVar.f3007f == 1) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("book_id", ddVar.f3003b);
                    jSONObject2.put("client_read_time", String.valueOf(ddVar.f3004c));
                    obj = jSONObject2;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    jSONArray.put(obj);
                }
            }
            if (jSONArray.length() > 0) {
                hashMap.put(Integer.valueOf(flVar.f3174a), jSONArray);
            }
        }
        for (Integer intValue : hashMap.keySet()) {
            int intValue2 = intValue.intValue();
            jSONObject.put(String.valueOf(intValue2), hashMap.get(Integer.valueOf(intValue2)));
        }
        return jSONObject;
    }

    /* renamed from: g */
    private JSONObject m4454g(Collection<fl> collection) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (fl flVar : collection) {
            JSONArray jSONArray = new JSONArray();
            for (dd ddVar : flVar.f3175b) {
                if (ddVar.f3007f == 2) {
                    jSONArray.put(ddVar.f3003b);
                }
            }
            if (jSONArray.length() > 0) {
                hashMap.put(Integer.valueOf(flVar.f3174a), jSONArray);
            }
        }
        for (Integer intValue : hashMap.keySet()) {
            int intValue2 = intValue.intValue();
            jSONObject.put(String.valueOf(intValue2), hashMap.get(Integer.valueOf(intValue2)));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private String m4448a() {
        return C0641o.m2934i().m2988o();
    }
}
