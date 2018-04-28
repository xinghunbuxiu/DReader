package com.duokan.reader.domain.account.oauth.evernote;

import com.evernote.edam.type.Data;
import com.evernote.thrift.TException;
import com.evernote.thrift.protocol.TField;
import com.evernote.thrift.protocol.TProtocol;
import com.evernote.thrift.protocol.TStruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class FileData extends Data {
    private static final TField BODY_FIELD_DESC = new TField("body", (byte) 11, (short) 3);
    private static final TField BODY_HASH_FIELD_DESC = new TField("bodyHash", (byte) 11, (short) 1);
    private static final TField SIZE_FIELD_DESC = new TField("size", (byte) 8, (short) 2);
    private static final TStruct STRUCT_DESC = new TStruct("Data");
    private static final long serialVersionUID = 1;
    private File mBodyFile;

    public FileData(byte[] bArr, File file) {
        this.mBodyFile = file;
        setBodyHash(bArr);
        setSize((int) file.length());
    }

    public void write(TProtocol tProtocol) {
        Throwable e;
        validate();
        tProtocol.writeStructBegin(STRUCT_DESC);
        if (getBodyHash() != null && isSetBodyHash()) {
            tProtocol.writeFieldBegin(BODY_HASH_FIELD_DESC);
            tProtocol.writeBinary(ByteBuffer.wrap(getBodyHash()));
            tProtocol.writeFieldEnd();
        }
        tProtocol.writeFieldBegin(SIZE_FIELD_DESC);
        tProtocol.writeI32(getSize());
        tProtocol.writeFieldEnd();
        if (this.mBodyFile != null && this.mBodyFile.isFile()) {
            tProtocol.writeFieldBegin(BODY_FIELD_DESC);
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(this.mBodyFile);
                try {
                    tProtocol.writeStream(fileInputStream, this.mBodyFile.length());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    tProtocol.writeFieldEnd();
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        throw new TException("Failed to write binary body:" + this.mBodyFile, e);
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream = null;
                throw new TException("Failed to write binary body:" + this.mBodyFile, e);
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        tProtocol.writeFieldStop();
        tProtocol.writeStructEnd();
    }
}
