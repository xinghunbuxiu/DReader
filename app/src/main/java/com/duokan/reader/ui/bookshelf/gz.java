package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View.MeasureSpec;
import com.duokan.core.ui.HatGridView;
import com.duokan.p023b.C0242d;
import com.duokan.reader.ui.general.ReaderUi;

public class gz extends HatGridView {
    public gz(Context context) {
        super(context);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0242d.general__shared__cover_grid_horz_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0242d.general__shared__cover_grid_vert_padding);
        setColumnSpacing(getResources().getDimensionPixelSize(C0242d.general__shared__cover_grid_space));
        setRowSpacing(getResources().getDimensionPixelSize(C0242d.general__shared__cover_grid_row_space));
        m1250b(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 0) {
            setNumColumns(ReaderUi.m10165c(getContext(), (size - getGridPaddingLeft()) - getGridPaddingRight()));
        } else {
            setNumColumns(3);
        }
        super.onMeasure(i, i2);
    }
}
