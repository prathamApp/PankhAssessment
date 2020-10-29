package com.doedelhi.pankhpractice.utilities;

import android.net.Uri;

import com.doedelhi.pankhpractice.AssessmentApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

import java.io.File;

import static com.doedelhi.pankhpractice.utilities.Assessment_Utility.getFileExtension;

public class FrescoUtils {

    public static void setImage(String path, String localPath, SimpleDraweeView image) {
        String questionExtension = getFileExtension(path);
        //if image is gif
        if (questionExtension.equalsIgnoreCase("gif")) {
            //set gif from server
            if (AssessmentApplication.wiseF.isDeviceConnectedToMobileOrWifiNetwork()) {
                image.setController(
                        Fresco.newDraweeControllerBuilder()
                                .setImageRequest(ImageRequest.fromUri(path))
                                .setAutoPlayAnimations(true)
                                .build());
            } else {
                //set gif from local storage
                final File file = new File(localPath);
                Uri gifUri = Uri.fromFile(file);
                image.setController(
                        Fresco.newDraweeControllerBuilder()
                                .setUri(gifUri)
                                .setAutoPlayAnimations(true)
                                .build());
            }
        } else {
            Uri imageUri = null;
            if (AssessmentApplication.wiseF.isDeviceConnectedToMobileOrWifiNetwork()) {
                imageUri = Uri.parse(path);
            } else {
                final File file = new File(localPath);
                imageUri = Uri.fromFile(file);
            }
            image.setImageURI(imageUri);
        }

        image.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    }

}
