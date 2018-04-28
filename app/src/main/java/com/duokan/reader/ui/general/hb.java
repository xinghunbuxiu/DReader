package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import java.util.Arrays;

public class hb extends InsetDrawable {
    /* renamed from: a */
    private final Paint f7318a;
    /* renamed from: b */
    private final Path f7319b;
    /* renamed from: c */
    private final float[] f7320c;
    /* renamed from: d */
    private final int f7321d;

    public hb(Drawable drawable, float f) {
        this(drawable, f, 15);
    }

    public hb(Drawable drawable, float f, int i) {
        super(drawable, 0);
        this.f7320c = new float[8];
        this.f7318a = new Paint();
        this.f7318a.setAntiAlias(true);
        this.f7318a.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f7319b = new Path();
        this.f7319b.setFillType(FillType.INVERSE_WINDING);
        this.f7321d = i;
        Arrays.fill(this.f7320c, 0.0f);
        if ((this.f7321d & 15) == 15) {
            Arrays.fill(this.f7320c, f);
            return;
        }
        if ((this.f7321d & 1) == 1) {
            Arrays.fill(this.f7320c, 0, 2, f);
        }
        if ((this.f7321d & 2) == 2) {
            Arrays.fill(this.f7320c, 2, 4, f);
        }
        if ((this.f7321d & 8) == 8) {
            Arrays.fill(this.f7320c, 4, 6, f);
        }
        if ((this.f7321d & 4) == 4) {
            Arrays.fill(this.f7320c, 6, 8, f);
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f7319b.addRoundRect(new RectF(0.0f, 0.0f, (float) (i3 - i), (float) (i4 - i2)), this.f7320c, Direction.CW);
    }

    public void draw(Canvas canvas) {
        int saveLayerAlpha = canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), 255, 4);
        super.draw(canvas);
        if (this.f7319b != null) {
            canvas.drawPath(this.f7319b, this.f7318a);
        }
        canvas.restoreToCount(saveLayerAlpha);
    }
}
