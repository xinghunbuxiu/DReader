package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.IKssDownloadRequestResult;
import cn.kuaipan.android.kss.IKssRequestor;
import cn.kuaipan.android.kss.IKssUploadRequestResult;
import cn.kuaipan.android.kss.KssMaster.IRemote;
import cn.kuaipan.android.kss.UploadRequestResult;
import cn.kuaipan.android.kss.upload.KssUploadInfo;
import cn.kuaipan.android.kss.upload.UploadFileInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.h */
class C1067h implements IKssRequestor<C1066g> {
    /* renamed from: a */
    final /* synthetic */ C1063d f5271a;

    private C1067h(C1063d c1063d) {
        this.f5271a = c1063d;
    }

    public /* synthetic */ void commitUpload(File file, IRemote iRemote, KssUploadInfo kssUploadInfo) {
        m8204a(file, (C1066g) iRemote, kssUploadInfo);
    }

    public /* synthetic */ IKssDownloadRequestResult requestDownload(IRemote iRemote) {
        return m8202a((C1066g) iRemote);
    }

    public /* synthetic */ IKssUploadRequestResult requestUpload(File file, IRemote iRemote, UploadFileInfo uploadFileInfo) {
        return m8203a(file, (C1066g) iRemote, uploadFileInfo);
    }

    /* renamed from: a */
    public IKssUploadRequestResult m8203a(File file, C1066g c1066g, UploadFileInfo uploadFileInfo) {
        JSONObject a = ((C1068i) this.f5271a.mo734b()).m8209E().m8145b().m8063a();
        try {
            a.put("stat", "OK");
        } catch (JSONException e) {
        }
        return UploadRequestResult.create(a.toString());
    }

    /* renamed from: a */
    public void m8204a(File file, C1066g c1066g, KssUploadInfo kssUploadInfo) {
        ((C1068i) this.f5271a.mo734b()).m8220a(ai.m8060a(kssUploadInfo));
        this.f5271a.m8183b(true);
        this.f5271a.m2277j();
    }

    /* renamed from: a */
    public IKssDownloadRequestResult m8202a(C1066g c1066g) {
        throw new UnsupportedOperationException();
    }
}
