package com.duokan.reader.domain.account.oauth;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.oauth.evernote.Evernote;
import com.duokan.reader.domain.account.oauth.evernote.EvernoteCallback;
import com.duokan.reader.domain.account.oauth.evernote.EvernoteOAuthDialog;
import com.duokan.reader.domain.account.oauth.evernote.EvernoteSession;
import com.duokan.reader.domain.account.oauth.evernote.EvernoteTokenDao;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ThirdYinxiang extends ThirdOAuth {
    static final /* synthetic */ boolean $assertionsDisabled = (!ThirdYinxiang.class.desiredAssertionStatus());
    private Evernote mEvernote = null;

    /* renamed from: com.duokan.reader.domain.account.oauth.ThirdYinxiang$4 */
    class C07234 implements EvernoteCallback {
        C07234() {
        }

        public void setAuthenticationToken(Context context, String str, EvernoteTokenDao evernoteTokenDao) {
            TokenStore.getInstance().setAuthenticationToken(context, str, evernoteTokenDao);
        }

        public void logOut(Context context, String str) {
            TokenStore.getInstance().logOut(context, str);
        }

        public EvernoteTokenDao getAuthenticationResult(Context context, String str) {
            return TokenStore.getInstance().getAuthenticationResult(context, str);
        }
    }

    public ThirdYinxiang(Activity activity, String str) {
        super(activity, str);
    }

    public void oauth(OAuthCallback oAuthCallback) {
        if (evernote() == null) {
            oAuthCallback.onOauthFailed("");
            return;
        }
        EvernoteOAuthDialog evernoteOAuthDialog = new EvernoteOAuthDialog(getActivity(), this.mEvernote, "pkunetspy-0221", "905a975954fa7a3d", oAuthCallback);
        evernoteOAuthDialog.show();
        evernoteOAuthDialog.start();
    }

    public void queryAccount(final QueryAccountListener queryAccountListener) {
        if ($assertionsDisabled || queryAccountListener != null) {
            Evernote evernote = evernote();
            if (evernote == null) {
                queryAccountListener.onQueryAccountError();
                return;
            } else if (evernote.isLoggedIn()) {
                queryAccountListener.onQueryAccountOk(new String[0]);
                return;
            } else {
                oauth(new OAuthCallback() {
                    public void onOauthSuccess() {
                        be.m10286a(ThirdYinxiang.this.getActivity(), C0247i.account_success, 0).show();
                        queryAccountListener.onQueryAccountOk(new String[0]);
                    }

                    public void onOauthFailed(String str) {
                        be.m10286a(ThirdYinxiang.this.getActivity(), C0247i.account_failed, 0).show();
                        queryAccountListener.onQueryAccountError();
                    }

                    public void onGetUserNameFailed() {
                        be.m10286a(ThirdYinxiang.this.getActivity(), C0247i.account_get_name_failed, 0).show();
                        queryAccountListener.onQueryAccountOk(new String[0]);
                    }
                });
                return;
            }
        }
        throw new AssertionError();
    }

    public void output(String str, String str2, String str3, boolean z, UpdateHandler updateHandler) {
        ja jaVar;
        if (z) {
            jaVar = new ja(getActivity());
            jaVar.m10844a(true);
            jaVar.m10843a(getActivity().getString(C0247i.account__oauth__sending));
            jaVar.show();
        } else {
            jaVar = null;
        }
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final UpdateHandler updateHandler2 = updateHandler;
        new WebSession(ThirdSessionConfig.VALUE) {
            protected void onSessionTry() {
                ThirdYinxiang.this.evernote().output(ThirdYinxiang.this.getActivity().getString(C0247i.reading__shared__note_book_name), str4, ThirdYinxiang.this.getActivity().getString(C0247i.reading__shared__note_tag), str5, str6);
            }

            protected void onSessionSucceeded() {
                if (jaVar != null) {
                    jaVar.dismiss();
                }
                updateHandler2.onUpdateOk();
            }

            protected void onSessionFailed() {
                if (jaVar != null) {
                    jaVar.dismiss();
                }
                updateHandler2.onUpdateError();
            }
        }.open();
    }

    public void delete(final String str, final DeleteHandler deleteHandler) {
        new WebSession(ThirdSessionConfig.VALUE) {
            protected void onSessionTry() {
                ThirdYinxiang.this.evernote().delete(str);
            }

            protected void onSessionSucceeded() {
                deleteHandler.onDeleteOk();
            }

            protected void onSessionFailed() {
                deleteHandler.onDeleteError();
            }
        }.open();
    }

    public String makeContent(C0800c c0800c, HashMap<C0798a, C0901g> hashMap, List<C0798a> list) {
        StringBuffer stringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        stringBuffer.append(makeHeader(c0800c.ay(), c0800c.m4150C()));
        for (int i = 0; i < list.size(); i++) {
            String str;
            String str2;
            C0798a c0798a = (C0798a) list.get(i);
            Object obj = 1;
            if (hashMap.containsKey(c0798a)) {
                stringBuffer.append(String.format(getActivity().getString(C0247i.reading__shared__chapter), new Object[]{((C0901g) hashMap.get(c0798a)).mo1202e()}));
                obj = null;
            }
            if (i == list.size()) {
                obj = null;
            }
            String format = simpleDateFormat.format(new Date(c0798a.m3730g()));
            ea eaVar = (ea) c0798a;
            String str3 = Color.red(eaVar.m4385n()) + "," + Color.green(eaVar.m4385n()) + "," + Color.blue(eaVar.m4385n());
            Object m = eaVar.m4384m();
            String string = getActivity().getString(C0247i.reading__shared__comment);
            Object[] objArr = new Object[5];
            if (obj == null) {
                str = "";
            } else {
                str = getActivity().getString(C0247i.reading__shared__comment_split);
            }
            objArr[0] = str;
            objArr[1] = str3;
            objArr[2] = format;
            objArr[3] = escapeIllegalCharacters(eaVar.m3715a(false));
            if (TextUtils.isEmpty(m)) {
                str2 = "";
            } else {
                str2 = String.format(getActivity().getString(C0247i.reading__shared__note), new Object[]{escapeIllegalCharacters(m)});
            }
            objArr[4] = str2;
            stringBuffer.append(String.format(string, objArr));
        }
        stringBuffer.append(String.format(getActivity().getString(C0247i.reading__shared__foot), new Object[]{c0800c.getId()}));
        return stringBuffer.toString();
    }

    public String makeContent(String str, String str2, String str3, List<DkCloudComment> list) {
        StringBuffer stringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        stringBuffer.append(makeHeader(str2, str3));
        for (int i = 0; i < list.size(); i++) {
            String str4;
            DkCloudComment dkCloudComment = (DkCloudComment) list.get(i);
            String format = simpleDateFormat.format(dkCloudComment.getCreationDate());
            String str5 = Color.red(dkCloudComment.getHighlightColor()) + "," + Color.green(dkCloudComment.getHighlightColor()) + "," + Color.blue(dkCloudComment.getHighlightColor());
            Object noteText = dkCloudComment.getNoteText();
            String string = getActivity().getString(C0247i.reading__shared__comment);
            Object[] objArr = new Object[5];
            objArr[0] = getActivity().getString(C0247i.reading__shared__comment_split);
            objArr[1] = str5;
            objArr[2] = format;
            objArr[3] = escapeIllegalCharacters(dkCloudComment.getSample());
            if (TextUtils.isEmpty(noteText)) {
                str4 = "";
            } else {
                str4 = String.format(getActivity().getString(C0247i.reading__shared__note), new Object[]{escapeIllegalCharacters(noteText)});
            }
            objArr[4] = str4;
            stringBuffer.append(String.format(string, objArr));
        }
        stringBuffer.append(String.format(getActivity().getString(C0247i.reading__shared__foot), new Object[]{str}));
        return stringBuffer.toString();
    }

    public String makeHeader(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getActivity().getString(C0247i.reading__shared__title)).append(str).append(getActivity().getString(C0247i.reading__shared__title_suffix));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(String.format(getActivity().getString(C0247i.reading__shared__author), new Object[]{str2}));
        }
        return stringBuffer.toString();
    }

    public String makeTitle(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(getActivity().getString(C0247i.reading__shared__note_title), new Object[]{str}));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(String.format(getActivity().getString(C0247i.reading__shared__note_title_author), new Object[]{str2}));
        }
        return stringBuffer.toString();
    }

    public void update(String str, Bitmap bitmap, String str2, UpdateHandler updateHandler) {
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
    }

    private String getBaseServerUrl() {
        if ("yinxiang".equals(this.mThirdName)) {
            return "app.yinxiang.com";
        }
        if ("evernote".equals(this.mThirdName)) {
            return "www.evernote.com";
        }
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    protected C0624a makeFetchUserInfoRequest() {
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    protected boolean handleUserInfoResponse(String str) {
        if ($assertionsDisabled) {
            return false;
        }
        throw new AssertionError();
    }

    protected C0624a makeUpdateRequest(String str, Bitmap bitmap) {
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    protected ResponseHandleResult<Boolean> handleUpdateResponse(String str) {
        if ($assertionsDisabled) {
            return new ResponseHandleResult(Boolean.valueOf(false));
        }
        throw new AssertionError();
    }

    private String escapeIllegalCharacters(String str) {
        String replace = str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;");
        String[] split = replace.split("\n");
        if (split != null && split.length > 0) {
            replace = "";
            int i = 0;
            while (i < split.length) {
                if (i == split.length - 1) {
                    replace = replace + (i % 2 == 0 ? split[i] : split[i] + "</br>");
                } else {
                    replace = replace + split[i] + (i % 2 == 0 ? "<br>" : "</br>");
                }
                i++;
            }
        }
        return replace.replace("\"", "&quot;");
    }

    private synchronized Evernote evernote() {
        Evernote evernote;
        if (this.mEvernote != null) {
            evernote = this.mEvernote;
        } else {
            try {
                this.mEvernote = new EvernoteSession(this.mActivity, this.mThirdName, "pkunetspy-0221", "905a975954fa7a3d", getBaseServerUrl(), ManagedApp.get().getTopActivity().getFilesDir(), new C07234());
            } catch (Exception e) {
                e.printStackTrace();
            }
            evernote = this.mEvernote;
        }
        return evernote;
    }
}
