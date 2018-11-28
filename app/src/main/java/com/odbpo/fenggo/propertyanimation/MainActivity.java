package com.odbpo.fenggo.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 属性动画
 * <p>
 * 什么是属性动画：
 * 属性动画是从3.0及以后出现的（如果要兼容低版本，可以使用一个民间版第三方的一个jar, NineOldAndroid.jar,用法跟系统的用法差不多）。
 * 不断地控制控件的属性变化达到动画的效果，一般我们是一些组合的属性动画达到复杂的效果。
 * <p>
 * 以前都是：补间动画BetweenAnimation、帧动画FrameAnimation
 * 比较之前的View动画，属性动画更加丰富、好用；
 * 属性动画是真实地改变控件的属性，view动画是个假象，平移以后的原来位置还是可以点击的。
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.iv_img)
    ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.iv_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1://平移动画
                executeTranslationAnimation();
                break;
            case R.id.btn2://旋转动画
                executeRotationAnimation();
                break;
            case R.id.btn3://缩放动画
                executeScaleAnimation();
                break;
            case R.id.btn4://透明度动画
                executeAlphaAnimation();
                break;
            case R.id.btn5://同时执行多个动画
                executeTogetherAnimation();
                break;
            case R.id.btn6://依次执行多个动画
                executeSequentiallyAnimation();
                break;
            case R.id.iv_img:
                break;
        }
    }

    private float offset1 = 0;

    private void executeTranslationAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivImg, "translationX", offset1, offset1 + 100);//关键帧
        animator.setDuration(1000);
        animator.start();
        offset1 += 100;
    }

    private void executeRotationAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivImg, "rotation", 0, 360);
        animator.setDuration(1000);
        animator.start();
    }

    private void executeScaleAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivImg, "scaleX", 0, 1);
        animator.setDuration(2000);
        animator.start();
    }

    private void executeAlphaAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivImg, "alpha", 0, 1);
        animator.setDuration(5000);
        animator.start();
    }

    private void executeTogetherAnimation() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivImg, "scaleX", 0, 1);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivImg, "scaleY", 0, 1);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(ivImg, "rotation", 0, 360);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator1, animator2, animator3);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    private float offset2 = 0;

    private void executeSequentiallyAnimation() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivImg, "alpha", 0, 1);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivImg, "translationX", offset2, offset2 + 100);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(ivImg, "rotation", 0, 360);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animator1, animator2, animator3);
        animatorSet.setDuration(2000);
        animatorSet.start();
        offset2 += 100;
    }

}
