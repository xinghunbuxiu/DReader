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

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.c;

public class ei extends ActivatedController {
    protected final sh a = ((sh) getContext().queryFeature(sh.class));
    protected final c b = this.a.G();
    protected final wl c;
    protected final Drawable d;
    protected final FrameLayout e;
    protected final View f;
    protected final ImageView g;

    @TargetApi(11)
    public ei(IFeature featrue, wl wlVar) {
        super(featrue);
        this.c = wlVar;
        this.d = this.a.S();
        this.e = new FrameLayout(getContext());
        setContentView(this.e);
        this.f = new ej(this, getContext());
        this.g = new ImageView(getContext());
        Bitmap c = a.c(this.c.getWidth() / 2, this.c.getHeight() / 2, Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        canvas.scale(0.5f, 0.5f);
        this.c.draw(canvas);
        DkUtils.blurBitmap(c, 8);
        this.g.setImageBitmap(c);
        if (VERSION.SDK_INT >= 11) {
            this.g.setAlpha(0.2f);
        }
        this.g.setScaleType(ScaleType.FIT_XY);
        this.e.addView(this.f, new LayoutParams(-1, -1));
        this.e.addView(this.g, new LayoutParams(-1, -1));
    }

    protected boolean onBack() {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).goHome(null);
        return true;
    }
}
