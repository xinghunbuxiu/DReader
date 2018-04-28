package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.ReaderEnv.OnBookshelfItemStyleChangedListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class dm implements OnBookshelfItemStyleChangedListener {
    private dm() {
    }

    public void onBookshelfItemStyleChanged(BookshelfItemStyle bookshelfItemStyle) {
        Iterator it = de.f6048d.iterator();
        while (it.hasNext()) {
            de deVar = (de) ((WeakReference) it.next()).get();
            if (deVar != null) {
                deVar.mo1635a();
            }
        }
    }
}
