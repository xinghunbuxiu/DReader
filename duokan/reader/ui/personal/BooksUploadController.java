package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.bookshelf.bj;
import com.duokan.reader.ui.surfing.af;

import java.util.List;

public class BooksUploadController extends ActivatedController implements bj {
    private final com.duokan.reader.domain.micloud.bj a;
    private t b;
    private final List c;
    private List d;

    public enum UploadBookStatus {
        UNSELECTED,
        SELECTED,
        UPLOADED,
        NOTEXIST
    }

    public com.duokan.reader.domain.micloud.bj a() {
        return this.a;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            new q().execute(new String[0]);
        }
        ((af) getContext().queryFeature(af.class)).n();
    }

    protected void onDeactive() {
        super.onDeactive();
        ((af) getContext().queryFeature(af.class)).m();
    }
}
