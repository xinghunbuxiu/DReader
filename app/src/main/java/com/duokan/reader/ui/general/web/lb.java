package com.duokan.reader.ui.general.web;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

class lb extends WebSession {
    /* renamed from: a */
    C0621a<JSONObject> f8131a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ String[] f8132b;
    /* renamed from: c */
    final /* synthetic */ String f8133c;
    /* renamed from: d */
    final /* synthetic */ String f8134d;
    /* renamed from: e */
    final /* synthetic */ TtsWebController f8135e;

    lb(TtsWebController ttsWebController, C0657i c0657i, String[] strArr, String str, String str2) {
        this.f8135e = ttsWebController;
        this.f8132b = strArr;
        this.f8133c = str;
        this.f8134d = str2;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0652z c0652z = new C0652z((WebSession) this, C0709k.m3476a().m3508d());
        this.f8131a = c0652z.m3083j(this.f8132b[1]);
        while (this.f8131a.b != 10047) {
            if (this.f8131a.b == 10049) {
                WebLog.init().c(LogLevel.ERROR, "tts_payment", "auth_timeout");
                return;
            } else if (this.f8131a.b == 0) {
                return;
            } else {
                if (this.f8131a.b != 10048) {
                    WebLog.init().c(LogLevel.ERROR, "tts_payment", "auth_unknown_error:" + this.f8131a.b);
                    return;
                } else {
                    UIdleHandler.sleep(1000);
                    this.f8131a = c0652z.m3083j(this.f8132b[1]);
                }
            }
        }
        WebLog.init().c(LogLevel.ERROR, "tts_payment", "trans_not_found");
    }

    protected void onSessionSucceeded() {
        if (this.f8131a.b != 0) {
            this.f8132b[0] = "0";
        } else if (this.f8131a.f2058a == null) {
            this.f8132b[0] = "0";
            WebLog.init().c(LogLevel.ERROR, "tts_payment", "empty_auth_result");
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Mipay.KEY_CODE, 0);
                jSONObject.put("speaker", new JSONObject(this.f8133c));
                jSONObject.put(Mipay.KEY_ORDER, new JSONObject(this.f8134d));
                long j = ((JSONObject) this.f8131a.f2058a).getLong("expire_time");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("expirationDate", simpleDateFormat.format(Long.valueOf(j * 1000)));
                jSONObject.put("data", jSONObject2);
                this.f8135e.invokeJS("iflytek.jsHandler.onPayCompleted", jSONObject.toString());
                be.m10287a(this.f8135e.getContext(), (CharSequence) "支付成功", 0).show();
                this.f8132b[0] = "1";
            } catch (Throwable th) {
                this.f8132b[0] = "0";
                WebLog.init().c(LogLevel.ERROR, "tts_payment", "auth_report_error, result:true");
            }
        }
    }

    protected void onSessionFailed() {
        WebLog.init().c(LogLevel.ERROR, "tts_payment", "auth_session_error");
        this.f8132b[0] = "0";
    }

    protected void onSessionClosed() {
        if (this.f8132b[0].equals("0")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Mipay.KEY_CODE, 1);
                jSONObject.put("speaker", new JSONObject(this.f8133c));
                jSONObject.put(Mipay.KEY_ORDER, new JSONObject(this.f8134d));
                this.f8135e.invokeJS("iflytek.jsHandler.onPayCompleted", jSONObject.toString());
            } catch (Throwable th) {
                WebLog.init().c(LogLevel.ERROR, "tts_payment", "auth_report_error, result:false");
            }
        }
    }
}
