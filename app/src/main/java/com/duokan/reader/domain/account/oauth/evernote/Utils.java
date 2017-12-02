package com.duokan.reader.domain.account.oauth.evernote;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteMetadata;
import com.evernote.edam.notestore.NoteStore.Client;
import com.evernote.edam.notestore.NotesMetadataList;
import com.evernote.edam.notestore.NotesMetadataResultSpec;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;
import com.evernote.edam.type.User;
import com.evernote.edam.userstore.UserStore;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.EvernoteApi;
import org.scribe.builder.api.EvernoteApi.Sandbox;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.util.LinkedList;
import java.util.List;

public abstract class Utils implements Evernote {
    private static final String TAG = "";

    public abstract Client createNoteStore();

    public abstract UserStore.Client createUserStore(String str);

    public abstract String getAuthToken();

    public abstract String getUserAgentString();

    public String[] beginAuth(String str, String str2, String str3) {
        String[] strArr = new String[3];
        try {
            OAuthService createService = createService(str, str2, str3);
            if (createUserStore(str).checkVersion(getUserAgentString(), (short) 1, (short) 23)) {
                Log.i(TAG, "Retrieving OAuth request token...");
                Token requestToken = createService.getRequestToken();
                strArr[1] = requestToken.getToken();
                strArr[2] = requestToken.getSecret();
                Log.i(TAG, "Redirecting user for authorization...");
                strArr[0] = createService.getAuthorizationUrl(requestToken);
                return strArr;
            }
            Log.e(TAG, "Evernote API version 1.23 is no longer supported!");
            return null;
        } catch (Throwable e) {
            Log.e(TAG, "Failed to obtain OAuth request token", e);
            return strArr;
        }
    }

    public Object completeAuth(String str, String str2, String str3, Uri uri, String str4, String str5) {
        if (uri == null) {
            return null;
        }
        if (TextUtils.isEmpty(str4)) {
            Log.d(TAG, "Unable to retrieve OAuth access token, no request token");
            return null;
        }
        OAuthService createService = createService(str, str2, str3);
        Object queryParameter = uri.getQueryParameter("oauth_verifier");
        if (TextUtils.isEmpty(queryParameter)) {
            Log.i(TAG, "User did not authorize access");
            return null;
        }
        Verifier verifier = new Verifier(queryParameter);
        Log.i(TAG, "Retrieving OAuth access token...");
        try {
            return new EvernoteAuthToken(createService.getAccessToken(new Token(str4, str5), verifier));
        } catch (Throwable e) {
            Log.e(TAG, "Failed to obtain OAuth access token", e);
            return null;
        }
    }

    public EvernoteUser getUser(String str) {
        EvernoteUser evernoteUser;
        Exception e;
        try {
            User user = createUserStore(str).getUser(getAuthToken());
            evernoteUser = new EvernoteUser();
            try {
                evernoteUser.mUserName = user.getUsername();
                evernoteUser.mName = user.getName();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return evernoteUser;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            evernoteUser = null;
            e = exception;
            e.printStackTrace();
            return evernoteUser;
        }
        return evernoteUser;
    }

    private OAuthService createService(String str, String str2, String str3) {
        Class cls;
        if (str.equals("sandbox.evernote.com")) {
            cls = Sandbox.class;
        } else if (str.equals("www.evernote.com")) {
            cls = EvernoteApi.class;
        } else if (str.equals("app.yinxiang.com")) {
            cls = YinxiangApi.class;
        } else {
            throw new IllegalArgumentException("Unsupported Evernote host: " + str);
        }
        return new ServiceBuilder().provider(cls).apiKey(str2).apiSecret(str3).callback(getCallbackScheme() + "://callback").build();
    }

    public String getCallbackScheme() {
        return "en-oauth";
    }

    public void delete(String str) {
        Client createNoteStore = createNoteStore();
        NoteFilter noteFilter = new NoteFilter();
        noteFilter.setWords(String.format("duokanbookid:%s", new Object[]{str}));
        NotesMetadataList findNotesMetadata = createNoteStore.findNotesMetadata(getAuthToken(), noteFilter, 0, 1, new NotesMetadataResultSpec());
        if (findNotesMetadata.getTotalNotes() != 0) {
            createNoteStore.deleteNote(getAuthToken(), ((NoteMetadata) findNotesMetadata.getNotes().get(0)).getGuid());
        }
    }

    public void output(String str, String str2, String str3, String str4, String str5) {
        Notebook createNotebook;
        Client createNoteStore = createNoteStore();
        for (Notebook notebook : createNoteStore.listNotebooks(getAuthToken())) {
            if (notebook.getName().equals(str)) {
                break;
            }
        }
        Notebook notebook2 = null;
        if (notebook2 == null) {
            notebook2 = new Notebook();
            notebook2.setName(str);
            createNotebook = createNoteStore.createNotebook(getAuthToken(), notebook2);
        } else {
            createNotebook = notebook2;
        }
        NoteFilter noteFilter = new NoteFilter();
        noteFilter.setNotebookGuid(createNotebook.getGuid());
        noteFilter.setWords(String.format("duokanbookid:%s", new Object[]{str2}));
        NotesMetadataList findNotesMetadata = createNoteStore.findNotesMetadata(getAuthToken(), noteFilter, 0, 1, new NotesMetadataResultSpec());
        Note note = new Note();
        note.setNotebookGuid(createNotebook.getGuid());
        List linkedList = new LinkedList();
        linkedList.add(str3);
        note.setTagNames(linkedList);
        String replaceAll = str4.replaceAll("\\p{Cc}\\p{Zl}\\p{Zp}", TAG);
        if (replaceAll.length() > 255) {
            replaceAll = replaceAll.substring(0, 255);
        }
        note.setTitle(replaceAll);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(EvernoteUtil.NOTE_PREFIX).append(str5).append(EvernoteUtil.NOTE_SUFFIX);
        note.setContent(stringBuffer.toString());
        if (findNotesMetadata.getTotalNotes() == 0) {
            createNoteStore.createNote(getAuthToken(), note);
            return;
        }
        note.setGuid(((NoteMetadata) findNotesMetadata.getNotes().get(0)).getGuid());
        createNoteStore.updateNote(getAuthToken(), note);
    }
}
