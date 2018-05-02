package com.duokan.core.sys;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicReference;

class aw extends RandomAccessFile {
    public final String a;
    public final AtomicReference b = new AtomicReference();
    public int c = 0;

    public aw(File file, String str) {
        super(file, str);
        this.a = str;
    }
}
