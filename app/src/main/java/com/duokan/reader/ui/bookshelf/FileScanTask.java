package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.io.FileUtil;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ui.general.ak;
import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FileScanTask extends AsyncTask<String, Integer, List<ha>> {
    /* renamed from: b */
    static final /* synthetic */ boolean f6020b = (!FileScanTask.class.desiredAssertionStatus());
    /* renamed from: a */
    List<ha> f6021a = new LinkedList();
    /* renamed from: c */
    private Context f6022c = null;
    /* renamed from: d */
    private ak f6023d;
    /* renamed from: e */
    private gt f6024e = null;
    /* renamed from: f */
    private TextView f6025f;
    /* renamed from: g */
    private TextView f6026g;
    /* renamed from: h */
    private TextView f6027h;
    /* renamed from: i */
    private Integer[] f6028i;
    /* renamed from: j */
    private File[] f6029j = null;
    /* renamed from: k */
    private ErrorCode f6030k = ErrorCode.OTHER;

    public enum ErrorCode {
        OK,
        FILENOTFOUND,
        IOEXCEPTION,
        SDCARDBUSY,
        CANCELED,
        OTHER
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9079a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9081a((List) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m9082a((Integer[]) objArr);
    }

    /* renamed from: a */
    public void m9080a(Context context, gt gtVar, File[] fileArr) {
        if (f6020b || context != null) {
            this.f6022c = context;
            this.f6024e = gtVar;
            this.f6029j = fileArr;
            return;
        }
        throw new AssertionError();
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f6028i = new Integer[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)};
        this.f6023d = new ak(this.f6022c);
        this.f6023d.setExtraContentResource(C0256h.bookshelf__scanning_dialog_view);
        this.f6025f = (TextView) this.f6023d.findViewById(C0255g.scanning_info);
        this.f6026g = (TextView) this.f6023d.findViewById(C0255g.scanning_type);
        this.f6027h = (TextView) this.f6023d.findViewById(C0255g.scanning_cancel);
        this.f6027h.setText(C0258j.general__shared__stop_scan);
        this.f6027h.setOnClickListener(new gq(this));
        this.f6023d.open(new gr(this));
        this.f6021a.clear();
    }

    /* renamed from: a */
    protected void m9081a(List<ha> list) {
        super.onPostExecute(list);
        if (this.f6023d.isShowing()) {
            this.f6023d.dismiss();
        }
        if (this.f6024e != null) {
            this.f6024e.mo1709a(list, this.f6030k);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        if (this.f6023d.isShowing()) {
            this.f6023d.dismiss();
        }
        if (this.f6024e != null) {
            this.f6024e.mo1709a(this.f6021a, ErrorCode.CANCELED);
        }
    }

    /* renamed from: a */
    protected List<ha> m9079a(String... strArr) {
        if (DkPublic.isSDCardBusy() || this.f6029j == null || this.f6029j.length == 0) {
            this.f6030k = ErrorCode.SDCARDBUSY;
            return this.f6021a;
        }
        FileFilter gsVar = new gs(this);
        Stack stack = new Stack();
        for (Object push : this.f6029j) {
            stack.push(push);
        }
        while (!stack.isEmpty()) {
            if (isCancelled()) {
                this.f6030k = ErrorCode.CANCELED;
                return this.f6021a;
            }
            publishProgress(this.f6028i);
            File file = (File) stack.pop();
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    continue;
                } else {
                    ha haVar = new ha(file.getPath(), file.getName(), file.length());
                    for (File file2 : listFiles) {
                        if (isCancelled()) {
                            if (haVar.m9760a() > 0) {
                                this.f6021a.add(haVar);
                                m9078a(haVar);
                            }
                            this.f6030k = ErrorCode.CANCELED;
                            return this.f6021a;
                        }
                        if (file2.isHidden() || !file2.isDirectory()) {
                            Integer[] numArr = this.f6028i;
                            Integer num = numArr[0];
                            numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                            if (gsVar.accept(file2)) {
                                haVar.m9761a(new ImportedFileInfo(file2.getPath(), file2.getName(), file2.length()));
                                int ordinal = FileTypeRecognizer.m567a(file2.getPath()).ordinal();
                                if (ordinal > 0 && ordinal < this.f6028i.length) {
                                    numArr = this.f6028i;
                                    num = numArr[ordinal];
                                    numArr[ordinal] = Integer.valueOf(numArr[ordinal].intValue() + 1);
                                }
                            }
                        } else {
                            stack.push(file2);
                        }
                    }
                    if (haVar.m9760a() > 0) {
                        this.f6021a.add(haVar);
                        m9078a(haVar);
                    }
                }
            }
        }
        this.f6030k = ErrorCode.OK;
        return this.f6021a;
    }

    /* renamed from: a */
    protected void m9082a(Integer... numArr) {
        if (numArr[0].intValue() == -1) {
            this.f6025f.setText(this.f6022c.getString(C0258j.scanning_write_db));
            this.f6027h.setEnabled(false);
            return;
        }
        this.f6025f.setText(Html.fromHtml(String.format(this.f6022c.getString(C0258j.scanning_notyfy), new Object[]{numArr[0]})));
        this.f6026g.setText(Html.fromHtml(String.format(this.f6022c.getString(C0258j.scanning_info), new Object[]{numArr[1], numArr[2], numArr[3]})));
    }

    /* renamed from: a */
    private void m9078a(ha haVar) {
        if (this.f6024e != null) {
            this.f6024e.mo1708a(haVar);
        }
    }

    /* renamed from: a */
    private List<String> m9076a() {
        List linkedList = new LinkedList();
        for (File file : FileUtil.m774a(this.f6022c)) {
            linkedList.add(file.getAbsolutePath() + File.separator + "DuoKan" + File.separator + "Downloads" + File.separator);
            linkedList.add(file.getAbsolutePath() + File.separator + "DuoKanHD" + File.separator + "Downloads" + File.separator);
            linkedList.add(file.getAbsolutePath() + File.separator + "MiReader" + File.separator + "Downloads" + File.separator);
        }
        return linkedList;
    }
}
