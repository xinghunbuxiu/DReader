package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.c.h;
import com.duokan.core.app.x;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.g;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.domain.document.epub.c;

public class ii extends gs {
    static final /* synthetic */ boolean y = (!ii.class.desiredAssertionStatus());
    private final DkCloudRedeemBenefit A = this.z.ai();
    private GiftView B = null;
    private View C = null;
    private View D = null;
    private final sh z = ((sh) x.a(getContext()).queryFeature(sh.class));

    public ii(Context context, gy gyVar) {
        super(context, gyVar);
    }

    public void setPage(gn gnVar) {
        super.setPage(gnVar);
        if (this.A != null) {
            removeViewInLayout(this.B);
            this.B = null;
        }
        if (this.C != null) {
            removeViewInLayout(this.C);
            this.C = null;
        }
        if (this.D != null) {
            removeViewInLayout(this.D);
            this.D = null;
        }
        if (gnVar != null && (gnVar.c() instanceof il)) {
            this.C = ((il) gnVar.c()).b();
            addView(this.C, new LayoutParams(-1, -1));
            gnVar.h().H();
        }
    }

    protected void a(gn gnVar) {
        super.a(gnVar);
        Rect A = getPageDrawable().A();
        if (!A.isEmpty()) {
            if (this.A != null) {
                if (((c) getPageDrawable().l().g()).g() == 0) {
                    this.B = (GiftView) LayoutInflater.from(getContext()).inflate(h.reading__gift_view, this, false);
                    this.B.setGiftCart(this.A);
                    this.B.setStatusColor(((sh) x.a(getContext()).queryFeature(sh.class)).R());
                    Rect ad = ((sh) x.a(getContext()).queryFeature(sh.class)).ad();
                    Rect a = ((sh) x.a(getContext()).queryFeature(sh.class)).getDocument().k().a();
                    this.B.setPadding(A.left + a.left, A.top + a.top, (ad.width() - A.right) + a.right, a.bottom + (ad.height() - A.bottom));
                    addView(this.B);
                }
            } else if (this.z.h() && ((c) getPageDrawable().l().g()).g() == 1) {
                this.C = this.z.a(getContext());
                if (!y && this.C == null) {
                    throw new AssertionError();
                } else if (this.C != null) {
                    addView(this.C, new LayoutParams(-1, -1));
                }
            }
        }
        if (this.z.h() && !TextUtils.isEmpty(this.k.K()) && !ReaderEnv.get().isVipDevice()) {
            A = this.k.z();
            int max = Math.max(dv.b(getContext(), 10.0f), (int) (((double) this.k.p().f) * this.k.p().h));
            this.D = this.z.bk().a(getContext(), (ViewGroup) this, A.height() - max);
            if (this.D != null) {
                LayoutParams layoutParams = (LayoutParams) this.D.getLayoutParams();
                layoutParams.leftMargin += A.left - this.k.p().a().left;
                layoutParams.topMargin = (max + A.top) + layoutParams.topMargin;
                layoutParams.rightMargin += (this.k.getIntrinsicWidth() - A.right) - this.k.p().a().right;
                layoutParams.bottomMargin = (this.k.getIntrinsicHeight() - A.bottom) + layoutParams.bottomMargin;
                layoutParams.gravity = this.k.p().e ? 48 : 80;
                addView(this.D, layoutParams);
            } else if (!A.isEmpty()) {
                g.a().f();
            }
        }
    }

    public void setStatusColor(int i) {
        super.setStatusColor(i);
        if (this.B != null) {
            this.B.setStatusColor(i);
        }
    }

    public boolean a() {
        return this.D != null;
    }

    public void b() {
        if (this.D != null) {
            this.z.bk().a(this.D);
        }
    }

    protected go a(Context context) {
        return new bn(context);
    }
}
