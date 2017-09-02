package iflytek.com.beauitydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * 简单的画布实现
 * Created by Administrator on 2017/9/2/002.
 */

public class MyView extends View {

    private Paint paint;
    private Path path;
    private Canvas canvas;

    private float startX,startY;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        //防抖动
        paint.setDither(true);
        //抗锯齿
        paint.setAntiAlias(true);
        //边框
        paint.setStyle(Paint.Style.STROKE);
        //后圆角
        paint.setStrokeCap(Paint.Cap.ROUND);
        //前圆角
        paint.setStrokeJoin(Paint.Join.ROUND);
        //设置边框宽度
        paint.setStrokeWidth(10);
        //设置颜色
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 重点在这儿，连接画笔和路径的画布
         */
        canvas.drawPath(path,paint);
        canvas.drawCircle(startX,startY,(float) Math.random()*20+20,paint);
//        Log.i("onDraw()", );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX =  event.getX();
        float currentY =  event.getY();

        int  action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN://按下操作
                startX = event.getX();
                startY = event.getY();
                path.moveTo(startX,startY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(currentX,currentY);
                path.addCircle(startX,startY,(float) Math.random()*20+20, Path.Direction.CCW);
                startX = currentX;
                startY = currentY;
                break;
        }
        invalidate();//调用该方法会回调onDraw()方法
        return true;
    }

    /**
     * 清空画布内容
     */
    public void clear() {
        path.reset();
//        path.moveTo(-1,-1);
//        path.lineTo(-1,-1);
        invalidate();
    }
}
