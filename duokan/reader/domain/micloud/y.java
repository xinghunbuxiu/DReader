package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import cn.kuaipan.android.kss.DownloadRequestResult;
import cn.kuaipan.android.kss.IKssDownloadRequestResult;
import cn.kuaipan.android.kss.IKssRequestor;
import cn.kuaipan.android.kss.IKssUploadRequestResult;
import cn.kuaipan.android.kss.KssMaster.IRemote;
import cn.kuaipan.android.kss.upload.KssUploadInfo;
import cn.kuaipan.android.kss.upload.UploadFileInfo;

class y implements IKssRequestor {
    final /* synthetic */ u a;

    private y(u uVar) {
        this.a = uVar;
    }

    public /* synthetic */ void commitUpload(File file, IRemote iRemote, KssUploadInfo kssUploadInfo) {
        a(file, (x) iRemote, kssUploadInfo);
    }

    public /* synthetic */ IKssDownloadRequestResult requestDownload(IRemote iRemote) {
        return a((x) iRemote);
    }

    public /* synthetic */ IKssUploadRequestResult requestUpload(File file, IRemote iRemote, UploadFileInfo uploadFileInfo) {
        return a(file, (x) iRemote, uploadFileInfo);
    }

    public IKssUploadRequestResult a(File file, x xVar, UploadFileInfo uploadFileInfo) {
        throw new UnsupportedOperationException();
    }

    public void a(File file, x xVar, KssUploadInfo kssUploadInfo) {
        throw new UnsupportedOperationException();
    }

    public IKssDownloadRequestResult a(x xVar) {
        JSONObject a = ((z) this.a.b()).A().a().a();
        try {
            a.put("stat", "OK");
        } catch (JSONException e) {
        }
        return DownloadRequestResult.create(a.toString());
    }
}
