package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.core.sys.TaskHandler;

class da implements Callback {
    final /* synthetic */ cz a;

    da(cz czVar) {
        this.a = czVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        TaskHandler.c(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        TaskHandler.PostTask(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidate();
    }
}
