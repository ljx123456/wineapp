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

public class SelectPhotoDialog extends Dialog {

    private View layoutView;
    private TextView photo;
    private TextView video;
    private TextView dialogOver;
    private SelectPhotoDialogFace dialogFace;

    public void setDialogFace(SelectPhotoDialogFace dialogFace) {
        this.dialogFace = dialogFace;
    }

    public SelectPhotoDialog(@NonNull Context context) {
        super(context, R.style.MyNewAlertDialog);
        initCameraDialog(context);
    }

    private void initCameraDialog(Context mContext) {
        layoutView = LayoutInflater.from(mContext).inflate(R.layout.dialog_select_photo, null);
        photo = (TextView) layoutView.findViewById(R.id.tv_photo);
        video = (TextView) layoutView.findViewById(R.id.tv_camera);
        dialogOver =  layoutView.findViewById(R.id.tv_cancel);
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
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogFace != null) {
                    dialogFace.photoBtn();
                    dismiss();
                }
            }
        });

        dialogOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogFace != null) {
                    dialogFace.cameraBtn();
                    dismiss();
                }
            }
        });


    }

    public interface SelectPhotoDialogFace {
        void photoBtn();

        void cameraBtn();


    }
}