package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.C0299i;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import org.json.JSONObject;

class ky implements cm {
    /* renamed from: a */
    final /* synthetic */ JSONObject f8122a;
    /* renamed from: b */
    final /* synthetic */ TtsSpeaker f8123b;
    /* renamed from: c */
    final /* synthetic */ C0299i f8124c;
    /* renamed from: d */
    final /* synthetic */ String f8125d;
    /* renamed from: e */
    final /* synthetic */ TtsWebController f8126e;

    ky(TtsWebController ttsWebController, JSONObject jSONObject, TtsSpeaker ttsSpeaker, C0299i c0299i, String str) {
        this.f8126e = ttsWebController;
        this.f8122a = jSONObject;
        this.f8123b = ttsSpeaker;
        this.f8124c = c0299i;
        this.f8125d = str;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.f8126e.addDownloadTask(this.f8122a, this.f8123b, flowChargingTransferChoice);
            this.f8124c.m708a(this.f8126e.getRetString(this.f8125d, true));
            return;
        }
        this.f8124c.m708a(this.f8126e.getRetString(this.f8125d, false));
    }
}
