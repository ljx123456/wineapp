package yongchao.com.wineapp.ui.main.util;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.makeramen.roundedimageview.RoundedImageView;


import java.util.ArrayList;
import java.util.function.Consumer;

import yongchao.com.wineapp.R;
import yongchao.com.wineapp.ui.image.ImageBannerInfo;
import yongchao.com.wineapp.ui.image.ImageInfo;
import yongchao.com.wineapp.ui.main.mvp.bean.BannerBean;
import yongchao.com.wineapp.utils.image.ImageLoad;
import yongchao.com.wineapp.utils.intent.intentUtils;


public class BannerUtil {

    public static void setBanner(ConvenientBanner banner, final ArrayList<BannerBean.DataBean> list) {

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Holder createHolder(View itemView) {
                return new LocalImageHolderView(itemView);
            }

            @Override
            public int getLayoutId() {
                return R.layout.item_image;
            }
        }, list)
                .setPageIndicator(new int[]{R.mipmap.banner_control_nor, R.mipmap.banner_control_sel})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(4000)
                .setOnItemClickListener(new OnItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onItemClick(int position) {
//                        if (list.get(position).isAddButton()) {
////                            intentUtils.INSTANCE.intentImage(list.get(position).getTitle(),list.get(position).getUrl());
//                        } else {
                            final ArrayList images = new ArrayList<ImageInfo>();
                            list.forEach(new Consumer<BannerBean.DataBean>() {
                                @Override
                                public void accept(BannerBean.DataBean imageInfo) {
                                    images.add(new ImageInfo(imageInfo.getImage(), false,imageInfo.getId()));
                                }
                            });
                            intentUtils.INSTANCE.intentImage(false, images, position);
//                        }

                    }
                })
                .setCanLoop(true);
    }


    public static class LocalImageHolderView extends Holder<BannerBean.DataBean> {
        private RoundedImageView imageView;
        private ImageView textView;

        public LocalImageHolderView(View itemView) {
            super(itemView);
        }


        @Override
        protected void initView(View itemView) {
            imageView = itemView.findViewById(R.id.itemImage);
            textView = itemView.findViewById(R.id.textView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override
        public void updateUI(BannerBean.DataBean data) {
            //1视频 2图片
//            if (data.isAddButton()) {
//                textView.setVisibility(View.GONE);
//            } else {
//                textView.setVisibility(View.GONE);
////                if (data.getImageId() == 1) {
////                    textView.setVisibility(View.VISIBLE);
////                } else {
////                    textView.setVisibility(View.GONE);
////                }
//            }

            ImageLoad.INSTANCE.setImage(data.getImage(), imageView);
        }
    }
}
