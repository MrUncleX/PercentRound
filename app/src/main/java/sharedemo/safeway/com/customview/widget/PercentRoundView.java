package sharedemo.safeway.com.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Created by LJX on 2016/8/16.
 */
public class PercentRoundView extends View {
    /**
     * 画笔
     */
    private Paint paint;
    private Paint textPaint;

    /**
     * 每个部分的百分比
     */
    private float[] percents = {55,13,5,27};
    /**
     * 圆弧对应的颜色
     */
    private int[] ringColor = {0xFF48CFAF,0xFFFF7A89,0xFF68A6FA,0xFF8D76FF};

    /**
     * 初始角度位置
     */
    private float startAngel = -90;

    /**
     * 变化的半径
     */
    private int changeR = 40;
    /**
     * 最大半径
     */
    private int maxR = 400;
    /**
     * 内圈半径
     */
    private int minR = 90;

    /**
     * 图像起点XY
     */
    private int left = 100;
    private int top = 100;

    /**
     * 文字大小
     */
    private int textSize = 30;

    public PercentRoundView(Context context) {
        super(context);
    }

    public PercentRoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentRoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int right = left+maxR*2;
        int bottom = top+maxR*2;
        RectF rectF = new RectF(left, top, right, bottom);
        paint = new Paint();
        textPaint = new Paint();          // 创建画笔
        for(int i = 0 ; i < percents.length ; i++) {
            paint.setColor(ringColor[i]); //设置颜色
            paint.setStyle(Paint.Style.FILL); //设置空心
            rectF.set(left + i*changeR, top + i*changeR, right - i*changeR, bottom - i*changeR);
            paint.setAntiAlias(true);  //消除锯齿
            double x;
            double y;
            if(i != 0) {
                startAngel = startAngel - percents[i] * 360 / 100;
                textPaint.setColor(ringColor[i]);        // 设置颜色
                textPaint.setStyle(Paint.Style.FILL);   // 设置样式
                textPaint.setTextSize(textSize);              // 设置字体大小
                //按照变化半径的三分之二递减文字位置
                x = (left+right)/2 + (maxR - changeR * (i-1) * 2/3) * Math.cos((startAngel+percents[i] * 360 / 100/2)/180*Math.PI);
                y = (top+bottom)/2 + (maxR - changeR * (i-1) * 2/3) * Math.sin((startAngel+percents[i] * 360 / 100/2)/180*Math.PI);
            }else{
                //第一个
                //TODO 文字
                textPaint.setColor(Color.WHITE);        // 设置颜色
                textPaint.setStyle(Paint.Style.FILL);   // 设置样式
                textPaint.setTextSize(textSize);              // 设置字体大小
                x = (left+right)/2 + (maxR-minR)/2 * Math.cos((startAngel+percents[i] * 360 / 100/2)/180*Math.PI);
                y = (top+bottom)/2 + (maxR-minR)/2 * Math.sin((startAngel+percents[i] * 360 / 100/2)/180*Math.PI);
            }
            canvas.drawArc(rectF, startAngel, percents[i] * 360 / 100, true, paint); //画出圆环
            //TODO
            canvas.drawText(percents[i]+"%",(float) x,(float) y,textPaint);//画出文字
        }
        paint.setColor(Color.WHITE); //设置颜色
        canvas.drawCircle((left+right)/2, (top + bottom)/2,  minR,  paint); //画出小圆
    }

    /**
     * 设置百分比
     * 设置每个百分比对应的颜色
     * @param percents
     */
    public void setPercents(float[] percents,int[] ringColor) {
        this.percents = percents;
        this.ringColor = ringColor;
    }

    /**
     * 设置初始的角度
     * @param startAngel
     */
    public void setStartAngel(float startAngel) {
        this.startAngel = startAngel;
    }

    /**
     * 设置递减的半径
     * @param changeR
     */
    public void setChangeR(int changeR) {
        this.changeR = changeR;
    }

    /**
     * 设置第一次的半径
     * @param maxR
     */
    public void setMaxR(int maxR) {
        this.maxR = maxR;
    }

    /**
     * 设置内圈半径
     * @param minR
     */
    public void setMinR(int minR) {
        this.minR = minR;
    }

    /**
     * 设置图形的左上x坐标
     * @param left
     */
    public void setLeftPostion(int left) {
        this.left = left;
    }
    /**
     * 设置图形的左上y坐标
     * @param top
     */
    public void setTopPostion(int top) {
        this.top = top;
    }

}
