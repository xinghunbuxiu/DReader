package com.duokan.reader.ui.reading;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.bookshelf.C0800c;

public class em extends ActivatedController {
    /* renamed from: a */
    protected final su f10086a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    protected final C0800c f10087b = this.f10086a.mo1992G();
    /* renamed from: c */
    protected final wy f10088c;
    /* renamed from: d */
    protected final Drawable f10089d;
    /* renamed from: e */
    protected final FrameLayout f10090e;
    /* renamed from: f */
    protected final View f10091f;
    /* renamed from: g */
    protected final ImageView f10092g;

    @TargetApi(11)
    public em(IFeature mFeature, wy wyVar) {
        super(mFeature);
        this.f10088c = wyVar;
        this.f10089d = this.f10086a.mo2002S();
        this.f10090e = new FrameLayout(getContext());
        setContentView(this.f10090e);
        this.f10091f = new en(this, getContext());
        this.f10092g = new ImageView(getContext());
        Bitmap c = C0544a.m2447c(this.f10088c.getWidth() / 2, this.f10088c.getHeight() / 2, Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        canvas.scale(0.5f, 0.5f);
        this.f10088c.draw(canvas);
        DkUtils.blurBitmap(c, 8);
        this.f10092g.setImageBitmap(c);
        if (VERSION.SDK_INT >= 11) {
            this.f10092g.setAlpha(0.2f);
        }
        this.f10092g.setScaleType(ScaleType.FIT_XY);
        this.f10090e.addView(this.f10091f, new LayoutParams(-1, -1));
        this.f10090e.addView(this.f10092g, new LayoutParams(-1, -1));
    }

    protected boolean onBack() {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).goHome(null);
        return true;
    }
}
