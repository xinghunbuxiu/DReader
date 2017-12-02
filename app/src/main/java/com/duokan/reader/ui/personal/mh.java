package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.app.y;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.fl;
import com.duokan.reader.ui.general.DkWebListView.ListState;

import java.util.ArrayList;
import java.util.Iterator;

public class mh extends my implements fl {
    private final mg a = new mg(getContext());
    private ArrayList c;
    private final mk d = new mk();

    public mh(y yVar) {
        super(yVar, true);
        this.a.getNoteSummaryListView().setOnItemClickListener(new mi(this));
        setContentView(this.a);
        this.a.getNoteSummaryListView().setAdapter(this.d);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        DkUserReadingNotesManager.a().a((fl) this);
    }

    protected void onDetachFromStub() {
        DkUserReadingNotesManager.a().b((fl) this);
        super.onDetachFromStub();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a(true);
        } else {
            this.d.d();
        }
    }

    public void f() {
    }

    public void a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        if (dkCloudNoteBookInfo != null) {
            Object obj;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                obj = (DkCloudNoteBookInfo) it.next();
                if (TextUtils.equals(dkCloudNoteBookInfo.getBookUuid(), obj.getBookUuid())) {
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                this.c.remove(obj);
                if (dkCloudNoteBookInfo.getNoteCount() > 0) {
                    this.c.add(0, dkCloudNoteBookInfo);
                }
            }
            if (this.c.size() != 0 || this.d.l() == ListState.EMPTY) {
                this.d.d();
            } else {
                this.d.a(false);
            }
        }
    }

    public void a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
    }

    private void a(boolean z) {
        DkUserReadingNotesManager.a().a(true, z, new mj(this));
    }

    private FileType a(String str) {
        if (str.equals("EPUB") || str.equals("epub")) {
            return FileType.EPUB;
        }
        if (str.equals("TXT") || str.equals("txt")) {
            return FileType.TXT;
        }
        if (str.equals("PDF") || str.equals("pdf")) {
            return FileType.PDF;
        }
        return FileType.UNSUPPORTED;
    }
}
