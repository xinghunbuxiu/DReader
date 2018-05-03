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
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0247i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadingStatisticsChartView extends View {
    /* renamed from: a */
    private final Paint f8230a;
    /* renamed from: b */
    private final Paint f8231b;
    /* renamed from: c */
    private final Paint f8232c;
    /* renamed from: d */
    private final Path f8233d;
    /* renamed from: e */
    private final ArrayList<Integer> f8234e;
    /* renamed from: f */
    private final ArrayList<Integer> f8235f;
    /* renamed from: g */
    private int[] f8236g;
    /* renamed from: h */
    private float f8237h;
    /* renamed from: i */
    private long f8238i;

    public ReadingStatisticsChartView(Context context) {
        this(context, null);
    }

    public ReadingStatisticsChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.f8233d = new Path();
        this.f8230a = new Paint();
        this.f8230a.setAntiAlias(true);
        this.f8230a.setStyle(Style.STROKE);
        this.f8230a.setStrokeCap(Cap.ROUND);
        this.f8230a.setStrokeJoin(Join.ROUND);
        this.f8231b = new Paint();
        this.f8231b.setAntiAlias(true);
        this.f8231b.setStyle(Style.FILL);
        this.f8232c = new Paint();
        this.f8232c.setAntiAlias(true);
        this.f8232c.setStyle(Style.FILL_AND_STROKE);
        this.f8232c.setTextSize((float) AnimUtils.m1932b(getContext(), 12.0f));
        this.f8234e = new ArrayList();
        this.f8235f = new ArrayList();
    }

    /* renamed from: a */
    public void m11372a(int[] iArr) {
        int i;
        this.f8236g = new int[25];
        for (i = 0; i < 24; i++) {
            this.f8236g[i] = iArr[i];
        }
        this.f8236g[24] = this.f8236g[0];
        this.f8237h = (float) this.f8236g[0];
        this.f8238i = 1;
        int i2 = this.f8236g[0] + this.f8236g[1];
        i = 0;
        while (i < 25) {
            if (this.f8237h < ((float) this.f8236g[i])) {
                this.f8237h = (float) this.f8236g[i];
            }
            if (i >= 2 && i <= 24 && this.f8236g[i] + this.f8236g[i - 1] > i2) {
                i2 = this.f8236g[i] + this.f8236g[i - 1];
                this.f8238i = (long) i;
            }
            i++;
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int b = AnimUtils.m1932b(getContext(), 20.0f);
        int width = getWidth();
        int measuredHeight = getMeasuredHeight();
        int b2 = AnimUtils.m1932b(getContext(), 20.0f);
        int b3 = AnimUtils.m1932b(getContext(), 20.0f);
        int i2 = (measuredHeight - b2) - b3;
        float f = (1.0f * ((float) width)) / 24.0f;
        float f2 = this.f8237h == 0.0f ? 0.0f : (1.0f * ((float) (i2 - (b * 2)))) / this.f8237h;
        float f3 = (float) ((b2 + i2) - b);
        if (this.f8237h != 0.0f) {
            this.f8232c.setTextAlign(Align.CENTER);
            this.f8232c.setColor(getResources().getColor(C0241c.general__shared__808c9d));
            String string = getResources().getString(C0247i.personal__experience_view__preference_reading_time);
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.f8238i - 1 < 0 ? 23 : this.f8238i - 1);
            objArr[1] = Long.valueOf(this.f8238i + 1 > 24 ? 1 : this.f8238i + 1);
            canvas.drawText(String.format(string, objArr), (float) (width / 2), (float) b2, this.f8232c);
        }
        this.f8234e.clear();
        this.f8235f.clear();
        for (i = 0; i <= 24; i++) {
            this.f8234e.add(Integer.valueOf((int) (((float) i) * f)));
            this.f8235f.add(Integer.valueOf((int) (f3 - (((float) this.f8236g[i]) * f2))));
        }
        List a = m11371a(this.f8234e);
        List a2 = m11371a(this.f8235f);
        this.f8230a.setStrokeWidth((float) AnimUtils.m1932b(getContext(), 4.0f));
        this.f8230a.setColor(getResources().getColor(C0241c.general__shared__92c182));
        this.f8233d.reset();
        this.f8233d.moveTo(((nb) a.get(0)).m12340a(0.0f), ((nb) a2.get(0)).m12340a(0.0f));
        for (b = 0; b < a.size(); b++) {
            for (i2 = 1; i2 <= 36; i2++) {
                float f4 = (1.0f * ((float) i2)) / 36.0f;
                this.f8233d.lineTo(((nb) a.get(b)).m12340a(f4), ((nb) a2.get(b)).m12340a(f4));
            }
        }
        canvas.drawPath(this.f8233d, this.f8230a);
        this.f8231b.setColor(getResources().getColor(C0241c.general__shared__daf1d4));
        this.f8233d.lineTo((float) width, f3 - (((float) this.f8236g[24]) * f2));
        this.f8233d.lineTo((float) width, (float) (measuredHeight - b3));
        this.f8233d.lineTo(0.0f, (float) (measuredHeight - b3));
        this.f8233d.close();
        canvas.drawPath(this.f8233d, this.f8231b);
        if (this.f8237h != 0.0f) {
            this.f8230a.setColor(getResources().getColor(C0241c.general__shared__ffffff));
            this.f8230a.setStrokeWidth((float) AnimUtils.m1932b(getContext(), 2.0f));
            this.f8231b.setColor(getResources().getColor(C0241c.general__shared__92c182));
            for (i = 6; i < 24; i += 6) {
                canvas.drawCircle(((float) i) * f, f3 - (((float) this.f8236g[i]) * f2), (float) AnimUtils.m1932b(getContext(), 4.0f), this.f8230a);
                canvas.drawCircle(((float) i) * f, f3 - (((float) this.f8236g[i]) * f2), (float) AnimUtils.m1932b(getContext(), 3.0f), this.f8231b);
            }
        }
        this.f8230a.setColor(getResources().getColor(C0241c.general__shared__92c182));
        this.f8230a.setStrokeWidth(1.0f);
        canvas.drawLine(0.0f, (float) (measuredHeight - b3), (float) width, (float) (measuredHeight - b3), this.f8230a);
        this.f8232c.setColor(getResources().getColor(C0241c.general__shared__aab2bc));
        this.f8232c.setTextAlign(Align.LEFT);
        canvas.drawText(String.format(getResources().getString(C0247i.personal__experience_view__time_formatter), new Object[]{Integer.valueOf(0)}), 0.0f, (float) measuredHeight, this.f8232c);
        this.f8232c.setTextAlign(Align.RIGHT);
        canvas.drawText(String.format(getResources().getString(C0247i.personal__experience_view__time_formatter), new Object[]{Integer.valueOf(24)}), (float) width, (float) measuredHeight, this.f8232c);
        this.f8232c.setTextAlign(Align.CENTER);
        for (i = 6; i < 24; i += 6) {
            canvas.drawText(String.format(getResources().getString(C0247i.personal__experience_view__time_formatter), new Object[]{Integer.valueOf(i)}), (float) ((width * i) / 24), (float) measuredHeight, this.f8232c);
        }
    }

    /* renamed from: a */
    private List<nb> m11371a(List<Integer> list) {
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
        List<nb> linkedList = new LinkedList();
        for (int i3 = 0; i3 < size; i3++) {
            linkedList.add(new nb(this, (float) ((Integer) list.get(i3)).intValue(), fArr3[i3], (((float) ((((Integer) list.get(i3 + 1)).intValue() - ((Integer) list.get(i3)).intValue()) * 3)) - (fArr3[i3] * 2.0f)) - fArr3[i3 + 1], fArr3[i3 + 1] + (((float) ((((Integer) list.get(i3)).intValue() - ((Integer) list.get(i3 + 1)).intValue()) * 2)) + fArr3[i3])));
        }
        return linkedList;
    }
}
