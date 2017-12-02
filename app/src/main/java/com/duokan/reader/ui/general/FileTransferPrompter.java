package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;

public class FileTransferPrompter {

    public enum FlowChargingTransferChoice {
        Default,
        Transfer,
        NoTransfer;

        public af wifiOnly() {
            if (this == Default) {
                return new af();
            }
            if (this == NoTransfer) {
                return new af(Boolean.valueOf(true));
            }
            return new af(Boolean.valueOf(false));
        }
    }

    public static void a(Context context, long j, String str, String str2, cm cmVar) {
        if (!f.b().c()) {
            cmVar.onChoice(true, FlowChargingTransferChoice.NoTransfer);
        } else if (ReaderEnv.get().getIsOnlyWifiUploadDownload()) {
            ap ckVar = new ck(context, cmVar);
            ckVar.setTitle(str);
            ckVar.setPrompt(context.getResources().getString(i.general__shared__data_plan_download_prompt) + " " + str2);
            ckVar.setOkLabel(i.general__shared__continue_download);
            ckVar.setCancelLabel(i.general__shared__cancel);
            ckVar.show();
        } else {
            cmVar.onChoice(true, FlowChargingTransferChoice.Transfer);
        }
    }

    public static void b(Context context, long j, String str, String str2, cm cmVar) {
        if (!f.b().c()) {
            cmVar.onChoice(true, FlowChargingTransferChoice.NoTransfer);
        } else if (ReaderEnv.get().getIsOnlyWifiUploadDownload()) {
            ap clVar = new cl(context, cmVar);
            clVar.setTitle(str);
            clVar.setPrompt(context.getResources().getString(i.general__shared__data_plan_upload_prompt) + " " + str2);
            clVar.setOkLabel(i.general__shared__continue_upload);
            clVar.setCancelLabel(i.general__shared__cancel);
            clVar.show();
        } else {
            cmVar.onChoice(true, FlowChargingTransferChoice.Transfer);
        }
    }
}
