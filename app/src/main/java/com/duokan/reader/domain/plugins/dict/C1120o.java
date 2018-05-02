package com.duokan.reader.domain.plugins.dict;

import android.text.TextUtils;
import com.duokan.core.sys.UThread;
import com.duokan.p023b.C0247i;
import com.iflytek.speech.VoiceWakeuperAidl;
import com.kingsoft.iciba.sdk2.interfaces.IKSCibaQueryResult;
import com.mipay.sdk.Mipay;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.plugins.dict.o */
class C1120o implements IKSCibaQueryResult {
    /* renamed from: a */
    final /* synthetic */ C1115j f5416a;
    /* renamed from: b */
    private final C1123r f5417b;

    public C1120o(C1115j c1115j, C1123r c1123r) {
        this.f5416a = c1115j;
        this.f5417b = c1123r;
    }

    public void searchResult(String str) {
        boolean z = false;
        C1124s c1124s = new C1124s();
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            c1124s.f5424b = jSONObject.getJSONObject(Mipay.KEY_MESSAGE).getString("word_name");
            JSONObject jSONObject2 = jSONObject.getJSONObject(Mipay.KEY_MESSAGE);
            JSONObject optJSONObject = jSONObject2.optJSONObject("baseInfo");
            if (optJSONObject != null) {
                c1124s.f5425c = new C1125t();
                c1124s.f5425c.f5427a = optJSONObject.optInt("translate_type");
                c1124s.f5425c.f5428b = optJSONObject.optString("translate_result");
                c1124s.f5425c.f5429c = optJSONObject.optString("translate_msg");
                JSONArray optJSONArray = optJSONObject.optJSONArray("symbols");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (i = 0; i < optJSONArray.length(); i++) {
                        c1124s.f5425c.f5430d.add(m8424a(optJSONArray.getJSONObject(i)));
                    }
                }
                jSONObject = optJSONObject.optJSONObject("exchange");
                if (jSONObject != null) {
                    if (c1124s.f5425c == null) {
                        c1124s.f5425c = new C1125t();
                    }
                    c1124s.f5425c.f5431e = this.f5416a.m8416a(jSONObject);
                }
            }
            jSONObject2 = jSONObject2.optJSONObject("cc_mean");
            if (jSONObject2 != null) {
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("spells");
                c1124s.f5426d = new C1126u();
                if (optJSONArray2 != null) {
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        c1124s.f5426d.f5432a.add(m8425b(optJSONArray2.getJSONObject(i)));
                    }
                }
                Object optString = jSONObject2.optString("structure");
                if (!TextUtils.isEmpty(optString)) {
                    c1124s.f5426d.f5433b = optString;
                }
                optString = jSONObject2.optString("radical");
                if (!TextUtils.isEmpty(optString)) {
                    c1124s.f5426d.f5434c = optString;
                }
                optString = jSONObject2.optString("strokes");
                if (!TextUtils.isEmpty(optString)) {
                    c1124s.f5426d.f5435d = optString;
                }
                optString = jSONObject2.optString("wubi");
                if (!TextUtils.isEmpty(optString)) {
                    c1124s.f5426d.f5436e = optString;
                }
            }
            if (!(c1124s.f5425c == null && c1124s.f5426d == null)) {
                z = true;
            }
            c1124s.f5423a = z;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        UThread.runOnThread(new C1121p(this, c1124s));
    }

    /* renamed from: a */
    private C1129x m8424a(JSONObject jSONObject) {
        C1129x c1129x = new C1129x();
        StringBuffer stringBuffer = new StringBuffer();
        Object optString = jSONObject.optString("ph_am");
        CharSequence optString2 = jSONObject.optString("ph_en");
        Object optString3 = jSONObject.optString("word_symbol");
        if (TextUtils.isEmpty(optString3)) {
            if (!TextUtils.isEmpty(optString)) {
                stringBuffer.append(this.f5416a.f5409e.getString(C0247i.plugins__dict__dj)).append("[").append(optString2).append("]");
            }
            if (!TextUtils.isEmpty(optString2)) {
                stringBuffer.append(this.f5416a.f5409e.getString(C0247i.plugins__dict__kk)).append("[").append(optString).append("]");
            }
            c1129x.f5440a = stringBuffer.toString();
        } else {
            c1129x.f5440a = stringBuffer.append("[").append(optString3).append("]").toString();
        }
        JSONArray jSONArray = jSONObject.getJSONArray("parts");
        for (int i = 0; i < jSONArray.length(); i++) {
            C1127v c1127v = new C1127v();
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            c1127v.f5438b = jSONObject2.getString("part");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("means");
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                stringBuffer2.append(jSONArray2.getString(i2)).append("；");
            }
            c1127v.f5437a = stringBuffer2.toString();
            c1129x.f5441b.add(c1127v);
        }
        return c1129x;
    }

    /* renamed from: b */
    private C1128w m8425b(JSONObject jSONObject) {
        int i = 0;
        C1128w c1128w = new C1128w();
        try {
            c1128w.b = "[" + jSONObject.optString("spell") + "]";
            JSONArray optJSONArray = jSONObject.optJSONArray("means");
            if (optJSONArray != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    stringBuilder.append(optJSONArray.getString(i2)).append("\n");
                }
                c1128w.a = stringBuilder.toString();
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("words");
            if (optJSONArray2 != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                while (i < optJSONArray2.length()) {
                    stringBuilder2.append(optJSONArray2.getString(i)).append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                    i++;
                }
                c1128w.f5439c = stringBuilder2.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c1128w;
    }
}
