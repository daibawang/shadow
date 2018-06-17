package com.sgcy.shadow.local_choose;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sgcy.shadow.R;


/**
 * Created by sgcy on 2018/6/10.
 * 自定义快速索引
 *
 * 1.把26个字母放在数组里面
 * 2.在onMeasure计算每条的高在onMeasure计算每条的高itemHeight和宽itemWidth和宽itemWidth;
 * 3.在onDraw里计算wordWidth,wordHeight,wordX,wordY;
 *
 * 手指按下，字母变色
 * 1.重写onTouchEvent(),返回true, 在down/move的过程中计算
 *         int touchIndex = Y/itemHeight;    得到手指位置的字母，
 * 2.在onDraw()方法对应的下标设置画笔变色
 *
 * 3.在up的时候，touchIndex = -1;
 *
 */
public class IndexView extends View {


    private String[] words = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    /**
     * 每个字母所占的item的高和宽
     */
    private int itemWidth;
    private int itemHeight;

    private Paint paint;


    public IndexView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * 初始化画笔
         */
        paint = new Paint();
        paint.setTextSize(30);
        paint.setColor(Color.WHITE);    //白色
        paint.setAntiAlias(true);   //抗锯齿
        paint.setTypeface(Typeface.DEFAULT_BOLD);    //粗体
    }    /**
     * 测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        itemWidth = getMeasuredWidth();
        itemHeight = getMeasuredHeight() / words.length;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i=0; i < words.length; i++){

            if(touchIndex == i){
                //设置灰色
                paint.setColor(Color.GRAY);
            }else {
                //设置粉色
                paint.setColor(getResources().getColor(R.color.colorPrimary));

            }

            String word = words[i];

            Rect rect = new Rect();     //创建一个矩形

            paint.getTextBounds(word, 0, 1, rect);      //用矩形去套字母，方便得到字母的宽高

            /**
             * 得到字母的宽高
             */
            int wordWidth = rect.width();
            int wordHight = rect.height();

            //计算字母的绘制坐标
            float wordX = itemWidth/2 - wordWidth/2;
            float wordY = itemHeight/2 + wordHight/2 + i*itemHeight;

            canvas.drawText(word, wordX, wordY, paint); //绘制

        }
    }

    private int touchIndex = -1; //字母的下标位置

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:

                float Y = event.getY();
                int index = (int) (Y/itemHeight);       //得到字母的位置

                if(index != touchIndex){
                    touchIndex = index;
                    invalidate();   //强制绘制, onDraw()会重写执行
                    if(onIndexChangeListener != null && touchIndex < words.length){
                        onIndexChangeListener.onIndexChange(words[touchIndex]);
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                touchIndex = -1;
                invalidate();
                break;

        }

        return true;
    }


    /**
     * 字母下标索引变化的监听器
     */
    public interface OnIndexChangeListener{

        void onIndexChange(String word);
    }

    private OnIndexChangeListener onIndexChangeListener;

    public void setOnIndexChangeListener(OnIndexChangeListener onIndexChangeListener){
        this.onIndexChangeListener = onIndexChangeListener;
    }


}
