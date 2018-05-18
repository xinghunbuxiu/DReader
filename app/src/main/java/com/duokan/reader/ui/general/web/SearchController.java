package com.duokan.reader.ui.general.web;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.p027b.UrlTools;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.GridItemsView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.fr;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.C0616o;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.bookshelf.ea;
import com.duokan.reader.ui.bookshelf.hu;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.surfing.al;
import java.util.LinkedList;

public class SearchController extends StorePageController implements ip, iq {
    private static final int HISTORY_SIZE = Integer.MAX_VALUE;
    private static final String KEY_SEARCH_HISTORY = "search_history";
    private static final String KEY_SEARCH_HOTWORD = "search_hotword";
    private static final int MAX_LOAD_TIME = 5;
    private View mClearView;
    private String mDefaultSearchWord = "";
    private EditText mEditText;
    private final LinkedList<String> mHistory = new LinkedList();
    private String mHitWord = null;
    private final LinkedList<String> mHotWord = new LinkedList();
    private boolean mIsHistoryLoaded = false;
    private boolean mLoadHistory = true;
    private boolean mLoadHotWord = true;
    private boolean mLoadingSucceed = false;
    private String mLoadingUrl;
    private int mLocalHintSize = getLocalHintSize();
    private int mLocalSearchLoadTime = 0;
    private View mLocalSearchResultView;
    private String mOpenFrom = null;
    private GridItemsView mPresenterResultView;
    private String mReloadUrl;
    private final LinkedList<String> mSearchHint = new LinkedList();
    private DkWebListView mSearchHintView;
    private boolean mSearchOnTextChange = true;
    private hu mSearchPresenter = null;
    private String mSearchSource;
    private boolean mStartSearch = false;
    private Runnable mTimeoutRunnable;
    private boolean mXiaoAiAwake = false;
    private View mXiaoAiInputView;

    public SearchController(IFeature mFeature) {
        super(mFeature);
        ((TextView) this.mErrorView.findViewById(C0255g.general__emtpy_view__line_1)).setText(C0258j.general__shared__web_error);
        TextView textView = (TextView) this.mErrorView.findViewById(C0255g.general__emtpy_view__line_3);
        textView.setText(C0258j.general__shared__web_refresh);
        textView.setVisibility(0);
        textView.setOnClickListener(new C1370p(this));
        this.mWebRootView.setPadding(0, 0, 0, 0);
        View findViewById = findViewById(C0255g.store__store_search_root_view__title);
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        if (c0435s != null) {
            findViewById.setPadding(findViewById.getPaddingLeft(), c0435s.getTheme().getHeaderPaddingTop() + findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        }
        ReaderFeature readerFeature = (ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            findViewById.setBackgroundDrawable(readerFeature.getHeaderBackground());
        }
        this.mClearView = findViewById(C0255g.store__store_search_root_view__clear);
        this.mClearView.setOnClickListener(new aa(this));
        this.mLocalSearchResultView = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__local_search_hint_view, null);
        ImageView imageView = (ImageView) this.mLocalSearchResultView.findViewById(C0255g.store__store_search_root_view__presenter_load_more);
        imageView.setOnClickListener(new ab(this));
        this.mPresenterResultView = (GridItemsView) this.mLocalSearchResultView.findViewById(C0255g.store__store_search_root_view__presenter_result);
        this.mPresenterResultView.setBackgroundColor(getResources().getColor(C0252d.general__shared__ffffff));
        this.mPresenterResultView.setAdapter(new ac(this, imageView));
        this.mPresenterResultView.setOnItemClickListener(new ad(this));
        this.mPresenterResultView.setOnItemLongPressListener(new ae(this));
        this.mPresenterResultView.setNumColumns(ea.m9503a(getContext()));
        this.mPresenterResultView.setMaxOverScrollHeight(AnimUtils.getMaxOverScrollHeight(getContext()));
        this.mSearchHintView.setHatBodyView(this.mLocalSearchResultView);
        this.mEditText = (EditText) findViewById(C0255g.store__store_search_root_view__edittext);
        this.mEditText.addTextChangedListener(new af(this));
        this.mEditText.setOnEditorActionListener(new ai(this));
        int b = AnimUtils.m1932b(getContext(), 15.0f);
        this.mXiaoAiInputView = findViewById(C0255g.store__store_search_root_view__voice);
        if (C0616o.m2804a().m2814d()) {
            this.mXiaoAiInputView.setClickable(true);
            this.mXiaoAiInputView.setOnClickListener(new aj(this));
        } else {
            this.mXiaoAiInputView.setVisibility(8);
        }
        this.mSearchHintView.m9955a(b, 0, b, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        this.mSearchHintView.setPullDownRefreshEnabled(false);
        this.mSearchHintView.setOnItemClickListener(new C1371q(this));
        initViewForPh();
    }

    public void checkDefaultSearch() {
        if (!TextUtils.isEmpty(this.mDefaultSearchWord)) {
            if (this.mXiaoAiAwake) {
                this.mSearchOnTextChange = true;
            } else {
                this.mSearchOnTextChange = false;
            }
            this.mEditText.setText(this.mDefaultSearchWord);
            this.mEditText.selectAll();
            if (this.mStartSearch) {
                search(this.mDefaultSearchWord, "");
                return;
            }
        }
        if (!this.mXiaoAiAwake) {
            ReaderUi.m10162a(getContext(), this.mEditText);
        }
    }

    public void setSearchSource(String str) {
        this.mSearchSource = str;
    }

    public void setOpenFrom(String str) {
        this.mOpenFrom = str;
    }

    public void setXiaoAiAwake(boolean z) {
        this.mXiaoAiAwake = z;
    }

    public void setDefaultSearchWord(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.mDefaultSearchWord = str2;
            this.mStartSearch = false;
            return;
        }
        this.mDefaultSearchWord = str;
        this.mStartSearch = true;
    }

