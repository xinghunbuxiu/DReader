package com.duokan.reader.domain.document.epub;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeLinkInfo;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.av;

class bp extends ae {
    /* renamed from: d */
    static final /* synthetic */ boolean f4580d = (!az.class.desiredAssertionStatus());
    /* renamed from: a */
    public final String f4581a;
    /* renamed from: b */
    public final String f4582b;
    /* renamed from: c */
    public final av f4583c;
    /* renamed from: e */
    final /* synthetic */ az f4584e;

    private bp(az azVar, DkeLinkInfo dkeLinkInfo) {
        this.f4584e = azVar;
        if (dkeLinkInfo != null && dkeLinkInfo.mLinkType == 1) {
            DkFlowPosition flowPositionByLink = azVar.m6544Y().getFlowPositionByLink(dkeLinkInfo.mLinkTarget, dkeLinkInfo.mLinkAnchor);
            if (flowPositionByLink == null || URLUtil.isValidUrl(dkeLinkInfo.mLinkTarget)) {
                switch (dkeLinkInfo.mFileType) {
                    case 1:
                        this.f4581a = "";
                        break;
                    case 2:
                        this.f4581a = "text/html";
                        break;
                    default:
                        this.f4581a = "";
                        break;
                }
                if (TextUtils.isEmpty(dkeLinkInfo.mLinkAnchor)) {
                    this.f4582b = dkeLinkInfo.mLinkTarget;
                } else {
                    this.f4582b = dkeLinkInfo.mLinkTarget + "#" + dkeLinkInfo.mLinkAnchor;
                }
                this.f4583c = null;
                return;
            }
            this.f4581a = "";
            this.f4582b = "";
            this.f4583c = ai.m6508a(flowPositionByLink.mChapterIndex, flowPositionByLink.mParaIndex, flowPositionByLink.mAtomIndex);
        } else if (f4580d) {
            this.f4581a = "";
            this.f4582b = "";
            this.f4583c = null;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public String mo1406a() {
        return this.f4581a;
    }

    /* renamed from: b */
    public String mo1407b() {
        return this.f4582b;
    }

    /* renamed from: c */
    public av mo1408c() {
        return this.f4583c;
    }
}
