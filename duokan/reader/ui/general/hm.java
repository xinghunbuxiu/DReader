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

public class hm extends InsetDrawable {
    private final Paint a;
    private final Path b;
    private final float[] c;
    private final int d;

    public hm(Drawable drawable, float f) {
        this(drawable, f, 15);
    }

    public hm(Drawable drawable, float f, int i) {
        super(drawable, 0);
        this.c = new float[8];
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.b = new Path();
        this.b.setFillType(FillType.INVERSE_WINDING);
        this.d = i;
        Arrays.fill(this.c, 0.0f);
        if ((this.d & 15) == 15) {
            Arrays.fill(this.c, f);
            return;
        }
        if ((this.d & 1) == 1) {
            Arrays.fill(this.c, 0, 2, f);
        }
        if ((this.d & 2) == 2) {
            Arrays.fill(this.c, 2, 4, f);
        }
        if ((this.d & 8) == 8) {
            Arrays.fill(this.c, 4, 6, f);
        }
        if ((this.d & 4) == 4) {
            Arrays.fill(this.c, 6, 8, f);
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.b.addRoundRect(new RectF(0.0f, 0.0f, (float) (i3 - i), (float) (i4 - i2)), this.c, Direction.CW);
    }

    public void draw(Canvas canvas) {
        int saveLayerAlpha = canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), 255, 4);
        super.draw(canvas);
        if (this.b != null) {
            canvas.drawPath(this.b, this.a);
        }
        canvas.restoreToCount(saveLayerAlpha);
    }
}
