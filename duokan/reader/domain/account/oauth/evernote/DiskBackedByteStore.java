package com.duokan.reader.domain.account.oauth.evernote;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DiskBackedByteStore extends OutputStream {
    protected ByteArrayOutputStream byteArray = null;
    protected OutputStream current = null;
    protected Exception exception;
    protected File file;
    protected FileInputStream fileInputStream = null;
    protected FileOutputStream fileoutputStream = null;
    protected int maxMemory;
    protected int size = 0;
    protected File tempPath;

    public DiskBackedByteStore(File file, int i) {
        this.file = file;
        this.maxMemory = i;
    }

    public DiskBackedByteStore(File file, String str, int i) {
        file.mkdirs();
        this.tempPath = file;
        this.file = makeTempFile();
        this.maxMemory = i;
    }

    protected File makeTempFile() {
        return new File(this.tempPath, (Math.random() * 9.223372036854776E18d) + ".tft");
    }

    public void write(byte[] bArr, int i, int i2) {
        initBuffers();
        try {
            if (isSwapRequired(i2)) {
                swapToDisk();
            }
            this.size += i2;
            this.current.write(bArr, i, i2);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    private boolean isSwapRequired(int i) {
        return this.size + i > this.maxMemory && this.byteArray != null;
    }

    public void write(int i) {
        try {
            initBuffers();
            if (isSwapRequired(1)) {
                swapToDisk();
            }
            this.size++;
            this.current.write(i);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    private void initBuffers() {
        if (this.current == null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.byteArray = byteArrayOutputStream;
            this.current = byteArrayOutputStream;
        }
    }

    protected void swapToDisk() {
        this.fileoutputStream = new FileOutputStream(this.file);
        this.byteArray.writeTo(this.fileoutputStream);
        this.byteArray = null;
        this.current = this.fileoutputStream;
    }

    public void clear() {
        this.byteArray = null;
        this.current = null;
        if (this.fileInputStream != null) {
            try {
                this.fileInputStream.close();
            } catch (IOException e) {
            }
        }
        this.fileInputStream = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public InputStream getInputStream() {
        this.current.close();
        if (this.byteArray != null) {
            return new ByteArrayInputStream(this.byteArray.toByteArray());
        }
        InputStream fileInputStream = new FileInputStream(this.file);
        this.fileInputStream = fileInputStream;
        return fileInputStream;
    }

    public Exception getException() {
        return this.exception;
    }

    public void reset() {
        clear();
        if (this.file.isFile()) {
            this.file.delete();
        }
        this.file = makeTempFile();
        this.exception = null;
    }
}
