package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.DownloadRequestResult;
import cn.kuaipan.android.kss.IKssDownloadRequestResult;
import cn.kuaipan.android.kss.IKssRequestor;
import cn.kuaipan.android.kss.IKssUploadRequestResult;
import cn.kuaipan.android.kss.KssMaster.IRemote;
import cn.kuaipan.android.kss.upload.KssUploadInfo;
import cn.kuaipan.android.kss.upload.UploadFileInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.y */
class C1083y implements IKssRequestor<C1082x> {
    /* renamed from: a */
    final /* synthetic */ C1079u f5307a;

    private C1083y(C1079u c1079u) {
        this.f5307a = c1079u;
    }

    public /* synthetic */ void commitUpload(File file, IRemote iRemote, KssUploadInfo kssUploadInfo) {
        m8313a(file, (C1082x) iRemote, kssUploadInfo);
    }

    public /* synthetic */ IKssDownloadRequestResult requestDownload(IRemote iRemote) {
        return m8311a((C1082x) iRemote);
    }

    public /* synthetic */ IKssUploadRequestResult requestUpload(File file, IRemote iRemote, UploadFileInfo uploadFileInfo) {
        return m8312a(file, (C1082x) iRemote, uploadFileInfo);
    }

    /* renamed from: a */
    public IKssUploadRequestResult m8312a(File file, C1082x c1082x, UploadFileInfo uploadFileInfo) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void m8313a(File file, C1082x c1082x, KssUploadInfo kssUploadInfo) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public IKssDownloadRequestResult m8311a(C1082x c1082x) {
        JSONObject a = ((C1084z) this.f5307a.mo734b()).m8314A().m8103a().m8062a();
        try {
            a.put("stat", "OK");
        } catch (JSONException e) {
        }
        return DownloadRequestResult.create(a.toString());
    }
}
