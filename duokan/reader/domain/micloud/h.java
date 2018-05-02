package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import cn.kuaipan.android.kss.IKssDownloadRequestResult;
import cn.kuaipan.android.kss.IKssRequestor;
import cn.kuaipan.android.kss.IKssUploadRequestResult;
import cn.kuaipan.android.kss.KssMaster.IRemote;
import cn.kuaipan.android.kss.UploadRequestResult;
import cn.kuaipan.android.kss.upload.KssUploadInfo;
import cn.kuaipan.android.kss.upload.UploadFileInfo;

class h implements IKssRequestor {
    final /* synthetic */ d a;

    private h(d dVar) {
        this.a = dVar;
    }

    public /* synthetic */ void commitUpload(File file, IRemote iRemote, KssUploadInfo kssUploadInfo) {
        a(file, (g) iRemote, kssUploadInfo);
    }

    public /* synthetic */ IKssDownloadRequestResult requestDownload(IRemote iRemote) {
        return a((g) iRemote);
    }

    public /* synthetic */ IKssUploadRequestResult requestUpload(File file, IRemote iRemote, UploadFileInfo uploadFileInfo) {
        return a(file, (g) iRemote, uploadFileInfo);
    }

    public IKssUploadRequestResult a(File file, g gVar, UploadFileInfo uploadFileInfo) {
        JSONObject a = ((i) this.a.b()).E().b().a();
        try {
            a.put("stat", "OK");
        } catch (JSONException e) {
        }
        return UploadRequestResult.create(a.toString());
    }

    public void a(File file, g gVar, KssUploadInfo kssUploadInfo) {
        ((i) this.a.b()).a(ai.a(kssUploadInfo));
        this.a.b(true);
        this.a.j();
    }

    public IKssDownloadRequestResult a(g gVar) {
        throw new UnsupportedOperationException();
    }
}
