package com.duokan.reader.domain.payment;

import android.content.Context;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.umpay.huafubao.Huafubao;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.payment.u */
public class C1105u extends C1085q implements C1104t {
    /* renamed from: a */
    private final IWXAPI f5378a = ThirdWeiXin.createWxApi(1);
    /* renamed from: b */
    private C1097r f5379b;
    /* renamed from: c */
    private C1089s f5380c;

    /* renamed from: a */
    public String mo1499a() {
        return "WXPAY";
    }

    /* renamed from: a */
    public void mo1500a(C1089s c1089s, C1097r c1097r) {
        this.f5380c = c1089s;
        this.f5379b = c1097r;
        try {
            JSONObject jSONObject = new JSONObject(c1089s.mo1502b());
            if (jSONObject.has("retcode")) {
                c1097r.mo1509b(this, c1089s, "返回错误" + jSONObject.getString("retmsg"));
                return;
            }
            BaseReq payReq = new PayReq();
            payReq.appId = jSONObject.getString("appid");
            payReq.partnerId = jSONObject.getString("partnerid");
            payReq.prepayId = jSONObject.getString("prepayid");
            payReq.nonceStr = jSONObject.getString("noncestr");
            payReq.timeStamp = jSONObject.getString("timestamp");
            payReq.packageValue = jSONObject.getString("package");
            payReq.sign = jSONObject.getString(Huafubao.SIGN_STRING);
            WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s", new Object[]{c1089s.mo1504d(), jSONObject.getString("out_trade_no")}));
            this.f5378a.registerApp(payReq.appId);
            this.f5378a.sendReq(payReq);
        } catch (Exception e) {
            c1097r.mo1509b(this, c1089s, "支付异常");
        }
    }

    /* renamed from: a */
    public void mo1510a(BaseResp baseResp) {
        if (this.f5379b != null && this.f5380c != null) {
            Context topActivity = DkApp.get().getTopActivity();
            if (baseResp.getType() == 5) {
                WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: WXPAY, res_code: %s", new Object[]{baseResp.errCode + ""}));
                if (baseResp.errCode == 0) {
                    this.f5379b.mo1508a(this, this.f5380c, "");
                } else {
                    this.f5379b.mo1509b(this, this.f5380c, topActivity.getString(C0247i.bookcity_store__shared__fail_to_pay));
                }
            }
            this.f5379b = null;
            this.f5380c = null;
        }
    }
}
