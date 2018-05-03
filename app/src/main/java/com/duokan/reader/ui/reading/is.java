package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.domain.document.epub.C0936c;

public class is extends gx {
    /* renamed from: y */
    static final /* synthetic */ boolean f10398y = (!is.class.desiredAssertionStatus());
    /* renamed from: A */
    private final DkCloudRedeemBenefit f10399A = this.f10403z.ai();
    /* renamed from: B */
    private GiftView f10400B = null;
    /* renamed from: C */
    private View f10401C = null;
    /* renamed from: D */
    private View f10402D = null;
    /* renamed from: z */
    private final su f10403z = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));

    public is(Context context, hd hdVar) {
        super(context, hdVar);
    }

    public void setPage(gs gsVar) {
        super.setPage(gsVar);
        if (this.f10399A != null) {
            removeViewInLayout(this.f10400B);
            this.f10400B = null;
        }
        if (this.f10401C != null) {
            removeViewInLayout(this.f10401C);
            this.f10401C = null;
        }
        if (this.f10402D != null) {
            removeViewInLayout(this.f10402D);
            this.f10402D = null;
        }
        if (gsVar != null && (gsVar.mo2327c() instanceof iv)) {
            this.f10401C = ((iv) gsVar.mo2327c()).m14455b();
            addView(this.f10401C, new LayoutParams(-1, -1));
            gsVar.mo2332h().mo1285H();
        }
    }

    /* renamed from: a */
    protected void mo2388a(gs gsVar) {
        super.mo2388a(gsVar);
        Rect A = getPageDrawable().mo1280A();
        if (!A.isEmpty()) {
            if (this.f10399A != null) {
                if (((C0936c) getPageDrawable().mo1332l().mo1198g()).m6780g() == 0) {
                    this.f10400B = (GiftView) LayoutInflater.from(getContext()).inflate(C0256h.reading__gift_view, this, false);
                    this.f10400B.setGiftCart(this.f10399A);
                    this.f10400B.setStatusColor(((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).mo2001R());
                    Rect ad = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).ad();
                    Rect a = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).getDocument().mo1245k().m6083a();
                    this.f10400B.setPadding(A.left + a.left, A.top + a.top, (ad.width() - A.right) + a.right, a.bottom + (ad.height() - A.bottom));
                    addView(this.f10400B);
                }
            } else if (this.f10403z.mo2155h() && ((C0936c) getPageDrawable().mo1332l().mo1198g()).m6780g() == 1) {
                this.f10401C = this.f10403z.mo2014a(getContext());
                if (!f10398y && this.f10401C == null) {
                    throw new AssertionError();
                } else if (this.f10401C != null) {
                    addView(this.f10401C, new LayoutParams(-1, -1));
                }
            }
        }
        if (this.f10403z.mo2155h() && !TextUtils.isEmpty(this.k.mo1287J()) && !ReaderEnv.get().isVipDevice()) {
            A = this.k.mo1356z();
            int max = Math.max(AnimUtils.m1932b(getContext(), 10.0f), (int) (((double) this.k.mo1340p().f4335f) * this.k.mo1340p().f4337h));
            this.f10402D = this.f10403z.bl().m12755a(getContext(), (ViewGroup) this, A.height() - max);
            if (this.f10402D != null) {
                LayoutParams layoutParams = (LayoutParams) this.f10402D.getLayoutParams();
                layoutParams.leftMargin += A.left - this.k.mo1340p().m6083a().left;
                layoutParams.topMargin = (max + A.top) + layoutParams.topMargin;
                layoutParams.rightMargin += (this.k.getIntrinsicWidth() - A.right) - this.k.mo1340p().m6083a().right;
                layoutParams.bottomMargin = (this.k.getIntrinsicHeight() - A.bottom) + layoutParams.bottomMargin;
                layoutParams.gravity = this.k.mo1340p().f4334e ? 48 : 80;
                addView(this.f10402D, layoutParams);
            } else if (!A.isEmpty()) {
                C0750g.m3561a().m3595f();
            }
        }
    }

    public void setStatusColor(int i) {
        super.setStatusColor(i);
        if (this.f10400B != null) {
            this.f10400B.setStatusColor(i);
        }
    }

    /* renamed from: a */
    public boolean mo2389a() {
        return this.f10402D != null;
    }

    /* renamed from: b */
    public void mo2390b() {
        if (this.f10402D != null) {
            this.f10403z.bl().m12756a(this.f10402D);
        }
    }

    /* renamed from: a */
    protected gt mo2387a(Context context) {
        return new bn(context);
    }
}
