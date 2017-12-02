package com.duokan.reader.domain.payment;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.umpay.huafubao.Huafubao;

import org.json.JSONObject;

public class u extends q implements t {
    private final IWXAPI a = ThirdWeiXin.createWxApi(1);
    private r b;
    private s c;

    public String a() {
        return "WXPAY";
    }

    public void a(s sVar, r rVar) {
        this.c = sVar;
        this.b = rVar;
        try {
            JSONObject jSONObject = new JSONObject(sVar.b());
            if (jSONObject.has("retcode")) {
                rVar.b(this, sVar, "返回错误" + jSONObject.getString("retmsg"));
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
            a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s", new Object[]{sVar.d(), jSONObject.getString("out_trade_no")}));
            this.a.registerApp(payReq.appId);
            this.a.sendReq(payReq);
        } catch (Exception e) {
            rVar.b(this, sVar, "支付异常");
        }
    }

    public void a(BaseResp baseResp) {
        if (this.b != null && this.c != null) {
            Context topActivity = DkApp.get().getTopActivity();
            if (baseResp.getType() == 5) {
                a.c().c(LogLevel.EVENT, "pay", String.format("method: WXPAY, res_code: %s", new Object[]{baseResp.errCode + ""}));
                if (baseResp.errCode == 0) {
                    this.b.a(this, this.c, "");
                } else {
                    this.b.b(this, this.c, topActivity.getString(i.bookcity_store__shared__fail_to_pay));
                }
            }
            this.b = null;
            this.c = null;
        }
    }
}