    public void setBookshelfResultPresenter(hu huVar) {
        this.mSearchPresenter = huVar;
    }

    private void reloadUrl(String str) {
        this.mReloadUrl = str;
        this.mWebView.mo1815a("about:blank");
    }

    public void onPageFinished(fr frVar, String str) {
        super.onPageFinished(frVar, str);
        if (!TextUtils.isEmpty(this.mReloadUrl) && TextUtils.equals(str, "about:blank")) {
            loadUrl(this.mReloadUrl);
            this.mReloadUrl = null;
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.mSearchHintView.m9954a();
            updateAllViews();
            checkDefaultSearch();
        }
        ai.m3980a().m3889a((ip) this);
        ai.m3980a().m3890a((iq) this);
        al alVar = (al) getContext().queryFeature(al.class);
        if (alVar != null) {
            alVar.mo2558n();
        }
    }

    protected void onDeactive() {
        al alVar = (al) getContext().queryFeature(al.class);
        if (alVar != null) {
            alVar.mo2557m();
        }
        ai.m3980a().m3912b((ip) this);
        ai.m3980a().m3913b((iq) this);
        AnimUtils.m1909a(getContext());
        super.onDeactive();
    }

    protected al newJavascriptImpl() {
        return new al(this);
    }

    protected boolean onBack() {
        if (TextUtils.isEmpty(this.mEditText.getText())) {
            return false;
        }
        if (!isPageChanged(C0641o.m2934i().m2973f()) && this.mWebRootView.getVisibility() == 0) {
            return false;
        }
        this.mEditText.getText().clear();
        return true;
    }

    public void onItemChanged(an anVar, int i) {
        refreshView();
    }

    public void onItemsChanged() {
        refreshView();
    }

