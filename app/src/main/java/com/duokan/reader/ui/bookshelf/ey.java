package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.duokan.common.C0259a;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.HatGridView;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.eg;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ey extends LinearLayout {
    /* renamed from: i */
    private static final Comparator<File> f6419i = new ez();
    /* renamed from: a */
    private final HatGridView f6420a;
    /* renamed from: b */
    private final fe f6421b;
    /* renamed from: c */
    private final DkLabelView f6422c;
    /* renamed from: d */
    private final String f6423d;
    /* renamed from: e */
    private String f6424e;
    /* renamed from: f */
    private final gm f6425f;
    /* renamed from: g */
    private fi f6426g;
    /* renamed from: h */
    private Map<String, Integer> f6427h = new HashMap();

    public ey(Context context, Runnable runnable) {
        super(context);
        setOrientation(1);
        this.f6421b = new fe();
        this.f6420a = new HatGridView(context);
        this.f6420a.setAdapter(this.f6421b);
        this.f6420a.setOnItemClickListener(new fa(this));
        eg.m10555a(this.f6420a);
        this.f6425f = new gm(context);
        this.f6425f.setPathGalleryListener(new fb(this));
        View inflate = LayoutInflater.from(context).inflate(C0256h.bookshelf__file_add_view, this, false);
        this.f6422c = (DkLabelView) inflate.findViewById(C0255g.bookshelf__file_add_view__text);
        this.f6422c.setOnClickListener(new fc(this, runnable));
        this.f6423d = getContext().getString(C0258j.import_confirm);
        this.f6422c.setText(String.format(this.f6423d, new Object[]{Integer.valueOf(0)}));
        addView(this.f6425f, new LayoutParams(-1, -2));
        addView(this.f6420a, new LayoutParams(-1, 0, 1.0f));
        addView(inflate, new LayoutParams(-1, -2));
        String lastBrowserPath = getLastBrowserPath();
        this.f6425f.setPath(lastBrowserPath);
        setData(m9582b(lastBrowserPath));
        this.f6425f.setBackgroundColor(getResources().getColor(C0252d.general__shared__ebebeb));
        setBackgroundColor(getResources().getColor(C0252d.general__shared__f7f7f7));
    }

    public void setSelectBrowserFiles(boolean z) {
        this.f6421b.m9604a(z);
    }

    public void setSelectionListener(fi fiVar) {
        this.f6426g = fiVar;
    }

    /* renamed from: a */
    public boolean m9591a() {
        File parentFile = new File(this.f6424e).getParentFile();
        if (parentFile == null || !parentFile.canRead()) {
            return false;
        }
        this.f6425f.setPath(parentFile.getAbsolutePath());
        setData(m9582b(parentFile.getAbsolutePath()));
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i && this.f6420a != null) {
            this.f6420a.setNumColumns(eg.m10551a(getContext(), i));
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9583b();
    }

    /* renamed from: a */
    private void m9579a(String str) {
        if (this.f6424e != null) {
            if (this.f6427h.containsKey(this.f6424e)) {
                this.f6427h.remove(this.f6424e);
            }
            if (!this.f6424e.contains(str) && this.f6427h.containsKey(str)) {
                this.f6427h.remove(str);
            }
            this.f6427h.put(this.f6424e, Integer.valueOf(this.f6420a.getGridScrollY()));
        }
    }

    /* renamed from: b */
    private List<File> m9582b(String str) {
        m9579a(str);
        this.f6424e = str;
        List arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, f6419i);
            for (File file : listFiles) {
                if (file.isDirectory() && file.canRead()) {
                    arrayList.add(file);
                } else if (m9580a(file)) {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    private String getLastBrowserPath() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String prefString = ReaderEnv.get().getPrefString(PrivatePref.BOOKSHELF, "file_browser_path", absolutePath);
        if (TextUtils.isEmpty(prefString)) {
            prefString = absolutePath;
        }
        prefString = m9585c(prefString);
        if (TextUtils.isEmpty(prefString)) {
            return m9585c(absolutePath);
        }
        List b = m9582b(prefString);
        if (!new File(prefString).canRead() || b == null || b.isEmpty()) {
            return m9585c(absolutePath);
        }
        return prefString;
    }

    /* renamed from: c */
    private String m9585c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith(File.separator)) {
            str = File.separator + str;
        }
        while (!new File(str).exists()) {
            str = new File(str).getParent();
        }
        return str;
    }

    /* renamed from: b */
    private void m9583b() {
        ReaderEnv.get().setPrefString(PrivatePref.BOOKSHELF, "file_browser_path", this.f6424e);
        ReaderEnv.get().commitPrefs();
    }

    /* renamed from: a */
    private boolean m9580a(File file) {
        return (file == null || FileType.UNSUPPORTED == FileTypeRecognizer.m567a(file.getAbsolutePath())) ? false : true;
    }

    /* renamed from: a */
    private void m9576a(ImportedFileInfo importedFileInfo) {
        File file = new File(importedFileInfo.m9084c());
        if (file.isDirectory() && file.canRead()) {
            this.f6425f.setPath(file.getAbsolutePath());
            setData(m9582b(file.getAbsolutePath()));
        } else if (file.isFile() && file.canRead()) {
            ((fm) AppContext.getAppContext(getContext()).queryFeature(fm.class)).mo1693a(file.getAbsolutePath());
        }
    }

    private void setData(List<File> list) {
        C0259a.m568a(new fd(this, list), new Void[0]);
    }
}
