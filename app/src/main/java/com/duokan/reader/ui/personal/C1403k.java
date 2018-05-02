package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.io.FileUtil;
import com.duokan.reader.ReaderEnv;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.ui.personal.k */
public class C1403k extends ActivatedController {
    /* renamed from: a */
    private C1405m f8800a = new C1405m(getContext());

    public C1403k(IFeature mFeature) {
        super(mFeature);
        this.f8800a.setStorages(m12053a());
        setContentView(this.f8800a);
    }

    /* renamed from: a */
    private C1404l[] m12053a() {
        LinkedList linkedList = new LinkedList();
        try {
            String canonicalPath = ReaderEnv.get().getSecondaryFilesDirectory().getParentFile().getCanonicalPath();
            File[] fileArr = (File[]) FileUtil.getAllFile(getContext()).toArray(new File[0]);
            for (File file : fileArr) {
                C1404l c1404l = new C1404l(this);
                c1404l.f8850a = file.getName();
                c1404l.f8851b = file.getAbsolutePath();
                c1404l.f8852c = file.getTotalSpace();
                c1404l.f8853d = file.getFreeSpace();
                c1404l.f8854e = file.getCanonicalPath().equalsIgnoreCase(canonicalPath);
                linkedList.add(c1404l);
            }
            return (C1404l[]) linkedList.toArray(new C1404l[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return (C1404l[]) linkedList.toArray(new C1404l[0]);
        }
    }
}
