package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class m {
    public String k = "";
    public long l = 0;
    public FlowChargingTransferChoice m = FlowChargingTransferChoice.Default;

    public abstract DownloadType a();

    public abstract String b();

    public m(JSONObject jSONObject) {
        this.k = jSONObject.optString("download_channel");
        this.l = jSONObject.optLong("file_length", 0);
        this.m = FlowChargingTransferChoice.valueOf(jSONObject.optString("transfer_choice_at_data_plan", FlowChargingTransferChoice.Default.name()));
        if (this.m == null) {
            this.m = FlowChargingTransferChoice.Default;
        }
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return c().toString();
    }

    protected void b(JSONObject jSONObject) {
        try {
            jSONObject.put("download_type", a().toString());
            jSONObject.put("download_channel", this.k.toString());
            jSONObject.put("file_length", this.l);
            jSONObject.put("transfer_choice_at_data_plan", this.m == null ? FlowChargingTransferChoice.Default.name() : this.m.name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
