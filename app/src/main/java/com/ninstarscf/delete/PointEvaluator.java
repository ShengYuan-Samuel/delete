package com.ninstarscf.delete;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * @author Samuel
 * @time 2018/9/28 12:01
 * @describe
 */
public class PointEvaluator implements TypeEvaluator<PointF> {
    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        float x = startValue.x + fraction * (endValue.x - startValue.x);
        float y = startValue.y + fraction * (endValue.y - startValue.y);
        return new PointF(x, y);
    }
}