    protected void initContentView() {
        View c1372r = new C1372r(this, getContext());
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0256h.store__store_search_root_view, c1372r, false);
        c1372r.addView(linearLayout);
        View arVar = new ar(this, getContext());
        linearLayout.addView(arVar, new LayoutParams(-1, -1));
        this.mSearchHintView = new DkWebListView(getContext());
        LayoutInflater.from(getContext()).inflate(C0256h.general__web_core_view, arVar, true);
        arVar.addView(this.mSearchHintView, new LayoutParams(-1, -1));
        setContentView(c1372r);
    }

    protected void webPageError(boolean z) {
        this.mErrorView.setVisibility(z ? 0 : 4);
        if (z && TextUtils.isEmpty(this.mEditText.getText())) {
            showHintView();
        }
    }

    protected void onPageCreated(int i, String str) {
        Uri a = UrlTools.parse(getCurrentUrl());
        Uri a2 = UrlTools.parse(this.mLoadingUrl);
        if (i == 0 && a != null && a2 != null) {
            if (a.getFragment() == null || a.getFragment().equals(a2.getFragment())) {
                this.mLoadingSucceed = true;
                this.mWebView.m2123g();
            }
        }
    }

    private void initViewForPh() {
        this.mPresenterResultView.setPadding(this.mPresenterResultView.getPaddingLeft(), 0, this.mPresenterResultView.getPaddingRight(), this.mPresenterResultView.getPaddingBottom());
        Drawable dkVar = new dk(getResources().getColor(C0252d.general__shared__eeeeee));
        dkVar.m10476a(1);
        this.mSearchHintView.setRowDivider(dkVar);
        this.mSearchHintView.m9955a(AnimUtils.m1932b(getContext(), 20.0f), 0, AnimUtils.m1932b(getContext(), 20.0f), 0);
        this.mSearchHintView.setBackgroundColor(getResources().getColor(C0252d.general__shared__ffffff));
        this.mSearchHintView.setAdapter(new C1373s(this));
    }

    private void refreshView() {
        if (this.mSearchPresenter != null) {
            this.mSearchPresenter.mo1719a(this.mEditText.getText().toString().trim());
            ((bo) this.mPresenterResultView.getAdapter()).mo1691d();
            updateBookshelfResultVisibility();
        }
    }

    private int getLocalHintSize() {
        return ReaderUi.m10165c(getContext(), AnimUtils.getWidthPixels(getContext()) - (getResources().getDimensionPixelSize(C0253e.general__shared__cover_grid_horz_padding) * 2));
    }

    private boolean hasHint() {
        if (TextUtils.isEmpty(this.mEditText.getText().toString()) || this.mSearchHint == null || this.mSearchHint.size() == 0) {
            return false;
        }
        return true;
    }

    private boolean hasHistory() {
        return this.mHistory.size() > 0;
    }

    private boolean hasHotWord() {
        return this.mHotWord.size() > 0;
    }

    private void setHotWordView(View view, int i, String str) {
        ((TextView) view.findViewById(C0255g.store__hot_word_item_view__text)).setText(str);
        view.findViewById(C0255g.store__hot_word_item_view__close).setVisibility(8);
        ((ImageView) view.findViewById(C0255g.store__hot_word_item_view__icon)).setImageResource(C0254f.search__hot_world_item_view__hint);
    }

    private void setHistoryView(View view, int i, String str) {
        TextView textView = (TextView) view.findViewById(C0255g.store__hot_word_item_view__text);
        ((ImageView) view.findViewById(C0255g.store__hot_word_item_view__icon)).setImageResource(C0254f.search__hot_world_item_view__history);
        textView.setText(str);
        View findViewById = view.findViewById(C0255g.store__hot_word_item_view__close);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new C1374t(this, i));
    }

    private void getHotWord() {
        if (this.mLoadHotWord) {
            this.mLoadHotWord = false;
            ah.m871b(new C1375u(this));
        }
    }

    private void querySearchHint(String str, Runnable runnable) {
        if (!TextUtils.isEmpty(str)) {
            C1176a.m8695a().m8702a(str, new C1377w(this, runnable));
        }
    }

    private void updateBookshelfResultVisibility() {
        if (this.mSearchPresenter.mo1716a() == 0) {
            this.mLocalSearchResultView.setVisibility(8);
        } else {
            this.mLocalSearchResultView.setVisibility(0);
        }
    }

    private void updateAllViews() {
        if (C0559f.m2476b().m2486e()) {
            String f = C0641o.m2934i().m2973f();
            if (isPageChanged(f)) {
                startLoading();
                hideHintView();
                this.mLoadingUrl = UrlTools.encodedFragment(UrlTools.parse(f), "loadingStamp=" + System.currentTimeMillis() + (TextUtils.isEmpty(this.mOpenFrom) ? "" : "&from=" + this.mOpenFrom)).toString();
                reloadUrl(this.mLoadingUrl);
                this.mTimeoutRunnable = new C1378x(this);
                UThread.postDelayed(this.mTimeoutRunnable, 3000);
                return;
            }
            hideHintView();
            return;
        }
        showHintView();
    }

    private void startLoading() {
        UThread.removeCallbacks(this.mTimeoutRunnable);
        this.mLoadingSucceed = false;
    }

    private void hideHintView() {
        this.mSearchHintView.setVisibility(4);
    }

    private void showHintView() {
        this.mWebView.mo1815a("about:blank");
        this.mSearchHintView.setVisibility(0);
    }

    private boolean isPageChanged(String str) {
        Object currentUrl = getCurrentUrl();
        if (!TextUtils.isEmpty(currentUrl) && currentUrl.startsWith(str + "#")) {
            return false;
        }
        return true;
    }

    private void showHint(String str, String[] strArr) {
        if (TextUtils.equals(str, this.mEditText.getText())) {
            this.mSearchHint.clear();
            this.mSearchHint.add(str);
            for (String str2 : strArr) {
                if (!str2.equals(str)) {
                    this.mSearchHint.add(str2);
                }
            }
            this.mSearchHintView.getAdapter().m8785a(false);
        }
    }

    private void search(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            AnimUtils.m1909a(getContext());
            this.mLocalSearchResultView.setVisibility(8);
            C0641o i = C0641o.m2934i();
            if (!TextUtils.isEmpty(this.mSearchSource)) {
                str2 = this.mSearchSource;
            }
            String a = i.m2955a(str, str2);
            this.mSearchSource = "";
            if (isPageChanged(a)) {
                startLoading();
                hideHintView();
                addHistory(str);
                this.mLoadingUrl = UrlTools.encodedFragment(UrlTools.parse(a), "loadingStamp=" + System.currentTimeMillis() + (TextUtils.isEmpty(this.mOpenFrom) ? "" : "&from=" + this.mOpenFrom)).toString();
                reloadUrl(this.mLoadingUrl);
                return;
            }
            hideHintView();
        }
    }

    private void notifyHistoryChanged() {
        this.mSearchHintView.getAdapter().m8785a(false);
    }

    private void addHistory(String str) {
        addHistoryToList(str, false);
        if (this.mIsHistoryLoaded) {
            writeHistory();
        }
        notifyHistoryChanged();
    }

    private void addHistoryToList(String str, boolean z) {
        if (this.mHistory.contains(str)) {
            this.mHistory.remove(str);
        } else if (this.mHistory.size() >= HISTORY_SIZE) {
            this.mHistory.removeLast();
        }
        if (z) {
            this.mHistory.addLast(str);
        } else {
            this.mHistory.addFirst(str);
        }
    }

    private void removeHistory(int i) {
        if (this.mHistory.size() > 0 && this.mHistory.size() >= i) {
            this.mHistory.remove(i);
            writeHistory();
            notifyHistoryChanged();
        }
    }

    private void writeHistory() {
        ReaderEnv.get().getDb().m634b(KEY_SEARCH_HISTORY, this.mHistory);
    }

    private void writeHotWords() {
        ReaderEnv.get().getDb().m634b(KEY_SEARCH_HOTWORD, this.mHotWord);
    }

    private void loadHistoryForPh() {
        this.mLoadHistory = false;
        ah.m871b(new C1379y(this));
    }
}
