package yongchao.com.wineapp.ui.set.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import yongchao.com.wineapp.R;

public class LogoutDialog extends Dialog {

    private View layoutView;
    private TextView logout;
    private TextView cancel;
    private LogoutDialogFace dialogFace;

    public void setDialogFace(LogoutDialogFace dialogFace) {
        this.dialogFace = dialogFace;
    }

    public LogoutDialog(@NonNull Context context) {
        super(context, R.style.MyNewAlertDialog);
        initCameraDialog(context);
    }

    private void initCameraDialog(Context mContext) {
        layoutView = LayoutInflater.from(mContext).inflate(R.layout.dialog_logout, null);
        logout = (TextView) layoutView.findViewById(R.id.tv_logout);
        cancel = (TextView) layoutView.findViewById(R.id.tv_cancel);
        setContentView(layoutView);
        initDialogWindow();
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



    public void showDialog() {
        show();
    }


    private void setOnClickListener() {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogFace != null) {
                    dialogFace.logoutBtn();
                    dismiss();
                }
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogFace != null) {
                    dialogFace.cancelBtn();
                    dismiss();
                }
            }
        });


    }

    public interface LogoutDialogFace {
        void logoutBtn();

        void cancelBtn();


    }
}