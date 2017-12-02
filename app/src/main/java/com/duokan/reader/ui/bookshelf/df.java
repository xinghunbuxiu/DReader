package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.ReaderEnv.OnBookshelfItemStyleChangedListener;

import java.lang.ref.WeakReference;
import java.util.Iterator;

class df implements OnBookshelfItemStyleChangedListener {
    private df() {
    }

    public void onBookshelfItemStyleChanged(BookshelfItemStyle bookshelfItemStyle) {
        Iterator it = cz.d.iterator();
        while (it.hasNext()) {
            cz czVar = (cz) ((WeakReference) it.next()).get();
            if (czVar != null) {
                czVar.a();
            }
        }
    }
}
