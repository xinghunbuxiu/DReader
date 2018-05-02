package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.kernel.DkFileInfo;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.domain.document.ai;
import com.duokan.reader.domain.document.y;

import java.io.ByteArrayInputStream;

class bs extends ah {
    final /* synthetic */ az a;
    private final String b;
    private final ai[] c;
    private final Rect d;
    private final Bitmap[] e;

    private bs(az azVar, DkeHitTestInfo dkeHitTestInfo) {
        int i;
        this.a = azVar;
        this.c = new ai[dkeHitTestInfo.mMediaInfo.mMediaSources.length];
        for (i = 0; i < this.c.length; i++) {
            this.c[i] = new ai();
            switch (dkeHitTestInfo.mMediaInfo.mMediaSources[i].mMimeType) {
                case 1:
                    this.c[i].a = "video/ogg";
                    break;
                case 2:
                    this.c[i].a = "video/mp4";
                    break;
                case 3:
                    this.c[i].a = "video/webm";
                    break;
                case 4:
                    this.c[i].a = "audio/ogg";
                    break;
                case 5:
                    this.c[i].a = "audio/mpeg";
                    break;
                default:
                    this.c[i].a = "";
                    break;
            }
            this.c[i].c = dkeHitTestInfo.mMediaInfo.mMediaSources[i].mUrl;
            if (dkeHitTestInfo.mMediaInfo.mMediaSources[i].mStream != null) {
                this.c[i].b = new y(azVar.e.e(), dkeHitTestInfo.mMediaInfo.mMediaSources[i].mStream);
            } else {
                this.c[i].b = new ByteArrayInputStream(new byte[0]);
            }
            try {
                this.c[i].d = this.c[i].b.available();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.b = dkeHitTestInfo.mMediaInfo.mTitle;
        this.d = dkeHitTestInfo.mBoundingBox.toRect();
        this.e = new Bitmap[dkeHitTestInfo.mMediaInfo.mPosterData.length];
        for (i = 0; i < this.e.length; i++) {
            DkFileInfo dkFileInfo = dkeHitTestInfo.mMediaInfo.mPosterData[i];
            if (dkFileInfo != null) {
                this.e[i] = a.a(DkApp.get(), dkFileInfo.mData, 0, dkFileInfo.mData.length);
            } else {
                this.e[i] = null;
            }
        }
    }

    public String a() {
        return this.b;
    }

    public ai[] b() {
        return this.c;
    }

    public Bitmap[] c() {
        return this.e;
    }

    public boolean d() {
        return a("audio/");
    }

    public boolean e() {
        return a("video/");
    }

    private boolean a(String str) {
        if (this.c == null || this.c.length <= 0) {
            return false;
        }
        Object obj = this.c[0].a;
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || !obj.startsWith(str)) {
            return false;
        }
        return true;
    }
}
