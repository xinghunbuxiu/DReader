package com.duokan.reader.ui.general;

import com.duokan.reader.common.bitmap.BitmapsRecycler;
import com.duokan.reader.common.bitmap.BitmapsRecycler.RecycleReason;

class kl implements BitmapsRecycler {
    private kl() {
    }

    public void a(RecycleReason recycleReason) {
        deprecatedDkTextView.i();
    }
}
