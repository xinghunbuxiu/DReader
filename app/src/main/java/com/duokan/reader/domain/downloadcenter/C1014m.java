package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.downloadcenter.m */
public abstract class C1014m {
    /* renamed from: k */
    public String f5034k = "";
    /* renamed from: l */
    public long f5035l = 0;
    /* renamed from: m */
    public FlowChargingTransferChoice f5036m = FlowChargingTransferChoice.Default;

    /* renamed from: a */
    public abstract DownloadType mo1474a();

    /* renamed from: b */
    public abstract String mo1475b();

    public C1014m(JSONObject jSONObject) {
        this.f5034k = jSONObject.optString("download_channel");
        this.f5035l = jSONObject.optLong("file_length", 0);
        this.f5036m = FlowChargingTransferChoice.valueOf(jSONObject.optString("transfer_choice_at_data_plan", FlowChargingTransferChoice.Default.name()));
        if (this.f5036m == null) {
            this.f5036m = FlowChargingTransferChoice.Default;
        }
    }

    /* renamed from: c */
    public JSONObject m7814c() {
        JSONObject jSONObject = new JSONObject();
        mo1476b(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return m7814c().toString();
    }

    /* renamed from: b */
    protected void mo1476b(JSONObject jSONObject) {
        try {
            jSONObject.put("download_type", mo1474a().toString());
            jSONObject.put("download_channel", this.f5034k.toString());
            jSONObject.put("file_length", this.f5035l);
            jSONObject.put("transfer_choice_at_data_plan", this.f5036m == null ? FlowChargingTransferChoice.Default.name() : this.f5036m.name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
