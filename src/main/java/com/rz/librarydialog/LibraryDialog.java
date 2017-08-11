package com.rz.librarydialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rz.librarydialog.widgets.DialogTextViewJustified;
import com.rz.librarydialog.widgets.JustifyTextView;

/**
 * Created by Rz Rasel on 2017-07-28.
 */

public class LibraryDialog extends Dialog {
    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    //|――――|――――|VARIABLE DECLARATION SECTION|――――|
    private String dialogTitle;
    private String dialogMessage;
    //|――――|――――|BUTTON TEXT SECTION|――――|
    private String btnTextConfirm;
    private String btnTextNegative;
    private String btnTextPositive;
    //|――――|――――|BUTTON CLICK LISTENER|――――|
    private View.OnClickListener btnListenerConfirm = null;
    private View.OnClickListener btnListenerNegative = null;
    private View.OnClickListener btnListenerPositive = null;
    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    private TextView sysTvDialogScrollPercentage;
    //|――――|――――|BUTTON NAME SECTION|――――|
    private Button sysBtnConfirm;
    private Button sysBtnNegative;
    private Button sysBtnPositive;
    //|――――|――――|BOOLEAN BUTTON IS SHOWN IN DIALOG BOX|――――|
    private boolean isShowBtnConfirm = false;
    private boolean isShowBtnNegative = false;
    private boolean isShowBtnPositive = false;
    private boolean isShowScrollingPercentage = false;
    private ScrollView sysScrollViewBody;
    private int totalScrollableHeight;
    private int currentScrollPosition = 0;
    private int scrollChildReLayHeight = 0;
    private boolean isScrollable = false;
    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    private int scrollingPercentageValue = 0;
    private OnEventsListenerHandler onEventsListenerHandler = null;
    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    //|――――|――――|CONSTRUCTOR SECTION|――――|

    public LibraryDialog(Context argContext) {
        //super(argContext);
        super(argContext, R.style.ThemeDialogOrange);
    }
    //|――――|――――――――――――――――――――――――――――――――――――|――――|

    public LibraryDialog(Context argContext, int argThemeResId) {
        super(argContext, argThemeResId);
    }
    //|――――|――――――――――――――――――――――――――――――――――――|――――|

    protected LibraryDialog(Context argContext, boolean argCancelable, OnCancelListener cancelListener) {
        super(argContext, argCancelable, cancelListener);
    }
    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    //|――――|――――|ON CREATE SECTION|――――|

