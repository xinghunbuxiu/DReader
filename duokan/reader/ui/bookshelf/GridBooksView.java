package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.util.AttributeSet;

import com.duokan.b.d;
import com.duokan.core.ui.GridItemsView;
import com.duokan.reader.ui.general.ReaderUi;

public class GridBooksView extends GridItemsView {
    public GridBooksView(Context context) {
        super(context, null);
    }

    public GridBooksView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.general__shared__cover_grid_horz_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.general__shared__cover_grid_vert_padding);
        setDesiredColumnSpacing(getResources().getDimensionPixelSize(d.general__shared__cover_grid_space));
        setRowSpacing(getResources().getDimensionPixelSize(d.general__shared__cover_grid_row_space));
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 0) {
            setNumColumns(ReaderUi.c(getContext(), (size - getPaddingLeft()) - getPaddingRight()));
        } else {
            setNumColumns(3);
        }
        super.onMeasure(i, i2);
    }
}
