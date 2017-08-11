package com.rz.librarydialog.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Rz Rasel on 2017-07-29.
 */

public class DialogTextViewJustified extends AppCompatTextView {
    public DialogTextViewJustified(Context context) {
        super(context);
        init();
    }

    public DialogTextViewJustified(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DialogTextViewJustified(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /*@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DialogTextViewJustified(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }*/

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/regular.ttf");
        setTypeface(typeface);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();

        String text = getText().toString();

        float lineY = 0;
        lineY += getTextSize() * 1f;

        final Layout layout = getLayout();
        final float desiredLineWidth = getMeasuredWidth();

        for (int i = 0, lineCount = layout.getLineCount(); i < lineCount; i++) {
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            String line = text.substring(lineStart, lineEnd);
            //System.out.println(i + ": " + line);

            if (needScale(line) && i < lineCount - 1) {
                drawScaledText(line, canvas, lineY, desiredLineWidth, paint);
            } else {
                canvas.drawText(line, 0, lineY, paint);
            }

            lineY += getLineHeight();
        }
    }

    private void drawScaledText(final String line, final Canvas canvas, final float y, final float desiredLineWidth, final TextPaint paint) {
        String[] words = line.split(" ");

        float lineWidthWithoutSpaces = StaticLayout.getDesiredWidth(line.replace(" ", ""), getPaint());
        float spacing = (desiredLineWidth - lineWidthWithoutSpaces) / (words.length - 1);

        float x = 0;
        for (String word : words) {
            float cw = StaticLayout.getDesiredWidth(word, paint);
            canvas.drawText(word, x, y, paint);
            x += cw + spacing;
        }
    }

    private void drawScaledText(String line, Canvas canvas, int lineStart, final float mLineY, float lineWidth, TextPaint paint) {
        float x = 0;
        if (isFirstLineOfParagraph(lineStart, line)) {
            String blanks = "  ";
            canvas.drawText(blanks, x, mLineY, getPaint());
            float bw = StaticLayout.getDesiredWidth(blanks, getPaint());
            x += bw;

            line = line.substring(3);
        }

        float d = (lineWidth - lineWidth) / line.length() - 1;
        for (int i = 0; i < line.length(); i++) {
            String c = String.valueOf(line.charAt(i));
            float cw = StaticLayout.getDesiredWidth(c, getPaint());
            canvas.drawText(c, x, mLineY, getPaint());
            x += cw + d;
        }
    }

    private boolean isFirstLineOfParagraph(int lineStart, String line) {
        return line.length() > 3 && line.charAt(0) == ' ' && line.charAt(1) == ' ';
    }

    private boolean needScale(String line) {
        if (line.length() == 0) {
            return false;
        } else {
            return line.charAt(line.length() - 1) != '\n';
        }
    }
}
/*
https://stackoverflow.com/questions/17321614/custom-textview-with-html-text-and-custom-font-whole-android-application
https://stackoverflow.com/questions/4819049/how-can-i-use-typefacespan-or-stylespan-with-a-custom-typeface
https://stackoverflow.com/questions/38627915/justified-textview-supporting-html-tags

https://stackoverflow.com/questions/1292575/android-textview-justify-text
*/