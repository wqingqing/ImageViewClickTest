package com.test.clickimageviewlibrary.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.test.clickimageviewlibrary.utils.Polygon;

import java.util.List;

/**
 * <b>类名称：</b> ClickImageView <br  />
 * <b>类描述：</b> <br  />
 * <b>创建人：</b> wqq <br  />
 * <b>修改人：</b> wqq <br  />
 * <b>修改时间：</b> 2016年10月19日 10:08<br  />
 * <b>修改备注：</b> <br  />
 *
 * @version 1.0.0 <br  />
 */


public class ClickImageView extends ImageView {
    private int height;
    private int width;
    private List<Polygon> polygons;

    public ClickImageView(Context context) {
        super(context);
    }

    public ClickImageView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public ClickImageView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            height = this.getHeight();
            width = this.getWidth();
            float x_point = getXPoint(event.getX());
            float y_point = getYPoint(event.getY());
            List<Polygon> polygons = getPolygons();

            for (int i = 0; i < polygons.size(); i++) {
                if (isBuild(x_point, y_point, polygons.get(i))) {
                    if (onViewClick != null) {
                        onViewClick.onClick(polygons.get(i).getId());
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public List<Polygon> setPolygons(List<Polygon> polygons) {
        this.polygons = polygons;
        return polygons;
    }


    private List<Polygon> getPolygons() {
        return polygons;
    }

    private float getYPoint(float y) {
        return 100 * (y / height);
    }

    private float getXPoint(float x) {
        return 100 * (x / width);
    }


    private boolean isBuild(float x, float y, Polygon polygon) {
        return polygon.contains(x, y);
    }



    /**
     * 点击
     */
    private OnViewClick onViewClick;

    /**
     * 设置监听接口
     * @param onViewClick
     */
    public void setOnViewClickListener(OnViewClick onViewClick) {
        this.onViewClick = onViewClick;
    }

    public interface OnViewClick{
        void onClick(String id);
    }
}
