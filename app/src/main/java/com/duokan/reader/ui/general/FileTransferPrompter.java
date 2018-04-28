package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.core.sys.af;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;

public class FileTransferPrompter {

    public enum FlowChargingTransferChoice {
        Default,
        Transfer,
        NoTransfer;

        public af<Boolean> wifiOnly() {
            if (this == Default) {
                return new af();
            }
            if (this == NoTransfer) {
                return new af(Boolean.valueOf(true));
            }
            return new af(Boolean.valueOf(false));
        }
    }

    /* renamed from: a */
    public static void m9977a(Context context, long j, String str, String str2, cm cmVar) {
        if (!C0559f.m2476b().m2484c()) {
            cmVar.onChoice(true, FlowChargingTransferChoice.NoTransfer);
        } else if (ReaderEnv.get().getIsOnlyWifiUploadDownload()) {
            ap ckVar = new ck(context, cmVar);
            ckVar.setTitle(str);
            ckVar.setPrompt(context.getResources().getString(C0247i.general__shared__data_plan_download_prompt) + " " + str2);
            ckVar.setOkLabelResid(C0247i.general__shared__continue_download);
            ckVar.setCancelLabel(C0247i.general__shared__cancel);
            ckVar.show();
        } else {
            cmVar.onChoice(true, FlowChargingTransferChoice.Transfer);
        }
    }

    /* renamed from: b */
    public static void m9978b(Context context, long j, String str, String str2, cm cmVar) {
        if (!C0559f.m2476b().m2484c()) {
            cmVar.onChoice(true, FlowChargingTransferChoice.NoTransfer);
        } else if (ReaderEnv.get().getIsOnlyWifiUploadDownload()) {
            ap clVar = new cl(context, cmVar);
            clVar.setTitle(str);
            clVar.setPrompt(context.getResources().getString(C0247i.general__shared__data_plan_upload_prompt) + " " + str2);
            clVar.setOkLabelResid(C0247i.general__shared__continue_upload);
            clVar.setCancelLabel(C0247i.general__shared__cancel);
            clVar.show();
        } else {
            cmVar.onChoice(true, FlowChargingTransferChoice.Transfer);
        }
    }
}
