package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.util.AttributeSet;

import com.duokan.core.ui.bj;
import com.duokan.reader.ui.general.cw;
import com.duokan.reader.ui.general.cy;

public class FileExplorerFlipperView extends cw {
    protected /* synthetic */ bj e() {
        return f();
    }

    public FileExplorerFlipperView(Context context) {
        this(context, null);
    }

    public FileExplorerFlipperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected cy f() {
        return new fg(this);
    }
}
