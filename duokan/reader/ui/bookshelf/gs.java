package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.b.d;
import com.duokan.core.ui.HatGridView;
import com.duokan.reader.ui.general.ReaderUi;

public class gs extends HatGridView {
    public gs(Context context) {
        super(context);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.general__shared__cover_grid_horz_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.general__shared__cover_grid_vert_padding);
        setColumnSpacing(getResources().getDimensionPixelSize(d.general__shared__cover_grid_space));
        setRowSpacing(getResources().getDimensionPixelSize(d.general__shared__cover_grid_row_space));
        b(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 0) {
            setNumColumns(ReaderUi.c(getContext(), (size - getGridPaddingLeft()) - getGridPaddingRight()));
        } else {
            setNumColumns(3);
        }
        super.onMeasure(i, i2);
    }
}
