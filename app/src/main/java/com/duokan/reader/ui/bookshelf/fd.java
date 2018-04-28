package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.ja;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class fd extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    List<ImportedFileInfo> f6434a = new ArrayList();
    /* renamed from: b */
    final /* synthetic */ List f6435b;
    /* renamed from: c */
    final /* synthetic */ ey f6436c;
    /* renamed from: d */
    private ja f6437d;

    fd(ey eyVar, List list) {
        this.f6436c = eyVar;
        this.f6435b = list;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9596a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9597a((Void) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f6437d = ja.m10830a(this.f6436c.getContext(), null, this.f6436c.getResources().getString(C0258j.general__shared__loading));
        this.f6437d.dismiss();
    }

    /* renamed from: a */
    protected void m9597a(Void voidR) {
        super.onPostExecute(voidR);
        this.f6436c.f6421b.m9603a(this.f6434a);
        this.f6437d.dismiss();
    }

    /* renamed from: a */
    protected Void m9596a(Void... voidArr) {
        for (File file : this.f6435b) {
            ImportedFileInfo importedFileInfo = new ImportedFileInfo(file.getAbsolutePath(), file.getName(), file.length());
            FileStatus fileStatus = file.isFile() ? ai.m3980a().m3920d(importedFileInfo.m9084c()) == null ? FileStatus.UNSELECTED : FileStatus.IMPORTED : FileStatus.IMPORTED;
            importedFileInfo.m9083a(fileStatus);
            this.f6434a.add(importedFileInfo);
        }
        return null;
    }
}
