package com.duokan.reader.domain.plugins.dict;

import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.core.sys.TaskHandler;
import com.kingsoft.iciba.sdk2.interfaces.IKSCibaQueryResult;
import com.mipay.sdk.Mipay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class o implements IKSCibaQueryResult {
    final /* synthetic */ j a;
    private final r b;

    public o(j jVar, r rVar) {
        this.a = jVar;
        this.b = rVar;
    }

    public void searchResult(String str) {
        boolean z = false;
        s sVar = new s();
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            sVar.b = jSONObject.getJSONObject(Mipay.KEY_MESSAGE).getString("word_name");
            JSONObject jSONObject2 = jSONObject.getJSONObject(Mipay.KEY_MESSAGE);
            JSONObject optJSONObject = jSONObject2.optJSONObject("baseInfo");
            if (optJSONObject != null) {
                sVar.c = new TaskHandler();
                sVar.c.a = optJSONObject.optInt("translate_type");
                sVar.c.b = optJSONObject.optString("translate_result");
                sVar.c.c = optJSONObject.optString("translate_msg");
                JSONArray optJSONArray = optJSONObject.optJSONArray("symbols");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (i = 0; i < optJSONArray.length(); i++) {
                        sVar.c.d.add(a(optJSONArray.getJSONObject(i)));
                    }
                }
                jSONObject = optJSONObject.optJSONObject("exchange");
                if (jSONObject != null) {
                    if (sVar.c == null) {
                        sVar.c = new TaskHandler();
                    }
                    sVar.c.e = this.a.a(jSONObject);
                }
            }
            jSONObject2 = jSONObject2.optJSONObject("cc_mean");
            if (jSONObject2 != null) {
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("spells");
                sVar.d = new u();
                if (optJSONArray2 != null) {
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        sVar.d.a.add(b(optJSONArray2.getJSONObject(i)));
                    }
                }
                Object optString = jSONObject2.optString("structure");
                if (!TextUtils.isEmpty(optString)) {
                    sVar.d.b = optString;
                }
                optString = jSONObject2.optString("radical");
                if (!TextUtils.isEmpty(optString)) {
                    sVar.d.c = optString;
                }
                optString = jSONObject2.optString("strokes");
                if (!TextUtils.isEmpty(optString)) {
                    sVar.d.d = optString;
                }
                optString = jSONObject2.optString("wubi");
                if (!TextUtils.isEmpty(optString)) {
                    sVar.d.e = optString;
                }
            }
            if (!(sVar.c == null && sVar.d == null)) {
                z = true;
            }
            sVar.a = z;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        TaskHandler.postTask(new p(this, sVar));
    }

    private x a(JSONObject jSONObject) {
        x xVar = new x();
        StringBuffer stringBuffer = new StringBuffer();
        Object optString = jSONObject.optString("ph_am");
        CharSequence optString2 = jSONObject.optString("ph_en");
        Object optString3 = jSONObject.optString("word_symbol");
        if (TextUtils.isEmpty(optString3)) {
            if (!TextUtils.isEmpty(optString)) {
                stringBuffer.append(this.a.e.getString(i.plugins__dict__dj)).append("[").append(optString2).append("]");
            }
            if (!TextUtils.isEmpty(optString2)) {
                stringBuffer.append(this.a.e.getString(i.plugins__dict__kk)).append("[").append(optString).append("]");
            }
            xVar.a = stringBuffer.toString();
        } else {
            xVar.a = stringBuffer.append("[").append(optString3).append("]").toString();
        }
        JSONArray jSONArray = jSONObject.getJSONArray("parts");
        for (int i = 0; i < jSONArray.length(); i++) {
            v vVar = new v();
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            vVar.b = jSONObject2.getString("part");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("means");
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                stringBuffer2.append(jSONArray2.getString(i2)).append("；");
            }
            vVar.a = stringBuffer2.toString();
            xVar.b.add(vVar);
        }
        return xVar;
    }

    private w b(JSONObject jSONObject) {
        int i = 0;
        w wVar = new w();
        try {
            wVar.b = "[" + jSONObject.optString("spell") + "]";
            JSONArray optJSONArray = jSONObject.optJSONArray("means");
            if (optJSONArray != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    stringBuilder.append(optJSONArray.getString(i2)).append("\n");
                }
                wVar.a = stringBuilder.toString();
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("words");
            if (optJSONArray2 != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                while (i < optJSONArray2.length()) {
                    stringBuilder2.append(optJSONArray2.getString(i)).append(";");
                    i++;
                }
                wVar.c = stringBuilder2.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return wVar;
    }
}
