package com.doedelhi.pankhpractice.ui.choose_assessment.result;

import android.content.Intent;
import android.os.Bundle;

import com.doedelhi.pankhpractice.BaseActivity;
import com.doedelhi.pankhpractice.R;
import com.doedelhi.pankhpractice.domain.ResultModalClass;
import com.doedelhi.pankhpractice.domain.ResultOuterModalClass;
import com.doedelhi.pankhpractice.ui.choose_assessment.result.ResultFragment_;
import com.doedelhi.pankhpractice.utilities.Assessment_Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.List;

import static com.doedelhi.pankhpractice.utilities.Assessment_Constants.SCORE_COUNT;

@EActivity(R.layout.activity_result)
public class ResultActivity extends BaseActivity implements ResultContract.ResultView {
    List<ResultModalClass> resultList;
    ResultOuterModalClass outerModalClass;
 /*   String outOfMarks, marksObtained, studentId, examStartTime, examEndTime, examId, subjectId, paperId;
    @BindView(R.id.rv_question_answers)
    RecyclerView rv_question_answers;
    @BindView(R.id.tv_out_of_marks)
    TextView tv_out_of_marks;
    @BindView(R.id.tv_marks_obtained)
    TextView tv_marks_obtained;
    @BindView(R.id.tv_topic)
    TextView tv_topic;
    @BindView(R.id.tv_subject)
    TextView tv_subject;

    ResultContract.ResultPresenter presenter;*/


    @AfterViews
    public void init() {
        outerModalClass = (ResultOuterModalClass) getIntent().getSerializableExtra("result");
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", outerModalClass);
        Assessment_Utility.showFragment(this, new ResultFragment_(), R.id.certificate_frame, bundle, ResultFragment.class.getSimpleName());

    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
//        final Toolbar mToolbar = findViewById(R.id.toolbar);
//        resultList = (List<ResultModalClass>) getIntent().getSerializableExtra("result");
        outerModalClass = (ResultOuterModalClass) getIntent().getSerializableExtra("result");
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", outerModalClass);
        Assessment_Utility.showFragment(this, new ResultFragment(), R.id.certificate_frame, bundle, ResultFragment.class.getSimpleName());

    }
*/

    @Override
    public void onBackPressed() {
        int fragmentCnt = getSupportFragmentManager().getBackStackEntryCount();
        if (fragmentCnt > 1) {
            Intent intent = new Intent();
            intent.putExtra(SCORE_COUNT, outerModalClass.getMarksObtained() + "/" + outerModalClass.getOutOfMarks());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
