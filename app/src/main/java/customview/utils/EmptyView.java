package customview.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.l.example.demo1.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wl
 * On 2017/10/26
 * Describe:
 *          当获取数据为空时的 empty 显示，显示内容为：图片 + 文字描述；
 *          其中，图片和文字信息两者中任意一个都可以设定，当不设定时，该 view（imageview 或 textview） 的 visibility 被设置为 gone
 */

public class EmptyView extends RelativeLayout {
    private TextView tvEmptyText;           //空文本显示
    private ImageView imgEmptyImage;        //图片显示
    private LinearLayout llRootView;      //layout_emptyview 的根布局
    private int rootViewBackgroundColor;       //根布局 的 背景色
    private int rootViewGravity;            //img重心
    private int strTextColor;
    private int strTextSize = 15;            //默认文字大小
    private Drawable imgEmptyDrawable;          // 空图片
    private String strEmptyDescription;
    private Drawable imgErrorDrawable;          // 请求失败图片
    private String strErrorDescription;
    private Drawable imgNoNetworkDrawable;      // 无网络连接
    private String strNoNetworkDescription;

    /**
     * layout_emptyview 的显示位置，可根据实际需要设置
     */
    @IntDef({Position.CENTER, Position.TOP, Position.Bottom, Position.LEFT_BOTTOM, Position.RIGHT_BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    private @interface Position {
        int TOP = 0;            // 顶部
        int CENTER = 1;
        int Bottom = 2;         // 底部
        int LEFT_BOTTOM = 3;    // 左下角
        int RIGHT_BOTTOM = 4;   // 右下角
    }

    /**
     * 显示类型，默认（即：DEFAULT）为不显示，即 visibility == gone
     */
    @IntDef({Type.EMPTY, Type.SHOW, Type.DEFAULT, Type.ERROR, Type.NO_NETWORK})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        int DEFAULT = 11;               //默认为gone
        int SHOW = 12;
        int EMPTY = 13;                 //无数据显示
        int ERROR = 14;                 //通用请求失败显示
        int NO_NETWORK = 15;            //网络请求失败显示
    }

    public EmptyView(@NonNull Context context) {
        super(context);
    }

    public EmptyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public EmptyView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EmptyView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflate(getContext(), R.layout.layout_emptyview, this);
        tvEmptyText = (TextView) findViewById(R.id.tv_empty_view);
        imgEmptyImage = (ImageView) findViewById(R.id.img_empty_view);
        llRootView = (LinearLayout) findViewById(R.id.ll_empty_view);

        //TODO 自定义文字样式
        Typeface fontFace = Typeface.createFromAsset(getContext().getAssets(), "text_style/FZ.TTF");
        tvEmptyText.setTypeface(fontFace);

        llRootView.setBackgroundColor(rootViewBackgroundColor);
//        this.setBackgroundColor(Color.YELLOW);
        setImageEmptyImageGravity(rootViewGravity);
        setTextContent(strEmptyDescription, strTextColor);
        setImageView(imgEmptyDrawable);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.EmptyView);
        strTextColor = typedArray.getColor(R.styleable.EmptyView_strTextColor, Color.GRAY);
        strTextSize = typedArray.getDimensionPixelSize(R.styleable.EmptyView_strTextSize, 15);
        rootViewGravity = typedArray.getInt(R.styleable.EmptyView_rootViewGravity, Position.CENTER);
        rootViewBackgroundColor = typedArray.getColor(R.styleable.EmptyView_rootViewBackgroundColor, Color.WHITE);
        imgEmptyDrawable = typedArray.getDrawable(R.styleable.EmptyView_imgEmptyDrawable);
        strEmptyDescription = typedArray.getString(R.styleable.EmptyView_strEmptyDescription);
        imgErrorDrawable = typedArray.getDrawable(R.styleable.EmptyView_imgErrorDrawable);
        strErrorDescription = typedArray.getString(R.styleable.EmptyView_strErrorDescription);
        imgNoNetworkDrawable = typedArray.getDrawable(R.styleable.EmptyView_imgNoNetwork);
        strNoNetworkDescription = typedArray.getString(R.styleable.EmptyView_strNoNetworkDescription);
        typedArray.recycle();
    }

    /**
     * 设置空imageview的gravity
     *
     * @param rootViewgravity
     */
    private void setImageEmptyImageGravity(int rootViewgravity) {
        switch (rootViewgravity) {
            case Position.TOP:
                llRootView.setGravity(Gravity.TOP);
                break;
            case Position.CENTER:
                llRootView.setGravity(Gravity.CENTER);
                break;
            case Position.Bottom:
                llRootView.setGravity(Gravity.BOTTOM);
                break;
            case Position.LEFT_BOTTOM:
                llRootView.setGravity(Gravity.LEFT | Gravity.BOTTOM);
                break;
            case Position.RIGHT_BOTTOM:
                llRootView.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
                break;
        }
    }

    private void setImageView(Drawable imgDrawable) {
        if (imgEmptyImage == null || imgDrawable == null) {
            imgEmptyImage.setVisibility(View.GONE);
        } else {
            if (imgEmptyImage.getVisibility() != View.VISIBLE)
                imgEmptyImage.setVisibility(View.VISIBLE);
            imgEmptyImage.setImageDrawable(imgDrawable);
        }
    }

    private void setTextContent(CharSequence strTextContent, int textColor) {
        if (TextUtils.isEmpty(strTextContent)) {
            tvEmptyText.setVisibility(View.GONE);
        } else {
            if(tvEmptyText.getVisibility() != View.VISIBLE)
                tvEmptyText.setVisibility(View.VISIBLE);
            tvEmptyText.setTextColor(textColor);
            tvEmptyText.setTextSize(px2sp(strTextSize));
            tvEmptyText.setText(strTextContent);
        }
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public int px2sp(float pxValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    //TODO ****************************************      分割线                    ***************************************************************

    //TODO **************************************      对外提供方法                   ************************************************************

    public void setType(int type) {
        switch (type) {
            case Type.DEFAULT:
                hide();
                break;
            case Type.SHOW:
                show();
                break;
            case Type.EMPTY:
                setImageView(imgEmptyDrawable);
                setTextContent(strEmptyDescription, strTextColor);
                show();
                break;
            case Type.ERROR:
                setImageView(imgErrorDrawable);
                setTextContent(strErrorDescription, strTextColor);
                show();
                break;
            case Type.NO_NETWORK:
                setImageView(imgNoNetworkDrawable);
                setTextContent(strNoNetworkDescription, strTextColor);
                show();
                break;
        }
    }

    public void show() {
        if (this.getVisibility() == View.VISIBLE)
            return;
        this.setVisibility(View.VISIBLE);
    }

    public void hide() {
        if (this.getVisibility() == View.GONE)
            return;
        this.setVisibility(View.GONE);
    }

    public boolean isVisible() {
        return this.getVisibility() == View.VISIBLE ? true : false;
    }

}
