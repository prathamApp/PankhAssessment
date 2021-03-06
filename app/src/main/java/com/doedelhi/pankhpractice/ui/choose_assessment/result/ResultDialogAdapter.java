package com.doedelhi.pankhpractice.ui.choose_assessment.result;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.doedelhi.pankhpractice.AssessmentApplication;
import com.doedelhi.pankhpractice.R;
import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;
import com.doedelhi.pankhpractice.utilities.Assessment_Constants;
import com.doedelhi.pankhpractice.utilities.Assessment_Utility;

import java.util.List;

public class ResultDialogAdapter extends RecyclerView.Adapter<ResultDialogAdapter.MyViewHolder> {
    Context context;
    List<ScienceQuestionChoice> scienceQuestionChoices;
    String type = "";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image, iv_zoom_eye;
        RelativeLayout rl_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_text);
            image = itemView.findViewById(R.id.iv_choice_image);
            iv_zoom_eye = itemView.findViewById(R.id.iv_zoom_eye);
            rl_img = itemView.findViewById(R.id.rl_img);
        }
    }


    public ResultDialogAdapter(Context context, List<ScienceQuestionChoice> scienceQuestionChoices, String type) {
        this.context = context;
        this.scienceQuestionChoices = scienceQuestionChoices;
        this.type = type;
    }

    @NonNull
    @Override
    public ResultDialogAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_simple_text_row_old, viewGroup, false);
        return new ResultDialogAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final ScienceQuestionChoice scienceQuestionChoice = scienceQuestionChoices.get(i);
        Assessment_Utility.setOdiaFont(context, myViewHolder.text);
        myViewHolder.text.setTextColor(Color.BLACK);
        if (type.equalsIgnoreCase("que")) {
            if (!scienceQuestionChoice.getChoiceurl().equalsIgnoreCase("")) {
                myViewHolder.rl_img.setVisibility(View.VISIBLE);
                myViewHolder.image.setVisibility(View.VISIBLE);
                myViewHolder.text.setVisibility(View.GONE);

                Glide.with(context).asBitmap().
                        load(scienceQuestionChoice.getChoiceurl()).apply(new RequestOptions()
                        .fitCenter()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .override(Target.SIZE_ORIGINAL))
                        .into(myViewHolder.image);
            } else {
                myViewHolder.rl_img.setVisibility(View.GONE);
                myViewHolder.text.setText(Html.fromHtml(scienceQuestionChoice.getChoicename()));
            }
        } else {
            if (type.equalsIgnoreCase("ans")) {
                if (!scienceQuestionChoice.getMatchingurl().equalsIgnoreCase("")) {
                    myViewHolder.rl_img.setVisibility(View.VISIBLE);
                    myViewHolder.image.setVisibility(View.VISIBLE);
                    myViewHolder.text.setVisibility(View.GONE);

                    Glide.with(context).asBitmap().
                            load(/*Assessment_Constants.loadOnlineImagePath +*/ scienceQuestionChoice.getMatchingurl()).apply(new RequestOptions()
                            .fitCenter()
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .override(Target.SIZE_ORIGINAL))
                            .into(myViewHolder.image);

                    myViewHolder.iv_zoom_eye.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("QQQ", "choice clicked....");
                            String path = ""  /*Assessment_Constants.loadOnlineImagePath +*/;
                            String fileName = "";
                            String localPath = "";

                            if (type.equalsIgnoreCase("que")) {
                                path = scienceQuestionChoice.getChoiceurl();
                                fileName = Assessment_Utility.getFileName(scienceQuestionChoice.getQid(), scienceQuestionChoice.getChoiceurl());
                                localPath = AssessmentApplication.assessPath + Assessment_Constants.STORE_DOWNLOADED_MEDIA_PATH + "/" + fileName;
                            } else if (type.equalsIgnoreCase("ans")) {
                                path = scienceQuestionChoice.getMatchingurl();
                                fileName = Assessment_Utility.getFileName(scienceQuestionChoice.getQid(), scienceQuestionChoice.getMatchingurl());
                                localPath = AssessmentApplication.assessPath + Assessment_Constants.STORE_DOWNLOADED_MEDIA_PATH + "/" + fileName;
                            }
                            Assessment_Utility.showZoomDialog(context, path, localPath,"");
                        }
                    });
                } else {
                    myViewHolder.rl_img.setVisibility(View.GONE);
                    myViewHolder.text.setText(Html.fromHtml(scienceQuestionChoice.getMatchingname()));
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return scienceQuestionChoices.size();
    }
}
