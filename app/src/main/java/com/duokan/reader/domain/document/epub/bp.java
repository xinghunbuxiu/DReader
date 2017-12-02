package com.duokan.reader.domain.document.epub;

import android.text.TextUtils;
import android.webkit.URLUtil;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeLinkInfo;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.av;

class bp extends ae {
    static final /* synthetic */ boolean d = (!az.class.desiredAssertionStatus());
    public final String a;
    public final String b;
    public final av c;
    final /* synthetic */ az e;

    private bp(az azVar, DkeLinkInfo dkeLinkInfo) {
        this.e = azVar;
        if (dkeLinkInfo != null && dkeLinkInfo.mLinkType == 1) {
            DkFlowPosition flowPositionByLink = azVar.Z().getFlowPositionByLink(dkeLinkInfo.mLinkTarget, dkeLinkInfo.mLinkAnchor);
            if (flowPositionByLink == null || URLUtil.isValidUrl(dkeLinkInfo.mLinkTarget)) {
                switch (dkeLinkInfo.mFileType) {
                    case 1:
                        this.a = "";
                        break;
                    case 2:
                        this.a = "text/html";
                        break;
                    default:
                        this.a = "";
                        break;
                }
                if (TextUtils.isEmpty(dkeLinkInfo.mLinkAnchor)) {
                    this.b = dkeLinkInfo.mLinkTarget;
                } else {
                    this.b = dkeLinkInfo.mLinkTarget + "#" + dkeLinkInfo.mLinkAnchor;
                }
                this.c = null;
                return;
            }
            this.a = "";
            this.b = "";
            this.c = ai.a(flowPositionByLink.mChapterIndex, flowPositionByLink.mParaIndex, flowPositionByLink.mAtomIndex);
        } else if (d) {
            this.a = "";
            this.b = "";
            this.c = null;
        } else {
            throw new AssertionError();
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public av c() {
        return this.c;
    }
}
