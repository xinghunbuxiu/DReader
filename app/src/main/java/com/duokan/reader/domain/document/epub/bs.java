package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.kernel.DkFileInfo;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C1012y;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.domain.document.ai;
import java.io.ByteArrayInputStream;

class bs extends ah {
    /* renamed from: a */
    final /* synthetic */ az f4603a;
    /* renamed from: b */
    private final String f4604b;
    /* renamed from: c */
    private final ai[] f4605c;
    /* renamed from: d */
    private final Rect f4606d;
    /* renamed from: e */
    private final Bitmap[] f4607e;

    private bs(az azVar, DkeHitTestInfo dkeHitTestInfo) {
        int i;
        this.f4603a = azVar;
        this.f4605c = new ai[dkeHitTestInfo.mMediaInfo.mMediaSources.length];
        for (i = 0; i < this.f4605c.length; i++) {
            this.f4605c[i] = new ai();
            switch (dkeHitTestInfo.mMediaInfo.mMediaSources[i].mMimeType) {
                case 1:
                    this.f4605c[i].f4400a = "video/ogg";
                    break;
                case 2:
                    this.f4605c[i].f4400a = "video/mp4";
                    break;
                case 3:
                    this.f4605c[i].f4400a = "video/webm";
                    break;
                case 4:
                    this.f4605c[i].f4400a = "audio/ogg";
                    break;
                case 5:
                    this.f4605c[i].f4400a = "audio/mpeg";
                    break;
                default:
                    this.f4605c[i].f4400a = "";
                    break;
            }
            this.f4605c[i].f4402c = dkeHitTestInfo.mMediaInfo.mMediaSources[i].mUrl;
            if (dkeHitTestInfo.mMediaInfo.mMediaSources[i].mStream != null) {
                this.f4605c[i].f4401b = new C1012y(azVar.f4524e.mo1369e(), dkeHitTestInfo.mMediaInfo.mMediaSources[i].mStream);
            } else {
                this.f4605c[i].f4401b = new ByteArrayInputStream(new byte[0]);
            }
            try {
                this.f4605c[i].f4403d = this.f4605c[i].f4401b.available();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f4604b = dkeHitTestInfo.mMediaInfo.mTitle;
        this.f4606d = dkeHitTestInfo.mBoundingBox.toRect();
        this.f4607e = new Bitmap[dkeHitTestInfo.mMediaInfo.mPosterData.length];
        for (i = 0; i < this.f4607e.length; i++) {
            DkFileInfo dkFileInfo = dkeHitTestInfo.mMediaInfo.mPosterData[i];
            if (dkFileInfo != null) {
                this.f4607e[i] = C0544a.m2436a(DkApp.get(), dkFileInfo.mData, 0, dkFileInfo.mData.length);
            } else {
                this.f4607e[i] = null;
            }
        }
    }

    /* renamed from: a */
    public String mo1410a() {
        return this.f4604b;
    }

    /* renamed from: b */
    public ai[] mo1411b() {
        return this.f4605c;
    }

    /* renamed from: c */
    public Bitmap[] mo1412c() {
        return this.f4607e;
    }

    /* renamed from: d */
    public boolean mo1413d() {
        return m6749a("audio/");
    }

    /* renamed from: e */
    public boolean mo1414e() {
        return m6749a("video/");
    }

    /* renamed from: a */
    private boolean m6749a(String str) {
        if (this.f4605c == null || this.f4605c.length <= 0) {
            return false;
        }
        Object obj = this.f4605c[0].f4400a;
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || !obj.startsWith(str)) {
            return false;
        }
        return true;
    }
}
