package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import com.duokan.common.FileTypeRecognizer;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ui.general.ak;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FileScanTask extends AsyncTask {
    static final /* synthetic */ boolean b = (!FileScanTask.class.desiredAssertionStatus());
    List a = new LinkedList();
    private Context c = null;
    private ak d;
    private gm e = null;
    private TextView f;
    private TextView g;
    private TextView h;
    private Integer[] i;
    private File[] j = null;
    private ErrorCode k = ErrorCode.OTHER;

    public enum ErrorCode {
        OK,
        FILENOTFOUND,
        IOEXCEPTION,
        SDCARDBUSY,
        CANCELED,
        OTHER
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((List) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public void a(Context context, gm gmVar, File[] fileArr) {
        if (b || context != null) {
            this.c = context;
            this.e = gmVar;
            this.j = fileArr;
            return;
        }
        throw new AssertionError();
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.i = new Integer[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)};
        this.d = new ak(this.c);
        this.d.setExtraContentResource(h.bookshelf__scanning_dialog_view);
        this.f = (TextView) this.d.findViewById(g.scanning_info);
        this.g = (TextView) this.d.findViewById(g.scanning_type);
        this.h = (TextView) this.d.findViewById(g.scanning_cancel);
        this.h.setText(j.general__shared__stop_scan);
        this.h.setOnClickListener(new gj(this));
        this.d.open(new gk(this));
        this.a.clear();
    }

    protected void a(List list) {
        super.onPostExecute(list);
        if (this.d.isShowing()) {
            this.d.dismiss();
        }
        if (this.e != null) {
            this.e.a(list, this.k);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        if (this.d.isShowing()) {
            this.d.dismiss();
        }
        if (this.e != null) {
            this.e.a(this.a, ErrorCode.CANCELED);
        }
    }

    protected List a(String... strArr) {
        if (DkPublic.isSDCardBusy() || this.j == null || this.j.length == 0) {
            this.k = ErrorCode.SDCARDBUSY;
            return this.a;
        }
        FileFilter glVar = new gl(this);
        Stack stack = new Stack();
        for (Object push : this.j) {
            stack.push(push);
        }
        while (!stack.isEmpty()) {
            if (isCancelled()) {
                this.k = ErrorCode.CANCELED;
                return this.a;
            }
            publishProgress(this.i);
            File file = (File) stack.pop();
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    continue;
                } else {
                    gt gtVar = new gt(file.getPath(), file.getName(), file.length());
                    for (File file2 : listFiles) {
                        if (isCancelled()) {
                            if (gtVar.a() > 0) {
                                this.a.add(gtVar);
                                a(gtVar);
                            }
                            this.k = ErrorCode.CANCELED;
                            return this.a;
                        }
                        if (file2.isHidden() || !file2.isDirectory()) {
                            Integer[] numArr = this.i;
                            Integer num = numArr[0];
                            numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                            if (glVar.accept(file2)) {
                                gtVar.a(new ImportedFileInfo(file2.getPath(), file2.getName(), file2.length()));
                                int ordinal = FileTypeRecognizer.a(file2.getPath()).ordinal();
                                if (ordinal > 0 && ordinal < this.i.length) {
                                    numArr = this.i;
                                    num = numArr[ordinal];
                                    numArr[ordinal] = Integer.valueOf(numArr[ordinal].intValue() + 1);
                                }
                            }
                        } else {
                            stack.push(file2);
                        }
                    }
                    if (gtVar.a() > 0) {
                        this.a.add(gtVar);
                        a(gtVar);
                    }
                }
            }
        }
        this.k = ErrorCode.OK;
        return this.a;
    }

    protected void a(Integer... numArr) {
        if (numArr[0].intValue() == -1) {
            this.f.setText(this.c.getString(j.scanning_write_db));
            this.h.setEnabled(false);
            return;
        }
        this.f.setText(Html.fromHtml(String.format(this.c.getString(j.scanning_notyfy), new Object[]{numArr[0]})));
        this.g.setText(Html.fromHtml(String.format(this.c.getString(j.scanning_info), new Object[]{numArr[1], numArr[2], numArr[3]})));
    }

    private void a(gt gtVar) {
        if (this.e != null) {
            this.e.a(gtVar);
        }
    }

    private List a() {
        List linkedList = new LinkedList();
        for (File file : a.a(this.c)) {
            linkedList.add(file.getAbsolutePath() + File.separator + "DuoKan" + File.separator + "Downloads" + File.separator);
            linkedList.add(file.getAbsolutePath() + File.separator + "DuoKanHD" + File.separator + "Downloads" + File.separator);
            linkedList.add(file.getAbsolutePath() + File.separator + "MiReader" + File.separator + "Downloads" + File.separator);
        }
        return linkedList;
    }
}
