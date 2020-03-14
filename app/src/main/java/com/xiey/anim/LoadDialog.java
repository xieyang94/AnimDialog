package com.xiey.anim;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class LoadDialog {
    private Context context;
    private Dialog dialog;

    private Display display;
    private EatFish mEatFish;
    private TextView mTvContent;

    public LoadDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public LoadDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_load, null);

        // 设置Dialog最小宽度为屏幕宽度
        view.setMinimumWidth(display.getWidth());

        // 获取自定义Dialog布局中的控件
        mEatFish = view.findViewById(R.id.eat_fish);
        mTvContent = view.findViewById(R.id.tv_content);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        dialog.setContentView(view);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 50;
        lp.width = display.getWidth() - 300;
        dialogWindow.setAttributes(lp);

        return this;
    }

    public LoadDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public LoadDialog setCanceledOnTouchOutside(boolean cancel) {
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

    public LoadDialog setContent(String mContent) {
        if (!TextUtils.isEmpty(mContent)) {
            mTvContent.setText(mContent);
        }
        return this;
    }

    public void show() {
        if (mEatFish != null) {
            mEatFish.startAnimation();
        }
        if (dialog != null) {
            dialog.show();
            dialog = null;
        }
    }

    public void dismiss() {
        if (mEatFish != null) {
            mEatFish.startAnimation();
        }
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

}
