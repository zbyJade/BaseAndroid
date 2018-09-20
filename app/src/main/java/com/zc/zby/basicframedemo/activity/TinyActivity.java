package com.zc.zby.basicframedemo.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.base.BaseActivity;
import com.zc.zby.basicframedemo.utils.FileSizeUtil;
import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;

/**
 * Created by ${USER_NAME} on 2018/9/13.
 */
public class TinyActivity extends BaseActivity {
    private String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536928954379&di=b36ccac66d528394a23217fe069eabe2&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fbba1cd11728b4710085bc4e9c9cec3fdfc03239a.jpg";
    @BindView(R.id.drawableImageText)
    protected TextView drawableImageText;
    @BindView(R.id.drawableImage)
    protected SimpleDraweeView drawableImage;
    @BindView(R.id.drawableTinyImageText)
    protected TextView drawableTinyImageText;
    @BindView(R.id.drawableTinyImage)
    protected SimpleDraweeView drawableTinyImage;
    @BindView(R.id.assetsImageText)
    protected TextView assetsImageText;
    @BindView(R.id.assetsImage)
    protected SimpleDraweeView assetsImage;
    @BindView(R.id.assetsTinyImageText)
    protected TextView assetsTinyImageText;
    @BindView(R.id.assetsTinyImage)
    protected SimpleDraweeView assetsTinyImage;
    private Tiny.FileCompressOptions options;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tiny;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initToolBar() {
        getToolbarTitle().setText("Tiny图片压缩");
    }

    @Override
    public void initData() {
        // drawable 原图
        final BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog, bitmapOptions);
        File drawableFile = FileSizeUtil.saveBitmapFile(originBitmap, FileSizeUtil.fileDrawableName);
        drawableImageText.setText("Drawable原图 " + FileSizeUtil.getAutoFileOrFilesSize(drawableFile.getPath()));
        Phoenix.with(drawableImage).load(R.drawable.dog);

        // drawable 压缩图
        options = new Tiny.FileCompressOptions();
        Tiny.getInstance().source(R.drawable.dog).asFile().withOptions(options).compress(new FileCallback() {
            @Override
            public void callback(boolean isSuccess, String outfile, Throwable t) {
                drawableTinyImageText.setText("Drawable压缩图 " + FileSizeUtil.getAutoFileOrFilesSize(outfile));
                Phoenix.with(drawableTinyImage).load(outfile);
            }
        });

        // assets 原图
        Bitmap imageFromAssetsFile = getImageFromAssetsFile("scenery.jpg");
        File assetsFile = FileSizeUtil.saveBitmapFile(imageFromAssetsFile, FileSizeUtil.fileAssetsName);
        assetsImageText.setText("Assets原图 " + FileSizeUtil.getAutoFileOrFilesSize(assetsFile.getPath()));
        Phoenix.with(assetsImage).load(assetsFile.getPath());

        // assets 压缩图
        Tiny.getInstance().source(imageFromAssetsFile).asFile().withOptions(options).compress(new FileCallback() {
            @Override
            public void callback(boolean isSuccess, String outfile, Throwable t) {
                assetsTinyImageText.setText("Assets压缩图 " + FileSizeUtil.getAutoFileOrFilesSize(outfile));
                Phoenix.with(assetsTinyImage).load(outfile);
            }
        });

    }

    /**
     * 从Assets中读取图片
     */
    private Bitmap getImageFromAssetsFile(String fileName) {
        Bitmap image = null;
        AssetManager am = getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;

    }
}
