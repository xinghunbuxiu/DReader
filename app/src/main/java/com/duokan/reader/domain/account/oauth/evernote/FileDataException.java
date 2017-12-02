package com.duokan.reader.domain.account.oauth.evernote;

import com.evernote.thrift.TException;

public class FileDataException extends TException {
    FileDataException(String str) {
        super(str);
    }

    FileDataException(Exception exception) {
        super((Throwable) exception);
    }
}
