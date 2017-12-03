package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DynamicImageView extends ImageView {
    public DynamicImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int size = MeasureSpec.getSize(i);
            setMeasuredDimension(size, (int) Math.ceil((double) ((((float) size) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()))));
            return;
        }
        super.onMeasure(i, i2);
    }
}
