package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.et;
import com.duokan.reader.ui.general.DkWebListView.ListState;
import java.util.ArrayList;
import java.util.Iterator;

public class mv extends nm implements et {
    /* renamed from: a */
    private final mu f8969a = new mu(getContext());
    /* renamed from: c */
    private ArrayList<DkCloudNoteBookInfo> f8970c;
    /* renamed from: d */
    private final my f8971d = new my();

    public mv(IFeature mFeature) {
        super(mFeature, true);
        this.f8969a.getNoteSummaryListView().setOnItemClickListener(new mw(this));
        setContentView(this.f8969a);
        this.f8969a.getNoteSummaryListView().setAdapter(this.f8971d);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        DkUserReadingNotesManager.m5136a().m5152a((et) this);
    }

    protected void onDetachFromStub() {
        DkUserReadingNotesManager.m5136a().m5157b((et) this);
        super.onDetachFromStub();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m12317a(true);
        } else {
            this.f8971d.mo1691d();
        }
    }

    /* renamed from: f */
    public void mo967f() {
    }

    /* renamed from: a */
    public void mo958a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        if (dkCloudNoteBookInfo != null) {
            Object obj;
            Iterator it = this.f8970c.iterator();
            while (it.hasNext()) {
                obj = (DkCloudNoteBookInfo) it.next();
                if (TextUtils.equals(dkCloudNoteBookInfo.getBookUuid(), obj.getBookUuid())) {
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                this.f8970c.remove(obj);
                if (dkCloudNoteBookInfo.getNoteCount() > 0) {
                    this.f8970c.add(0, dkCloudNoteBookInfo);
                }
            }
            if (this.f8970c.size() != 0 || this.f8971d.m8789l() == ListState.EMPTY) {
                this.f8971d.mo1691d();
            } else {
                this.f8971d.m8785a(false);
            }
        }
    }

    /* renamed from: a */
    public void mo959a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
    }

    /* renamed from: a */
    private void m12317a(boolean z) {
        DkUserReadingNotesManager.m5136a().m5155a(true, z, new mx(this));
    }

    /* renamed from: a */
    private FileType m12313a(String str) {
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
