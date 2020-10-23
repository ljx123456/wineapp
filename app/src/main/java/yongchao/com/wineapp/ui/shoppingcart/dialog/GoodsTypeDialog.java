package yongchao.com.wineapp.ui.shoppingcart.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import yongchao.com.wineapp.R;
import yongchao.com.wineapp.utils.view.tag.MultiLineChooseLayout;

public class GoodsTypeDialog extends Dialog {

    private View layoutView;
    private TextView sure;
    private MultiLineChooseLayout tag;
    private GoodsTypeDialogFace dialogFace;

    public void setDialogFace(GoodsTypeDialogFace dialogFace) {
        this.dialogFace = dialogFace;
    }

    public GoodsTypeDialog(@NonNull Context context) {
        super(context, R.style.MyNewAlertDialog);
        initCameraDialog(context);
    }

    private void initCameraDialog(Context mContext) {
        layoutView = LayoutInflater.from(mContext).inflate(R.layout.dialog_goods_type, null);
        sure = (TextView) layoutView.findViewById(R.id.tv_sure);
        tag=layoutView.findViewById(R.id.chooseTag);
        setContentView(layoutView);
        initDialogWindow();
        setList();
        setOnClickListener();
    }

    private void initDialogWindow() {
        Window window = getWindow();
        assert window != null;
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    private void setList(){
        String[] str=new String[]{"罐","箱(12罐)"};
        tag.setList(str);
    }

    public void showDialog() {
        show();
    }


    private void setOnClickListener() {
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogFace != null) {
                    dialogFace.sureBtn();
                    dismiss();
                }
            }
        });




    }

    public interface GoodsTypeDialogFace {
        void sureBtn();
    }
}