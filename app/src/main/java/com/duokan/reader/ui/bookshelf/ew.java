package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;

import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.jq;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ew extends AsyncTask {
    List a = new ArrayList();
    final /* synthetic */ List b;
    final /* synthetic */ er c;
    private jq d;

    ew(er erVar, List list) {
        this.c = erVar;
        this.b = list;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.d = jq.a(this.c.getContext(), null, this.c.getResources().getString(j.general__shared__loading));
        this.d.dismiss();
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        this.c.b.a(this.a);
        this.d.dismiss();
    }

    protected Void a(Void... voidArr) {
        for (File file : this.b) {
            ImportedFileInfo importedFileInfo = new ImportedFileInfo(file.getAbsolutePath(), file.getName(), file.length());
            FileStatus fileStatus = file.isFile() ? ai.a().d(importedFileInfo.c()) == null ? FileStatus.UNSELECTED : FileStatus.IMPORTED : FileStatus.IMPORTED;
            importedFileInfo.a(fileStatus);
            this.a.add(importedFileInfo);
        }
        return null;
    }
}
