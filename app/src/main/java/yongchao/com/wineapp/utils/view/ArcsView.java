package yongchao.com.wineapp.utils.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ArcsView extends View {

    private Paint mPaint;
    public ArcsView(Context context) {
        super(context);
    }

    public ArcsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ArcsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ArcsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);//取消锯齿
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.parseColor("#222222"));

        /**
         * 这是一个居中的圆
         */
        float x = getWidth();
        float y = getHeight();

        RectF oval = new RectF( -240, -500,
                getWidth()+240, 600 );

        canvas.drawArc(oval,0,180,true,mPaint);
    }
}
