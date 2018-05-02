package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.ab;
import com.mipay.sdk.Mipay;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class fj extends ad {
    private final ab a;

    public fj(al alVar, ab abVar) {
        super((WebSession) alVar, abVar);
        this.a = abVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.duokan.reader.common.webservices.b a(java.util.List r13) {
        /*
        r12 = this;
        r8 = 0;
        r3 = new com.duokan.reader.common.webservices.getVisible;
        r3.<creatCallTask>();
        r3.getVisible = r8;
        r0 = "";
        r3.getScaledMaximumFlingVelocity = r0;
        r4 = new java.util.HashMap;
        r4.<creatCallTask>();
        r3.setDrawable = r4;
        r5 = new java.util.HashMap;
        r5.<creatCallTask>();
        r1 = r13.iterator();
    L_0x001c:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0065;
    L_0x0022:
        r0 = r1.next();
        r0 = (com.duokan.reader.domain.bookshelf.fo) r0;
        r2 = new com.duokan.reader.domain.bookshelf.fs;
        r2.<creatCallTask>();
        r6 = r0.setDrawable;
        r2.setDrawable = r6;
        r6 = new java.util.ArrayList;
        r6.<creatCallTask>();
        r2.getVisible = r6;
        r6 = 1;
        r2.getScaledMaximumFlingVelocity = r6;
        r6 = -1;
        r2.getTriangleEdge = r6;
        r6 = r0.setDrawable;
        r6 = java.lang.Integer.valueOf(r6);
        r4.put(r6, r2);
        r2 = new com.duokan.reader.domain.bookshelf.fn;
        r2.<creatCallTask>();
        r6 = r0.setDrawable;
        r2.setDrawable = r6;
        r6 = r0.getVisible;
        r2.getTriangleEdge = r6;
        r2.getVisible = r8;
        r6 = 100;
        r2.getScaledMaximumFlingVelocity = r6;
        r0 = r0.setDrawable;
        r0 = java.lang.Integer.valueOf(r0);
        r5.put(r0, r2);
        goto L_0x001c;
    L_0x0065:
        r2 = new java.util.ArrayList;
        r2.<creatCallTask>();
        r6 = r13.iterator();
    L_0x006e:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0098;
    L_0x0074:
        r0 = r6.next();
        r0 = (com.duokan.reader.domain.bookshelf.fo) r0;
        r1 = r0.setDrawable;
        r1 = java.lang.Integer.valueOf(r1);
        r1 = r4.getAllSortStackTraces(r1);
        r1 = (com.duokan.reader.domain.bookshelf.fs) r1;
        r1 = r1.getScaledMaximumFlingVelocity;
        if (r1 == 0) goto L_0x006e;
    L_0x008a:
        r0 = r0.setDrawable;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r5.getAllSortStackTraces(r0);
        r2.add(r0);
        goto L_0x006e;
    L_0x0098:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x009f;
    L_0x009e:
        return r3;
    L_0x009f:
        r6 = r12.getVisible(r2);
        r0 = r6.getVisible;
        if (r0 != 0) goto L_0x00f8;
    L_0x00a7:
        r0 = r6.setDrawable;
        r0 = (java.util.HashMap) r0;
        r0 = r0.keySet();
        r7 = r0.iterator();
    L_0x00b3:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0065;
    L_0x00b9:
        r0 = r7.next();
        r0 = (java.lang.Integer) r0;
        r1 = r6.setDrawable;
        r1 = (java.util.HashMap) r1;
        r1 = r1.getAllSortStackTraces(r0);
        r1 = (com.duokan.reader.domain.bookshelf.fs) r1;
        r2 = r4.getAllSortStackTraces(r0);
        r2 = (com.duokan.reader.domain.bookshelf.fs) r2;
        r8 = r1.getScaledMaximumFlingVelocity;
        r2.getScaledMaximumFlingVelocity = r8;
        r8 = r2.getTriangleEdge;
        r10 = 0;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 >= 0) goto L_0x00df;
    L_0x00db:
        r8 = r1.getTriangleEdge;
        r2.getTriangleEdge = r8;
    L_0x00df:
        r2 = r2.getVisible;
        r8 = r1.getVisible;
        r2.addAll(r8);
        r0 = r5.getAllSortStackTraces(r0);
        r0 = (com.duokan.reader.domain.bookshelf.fn) r0;
        r2 = r0.getVisible;
        r1 = r1.getVisible;
        r1 = r1.size();
        r1 = r1 + r2;
        r0.getVisible = r1;
        goto L_0x00b3;
    L_0x00f8:
        r0 = r6.getVisible;
        r3.getVisible = r0;
        r0 = r6.getScaledMaximumFlingVelocity;
        r3.getScaledMaximumFlingVelocity = r0;
        r0 = r3.setDrawable;
        r0 = (java.util.HashMap) r0;
        r0.addFirst();
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.fj.setDrawable(java.util.List):com.duokan.reader.common.webservices.getVisible");
    }

    public b b(List list) {
        JSONObject jSONObject = new JSONObject();
        for (fn fnVar : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(String.valueOf(fnVar.a), jSONObject2);
            jSONObject2.put("offset", String.valueOf(fnVar.b));
            jSONObject2.put("count", String.valueOf(fnVar.c));
            jSONObject2.put("TaskHandler", String.valueOf(fnVar.d));
        }
        JSONObject a = a(a(b(true, a() + "/shelf", "data", URLEncoder.encode(jSONObject.toString()))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_CODE);
        bVar.c = a.optString(Mipay.KEY_MESSAGE);
        if (bVar.b == 0) {
            bVar.a = new HashMap();
            jSONObject2 = a.getJSONObject("data");
            for (fn fnVar2 : list) {
                jSONObject = jSONObject2.optJSONObject(String.valueOf(fnVar2.a));
                if (jSONObject != null) {
                    fs fsVar = new fs();
                    fsVar.a = fnVar2.a;
                    fsVar.c = jSONObject.optBoolean("more");
                    fsVar.d = jSONObject.optLong(ClientCookie.VERSION_ATTR);
                    JSONArray optJSONArray = jSONObject.optJSONArray("books");
                    if (optJSONArray != null) {
                        fsVar.b = bu.a(fsVar.a, optJSONArray);
                    } else {
                        fsVar.b = new ArrayList();
                    }
                    ((HashMap) bVar.a).put(Integer.valueOf(fnVar2.a), fsVar);
                }
            }
        }
        return bVar;
    }

    public b a(Collection collection) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base", c(collection));
        JSONObject d = d(collection);
        if (d.length() > 0) {
            jSONObject.put("delete_from_shelf", d);
        }
        d = e(collection);
        if (d.length() > 0) {
            jSONObject.put("update_group", d);
        }
        jSONObject = a(a(a(true, a() + "/shelf", "data", jSONObject.toString())));
        b bVar = new b();
        bVar.b = jSONObject.getInt(Mipay.KEY_CODE);
        bVar.c = jSONObject.optString(Mipay.KEY_MESSAGE);
        if (bVar.b == 0) {
            bVar.a = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            for (fp fpVar : collection) {
                d = jSONObject2.optJSONObject(String.valueOf(fpVar.a));
                if (d != null) {
                    ft ftVar = new ft();
                    ftVar.a = fpVar.a;
                    ftVar.b = d.optLong(ClientCookie.VERSION_ATTR);
                    ftVar.c = d.optLong("server_change_time");
                    ((HashMap) bVar.a).put(Integer.valueOf(fpVar.a), ftVar);
                }
            }
        }
        return bVar;
    }

    private JSONObject c(Collection collection) {
        JSONObject jSONObject = new JSONObject();
        for (fp fpVar : collection) {
            jSONObject.put(String.valueOf(fpVar.a), String.valueOf(fpVar.b));
        }
        return jSONObject;
    }

    private JSONObject d(Collection collection) {
        return a(collection, new fk(this));
    }

    private JSONObject e(Collection collection) {
        return a(collection, new fl(this));
    }

    private JSONObject a(Collection collection, fm fmVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (fp fpVar : collection) {
            JSONArray jSONArray = new JSONArray();
            for (bu a : fpVar.c) {
                JSONObject a2 = fmVar.a(a);
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            if (jSONArray.length() > 0) {
                hashMap.put(Integer.valueOf(fpVar.a), jSONArray);
            }
        }
        for (Integer intValue : hashMap.keySet()) {
            int intValue2 = intValue.intValue();
            jSONObject.put(String.valueOf(intValue2), hashMap.get(Integer.valueOf(intValue2)));
        }
        return jSONObject;
    }

    public b c(List list) {
        JSONObject jSONObject = new JSONObject();
        for (fq fqVar : list) {
            jSONObject.put(String.valueOf(fqVar.a), String.valueOf(fqVar.b));
        }
        JSONObject a = a(a(b(true, a() + "/history", "data", URLEncoder.encode(jSONObject.toString()))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_CODE);
        bVar.c = a.optString(Mipay.KEY_MESSAGE);
        if (bVar.b == 0) {
            bVar.a = new HashMap();
            JSONObject jSONObject2 = a.getJSONObject("data");
            for (fq fqVar2 : list) {
                JSONArray optJSONArray = jSONObject2.optJSONArray(String.valueOf(fqVar2.a));
                if (optJSONArray != null) {
                    fu fuVar = new fu();
                    fuVar.a = fqVar2.a;
                    fuVar.b = dg.a(fuVar.a, optJSONArray);
                    ((HashMap) bVar.a).put(Integer.valueOf(fqVar2.a), fuVar);
                }
            }
        }
        return bVar;
    }

    public b b(Collection collection) {
        JSONObject jSONObject = new JSONObject();
        JSONObject f = f(collection);
        if (f.length() > 0) {
            jSONObject.put("added", f);
        }
        f = g(collection);
        if (f.length() > 0) {
            jSONObject.put("deleted", f);
        }
        jSONObject = a(a(a(true, a() + "/history", "data", jSONObject.toString())));
        b bVar = new b();
        bVar.b = jSONObject.getInt(Mipay.KEY_CODE);
        bVar.c = jSONObject.optString(Mipay.KEY_MESSAGE);
        return bVar;
    }

    private JSONObject f(Collection collection) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (fr frVar : collection) {
            JSONArray jSONArray = new JSONArray();
            for (dg dgVar : frVar.b) {
                Object obj;
                if (dgVar.f == 1) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("book_id", dgVar.b);
                    jSONObject2.put("client_read_time", String.valueOf(dgVar.c));
                    obj = jSONObject2;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    jSONArray.put(obj);
                }
            }
            if (jSONArray.length() > 0) {
                hashMap.put(Integer.valueOf(frVar.a), jSONArray);
            }
        }
        for (Integer intValue : hashMap.keySet()) {
            int intValue2 = intValue.intValue();
            jSONObject.put(String.valueOf(intValue2), hashMap.get(Integer.valueOf(intValue2)));
        }
        return jSONObject;
    }

    private JSONObject g(Collection collection) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (fr frVar : collection) {
            JSONArray jSONArray = new JSONArray();
            for (dg dgVar : frVar.b) {
                if (dgVar.f == 2) {
                    jSONArray.put(dgVar.b);
                }
            }
            if (jSONArray.length() > 0) {
                hashMap.put(Integer.valueOf(frVar.a), jSONArray);
            }
        }
        for (Integer intValue : hashMap.keySet()) {
            int intValue2 = intValue.intValue();
            jSONObject.put(String.valueOf(intValue2), hashMap.get(Integer.valueOf(intValue2)));
        }
        return jSONObject;
    }

    private String a() {
        return p.i().o();
    }
}