    @Override
    protected void onCreate(Bundle argSavedInstanceState) {
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        super.onCreate(argSavedInstanceState);
        //|――――|――――|DIALOG BOX WITHOUT TITLE BAR|――――|
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        //|――――|――――|DIALOG BOX CANCEL TOUCH OR CLICK OUTSIDE THE DIALOG BOX|――――|
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        //|――――|――――|SET DIALOG BOX LAYOUT|――――|
        setContentView(R.layout.lay_library_dialog);
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        TextView sysTvDialogTitle = (TextView) findViewById(R.id.sysTvDialogTitle);
        DialogTextViewJustified sysTvDialogBody = (DialogTextViewJustified) findViewById(R.id.sysTvDialogBody);
        sysTvDialogScrollPercentage = (TextView) findViewById(R.id.sysTvDialogScrollPercentage);
        sysTvDialogTitle.setText(getTitle());
        sysTvDialogBody.setText(textFromHtml(getBodyMessage()));
        sysTvDialogScrollPercentage.setText("");
        if (isShowScrollingPercentage) {
            sysTvDialogScrollPercentage.setText(0 + "%");
        }
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        sysBtnConfirm = (Button) findViewById(R.id.sysBtnConfirm);
        sysBtnNegative = (Button) findViewById(R.id.sysBtnNegative);
        sysBtnPositive = (Button) findViewById(R.id.sysBtnPositive);
        sysBtnConfirm.setText(btnTextConfirm);
        sysBtnNegative.setText(btnTextNegative);
        sysBtnPositive.setText(btnTextPositive);
        sysBtnConfirm.setOnClickListener(btnListenerConfirm);
        sysBtnNegative.setOnClickListener(btnListenerNegative);
        sysBtnPositive.setOnClickListener(btnListenerPositive);
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        sysBtnConfirm.setVisibility(View.GONE);
        sysBtnNegative.setVisibility(View.GONE);
        sysBtnPositive.setVisibility(View.GONE);
        if (isShowBtnConfirm)
            sysBtnConfirm.setVisibility(View.VISIBLE);
        if (isShowBtnNegative)
            sysBtnNegative.setVisibility(View.VISIBLE);
        if (isShowBtnPositive)
            sysBtnPositive.setVisibility(View.VISIBLE);
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        sysScrollViewBody = (ScrollView) findViewById(R.id.sysScrollViewBody);
        /*int childHeight = ((RelativeLayout) findViewById(R.id.idRelaLayScrollContent)).getHeight();
        boolean isScrollable = sysScrollViewBody.getHeight() < childHeight + sysScrollViewBody.getPaddingTop() + sysScrollViewBody.getPaddingBottom();
        System.out.println("---------------------------------------CHILD_HEIGHT-: " + childHeight);*/
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
        ViewTreeObserver viewTreeObserver = sysScrollViewBody.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                //sysScrollViewBody.scrollTo(sysScrollViewBody.getChildAt(0).getWidth() / 2, 0);
                View scrollChildView = sysScrollViewBody.getChildAt(0);
                scrollChildReLayHeight = ((RelativeLayout) findViewById(R.id.idRelaLayScrollContent)).getHeight();
                //totalScrollableHeight = sysScrollViewBody.getBottom();
                totalScrollableHeight = scrollChildView.getHeight() - sysScrollViewBody.getHeight();
                totalScrollableHeight = scrollChildReLayHeight - sysScrollViewBody.getHeight();
                isScrollable = sysScrollViewBody.getHeight() < scrollChildReLayHeight + sysScrollViewBody.getPaddingTop() + sysScrollViewBody.getPaddingBottom();
                //System.out.println("---------------------------------------HEIGHT-: " + totalScrollableHeight);
                //System.out.println("---------------------------------------MAX_SCROLL_AMOUNT-: " + sysScrollViewBody.getMaxScrollAmount());
                //sysScrollViewBody.scrollTo(0, totalScrollableHeight / 2);
                //sysScrollViewBody.smoothScrollTo(0, totalScrollableHeight / 2);
            }
        });
        /*sysScrollViewBody.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View argView, MotionEvent argMotionEvent) {
                System.out.println("---------------------------------------TOUCH-: " + sysScrollViewBody.getScaleY());
                return false;
            }
        });*/
        viewTreeObserver.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                //int scrollY = sysScrollViewBody.getScrollY();
                currentScrollPosition = sysScrollViewBody.getScrollY();
                //System.out.println("---------------------------------------SCROLL_Y-: " + currentScrollPosition);
                scrollingPercentageValue = (currentScrollPosition * 100) / totalScrollableHeight;
                if (onEventsListenerHandler != null) {
                    onEventsListenerHandler.onScrollingPercentage(sysTvDialogScrollPercentage, scrollingPercentageValue);
                    /*if (isShowScrollingPercentage) {
                        sysTvDialogScrollPercentage.setText(scrollingPercentageValue + "%");
                    }*/
                }
            }
        });
        //|――――|――――――――――――――――――――――――――――――――――――|――――|
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public LibraryDialog getScrollingPercentage(OnEventsListenerHandler argOnEventsListenerHandler) {
        isShowScrollingPercentage = true;
        this.onEventsListenerHandler = argOnEventsListenerHandler;
        return this;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public boolean getIsScrollable() {
        /*if(isScrollable)
            System.out.println("---------------------------------------SCROLLABLE-: " + totalScrollableHeight);
        else
            System.out.println("---------------------------------------NOT_SCROLLABLE-: " + totalScrollableHeight);*/
        return isScrollable;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public String getTitle() {
        return dialogTitle;
    }
    //|――――|――――――――――――――――――――――――――――――――――――|――――|

    public LibraryDialog setTitle(String argDialogTitle) {
        this.dialogTitle = argDialogTitle;
        return this;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public String getBodyMessage() {
        return dialogMessage;
    }
    //|――――|――――――――――――――――――――――――――――――――――――|――――|

    public LibraryDialog setBodyMessage(String argDialogMessage) {
        this.dialogMessage = argDialogMessage;
        return this;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public LibraryDialog setConfirmButton(String argTextConfirm, View.OnClickListener argOnClickListener) {
        dismiss();
        this.btnTextConfirm = argTextConfirm;
        this.btnListenerConfirm = argOnClickListener;
        isShowBtnConfirm = true;
        return this;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public LibraryDialog setNegativeButton(String argTextNegative, View.OnClickListener argOnClickListener) {
        dismiss();
        this.btnTextNegative = argTextNegative;
        this.btnListenerNegative = argOnClickListener;
        isShowBtnNegative = true;
        return this;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public LibraryDialog setPositiveButton(String argTextPositive, View.OnClickListener argOnClickListener) {
        dismiss();
        this.btnTextPositive = argTextPositive;
        this.btnListenerPositive = argOnClickListener;
        isShowBtnPositive = true;
        return this;
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public interface OnEventsListenerHandler {
        public void onScrollingPercentage(TextView argTextViewScrollPercentage, int argScrollPercentage);
    }

    //|――――|――――――――――――――――――――――――――――――――――――|――――|
    public static Spanned textFromHtml(String argHtml) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(argHtml, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(argHtml);
        }
        return result;
    }
    //|――――|――――――――――――――――――――――――――――――――――――|――――|
}
/*
//|――――|――――――――――――――――――――――――――――――――――――|――――|
//|――――|――――|READ FROM ASSET FILE CLASS USAGES|――――|
private LibraryDialog libDialog;
libDialog = new LibraryDialog(this);
libDialog.setTitle("Hi! Title")
.setBodyMessage("An advocate of socialism, Rahman rose with the ranks of the Awami League and East Pakistani politics as a charismatic and forceful orator. He became popular for his opposition to the ethnic and institutional discrimination of Bengalis in Pakistan, who comprised the majority of the state's population. At the heightening of sectional tensions, he outlined a 6-point autonomy plan and was jailed by the regime of Field Marshal Ayub Khan for treason. Rahman led the Awami League to win the first democratic election of Pakistan in 1970. Despite gaining a majority, the League was not invited by the ruling military junta to form a government. As civil disobedience erupted across East Pakistan, Rahman announced the Bangladeshi struggle for independence during a landmark speech on 7 March 1971. On 26 March 1971, the Pakistan Army responded to the mass protests with Operation Searchlight, in which Prime Minister-elect Rahman was arrested and flown to solitary confinement in West Pakistan,[1] while Bengali civilians, students, intellectuals, politicians and military defectors were murdered as part of the 1971 Bangladesh genocide. After Bangladesh's liberation, Rahman was released from Pakistani custody and returned to Dhaka in January 1972. Rahman became the Prime Minister of Bangladesh under a parliamentary system adopted by the new country. His government enacted a constitution proclaiming socialism and secular democracy. The Awami League won a huge mandate in the country's first general election in 1973. However, Rahman faced challenges of rampant unemployment, poverty and corruption. A famine took place in 1974. The government was criticized for denying constitutional recognition to indigenous minorities and human rights violations by its security forces, notably the National Defense Force paramilitia. Amid rising political agitation, Rahman initiated one party socialist rule in January 1975. Six months later, he and most of his family were assassinated by renegade army officers during a coup. A martial law government was subsequently established.")
.setConfirmButton("Con", new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        libDialog.dismiss();
    }
})
.setNegativeButton("No", new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //libDialog.dismiss();
    }
});
libDialog.show();
//|――――|――――――――――――――――――――――――――――――――――――|――――|
*/