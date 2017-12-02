package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.duokan.core.ui.dv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadingStatisticsChartView extends View {
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private final Path d;
    private final ArrayList e;
    private final ArrayList f;
    private int[] g;
    private float h;
    private long i;

    public ReadingStatisticsChartView(Context context) {
        this(context, null);
    }

    public ReadingStatisticsChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.d = new Path();
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeCap(Cap.ROUND);
        this.a.setStrokeJoin(Join.ROUND);
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.FILL);
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setStyle(Style.FILL_AND_STROKE);
        this.c.setTextSize((float) dv.b(getContext(), 12.0f));
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    public void a(int[] iArr) {
        int i;
        this.g = new int[25];
        for (i = 0; i < 24; i++) {
            this.g[i] = iArr[i];
        }
        this.g[24] = this.g[0];
        this.h = (float) this.g[0];
        this.i = 1;
        int i2 = this.g[0] + this.g[1];
        i = 0;
        while (i < 25) {
            if (this.h < ((float) this.g[i])) {
                this.h = (float) this.g[i];
            }
            if (i >= 2 && i <= 24 && this.g[i] + this.g[i - 1] > r0) {
                i2 = this.g[i] + this.g[i - 1];
                this.i = (long) i;
            }
            i++;
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int b = dv.b(getContext(), 20.0f);
        int width = getWidth();
        int measuredHeight = getMeasuredHeight();
        int b2 = dv.b(getContext(), 20.0f);
        int b3 = dv.b(getContext(), 20.0f);
        int i2 = (measuredHeight - b2) - b3;
        float f = (1.0f * ((float) width)) / 24.0f;
        float f2 = this.h == 0.0f ? 0.0f : (1.0f * ((float) (i2 - (b * 2)))) / this.h;
        float f3 = (float) ((b2 + i2) - b);
        if (this.h != 0.0f) {
            this.c.setTextAlign(Align.CENTER);
            this.c.setColor(getResources().getColor(c.general__shared__808c9d));
            String string = getResources().getString(i.personal__experience_view__preference_reading_time);
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.i - 1 < 0 ? 23 : this.i - 1);
            objArr[1] = Long.valueOf(this.i + 1 > 24 ? 1 : this.i + 1);
            canvas.drawText(String.format(string, objArr), (float) (width / 2), (float) b2, this.c);
        }
        this.e.clear();
        this.f.clear();
        for (i = 0; i <= 24; i++) {
            this.e.add(Integer.valueOf((int) (((float) i) * f)));
            this.f.add(Integer.valueOf((int) (f3 - (((float) this.g[i]) * f2))));
        }
        List a = a(this.e);
        List a2 = a(this.f);
        this.a.setStrokeWidth((float) dv.b(getContext(), 4.0f));
        this.a.setColor(getResources().getColor(c.general__shared__92c182));
        this.d.reset();
        this.d.moveTo(((mn) a.get(0)).a(0.0f), ((mn) a2.get(0)).a(0.0f));
        for (b = 0; b < a.size(); b++) {
            for (i2 = 1; i2 <= 36; i2++) {
                float f4 = (1.0f * ((float) i2)) / 36.0f;
                this.d.lineTo(((mn) a.get(b)).a(f4), ((mn) a2.get(b)).a(f4));
            }
        }
        canvas.drawPath(this.d, this.a);
        this.b.setColor(getResources().getColor(c.general__shared__daf1d4));
        this.d.lineTo((float) width, f3 - (((float) this.g[24]) * f2));
        this.d.lineTo((float) width, (float) (measuredHeight - b3));
        this.d.lineTo(0.0f, (float) (measuredHeight - b3));
        this.d.close();
        canvas.drawPath(this.d, this.b);
        if (this.h != 0.0f) {
            this.a.setColor(getResources().getColor(c.general__shared__ffffff));
            this.a.setStrokeWidth((float) dv.b(getContext(), 2.0f));
            this.b.setColor(getResources().getColor(c.general__shared__92c182));
            for (i = 6; i < 24; i += 6) {
                canvas.drawCircle(((float) i) * f, f3 - (((float) this.g[i]) * f2), (float) dv.b(getContext(), 4.0f), this.a);
                canvas.drawCircle(((float) i) * f, f3 - (((float) this.g[i]) * f2), (float) dv.b(getContext(), 3.0f), this.b);
            }
        }
        this.a.setColor(getResources().getColor(c.general__shared__92c182));
        this.a.setStrokeWidth(1.0f);
        canvas.drawLine(0.0f, (float) (measuredHeight - b3), (float) width, (float) (measuredHeight - b3), this.a);
        this.c.setColor(getResources().getColor(c.general__shared__aab2bc));
        this.c.setTextAlign(Align.LEFT);
        canvas.drawText(String.format(getResources().getString(i.personal__experience_view__time_formatter), new Object[]{Integer.valueOf(0)}), 0.0f, (float) measuredHeight, this.c);
        this.c.setTextAlign(Align.RIGHT);
        canvas.drawText(String.format(getResources().getString(i.personal__experience_view__time_formatter), new Object[]{Integer.valueOf(24)}), (float) width, (float) measuredHeight, this.c);
        this.c.setTextAlign(Align.CENTER);
        for (i = 6; i < 24; i += 6) {
            canvas.drawText(String.format(getResources().getString(i.personal__experience_view__time_formatter), new Object[]{Integer.valueOf(i)}), (float) ((width * i) / 24), (float) measuredHeight, this.c);
        }
    }

    private List a(List list) {
        int i;
        int i2 = 1;
        int size = list.size() - 1;
        float[] fArr = new float[(size + 1)];
        float[] fArr2 = new float[(size + 1)];
        float[] fArr3 = new float[(size + 1)];
        fArr[0] = 0.5f;
        for (i = 1; i < size; i++) {
            fArr[i] = 1.0f / (4.0f - fArr[i - 1]);
        }
        fArr[size] = 1.0f / (2.0f - fArr[size - 1]);
        fArr2[0] = ((float) ((((Integer) list.get(1)).intValue() - ((Integer) list.get(0)).intValue()) * 3)) * fArr[0];
        while (i2 < size) {
            fArr2[i2] = (((float) ((((Integer) list.get(i2 + 1)).intValue() - ((Integer) list.get(i2 - 1)).intValue()) * 3)) - fArr2[i2 - 1]) * fArr[i2];
            i2++;
        }
        fArr2[size] = (((float) ((((Integer) list.get(size)).intValue() - ((Integer) list.get(size - 1)).intValue()) * 3)) - fArr2[size - 1]) * fArr[size];
        fArr3[size] = fArr2[size];
        for (i = size - 1; i >= 0; i--) {
            fArr3[i] = fArr2[i] - (fArr[i] * fArr3[i + 1]);
        }
        List linkedList = new LinkedList();
        for (int i3 = 0; i3 < size; i3++) {
            linkedList.add(new mn(this, (float) ((Integer) list.get(i3)).intValue(), fArr3[i3], (((float) ((((Integer) list.get(i3 + 1)).intValue() - ((Integer) list.get(i3)).intValue()) * 3)) - (fArr3[i3] * 2.0f)) - fArr3[i3 + 1], fArr3[i3 + 1] + (((float) ((((Integer) list.get(i3)).intValue() - ((Integer) list.get(i3 + 1)).intValue()) * 2)) + fArr3[i3])));
        }
        return linkedList;
    }
}
