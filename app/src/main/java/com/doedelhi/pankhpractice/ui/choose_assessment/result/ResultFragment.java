package com.doedelhi.pankhpractice.ui.choose_assessment.result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doedelhi.pankhpractice.R;
import com.doedelhi.pankhpractice.custom.FastSave;
import com.doedelhi.pankhpractice.database.AppDatabase;
import com.doedelhi.pankhpractice.domain.AssessmentPaperForPush;
import com.doedelhi.pankhpractice.domain.AssessmentPaperPattern;
import com.doedelhi.pankhpractice.domain.ResultModalClass;
import com.doedelhi.pankhpractice.domain.ResultOuterModalClass;
import com.doedelhi.pankhpractice.ui.choose_assessment.result.ThankYouFragment_;
import com.doedelhi.pankhpractice.ui.choose_assessment.science.certificate.CertificateSubjects.CertificateFragment;
import com.doedelhi.pankhpractice.ui.choose_assessment.science.certificate.CertificateSubjects.CertificateFragment_;
import com.doedelhi.pankhpractice.utilities.Assessment_Constants;
import com.doedelhi.pankhpractice.utilities.Assessment_Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;
import java.util.Objects;

import static com.doedelhi.pankhpractice.utilities.Assessment_Constants.SCORE_COUNT;

/*import butterknife.ButterKnife;
import butterknife.OnClick;*/

@EFragment(R.layout.fragment_result)
public class ResultFragment extends Fragment implements ResultListener {

    @ViewById(R.id.rv_question_answers)
    RecyclerView rv_question_answers;
    @ViewById(R.id.tv_out_of_marks)
    TextView tv_out_of_marks;
    @ViewById(R.id.tv_name)
    TextView tv_name;
    @ViewById(R.id.tv_marks_obtained)
    TextView tv_marks_obtained;
    @ViewById(R.id.tv_topic)
    TextView tv_topic;
    @ViewById(R.id.tv_subject)
    TextView tv_subject;
    @ViewById(R.id.btn_done)
    Button btn_done;
    /*@ViewById(R.id.toolbar)
    Toolbar mToolbar;*/
//    @ViewById(R.id.app_bar)
//    AppBarLayout mAppBarLayout;
    @ViewById(R.id.rl_result)
    RelativeLayout rl_result;
    @ViewById(R.id.rl_thanks)
    RelativeLayout rl_thanks;
    @ViewById(R.id.rl_studInfo)
    RelativeLayout rl_studInfo;
    @ViewById(R.id.student_name)
    TextView student_name;
    /*   @BindView(R.id.certificate_frame)
       FrameLayout certificate_frame;*/
    @Bean(ResultPresenter.class)
    ResultContract.ResultPresenter presenter;
    List<ResultModalClass> resultList;
    ResultOuterModalClass outerModalClass;
    String outOfMarks, marksObtained, studentId, examStartTime, examEndTime, examId, subjectId, paperId;


    public ResultFragment() {
        // Required empty public constructor
    }

    @AfterViews
    public void init() {
        outerModalClass = (ResultOuterModalClass) getActivity().getIntent().getSerializableExtra("result");
        resultList = outerModalClass.getResultList();
        outOfMarks = outerModalClass.getOutOfMarks();
        marksObtained = outerModalClass.getMarksObtained();
        studentId = outerModalClass.getStudentId();
        examStartTime = outerModalClass.getExamStartTime();
        examEndTime = outerModalClass.getExamEndTime();
        examId = outerModalClass.getExamId();
        subjectId = outerModalClass.getSubjectId();
        paperId = outerModalClass.getPaperId();
        tv_marks_obtained.setText(marksObtained);
        tv_out_of_marks.setText(outOfMarks);

   /*     Bundle bundle = new Bundle();
        bundle.putSerializable("result", outerModalClass);
        Assessment_Utility.showFragment(getActivity(), new CertificateFragment(), R.id.certificate_frame, bundle, CertificateFragment.class.getSimpleName());
*/
        String studentName = presenter.getStudent(studentId);
        tv_name.setText(studentName);

        btn_done.setVisibility(View.GONE);
        /*if (!Assessment_Constants.supervisedAssessment || !Assessment_Constants.ASSESSMENT_TYPE.equalsIgnoreCase("supervised")) {*/
        if (!FastSave.getInstance().getBoolean(Assessment_Constants.SUPERVISED, false)) {
            rl_thanks.setVisibility(View.GONE);
//        presenter = new ResultPresenter(getActivity());

          /*  mToolbar.setTitle(studentName);
            mToolbar.setTitleTextColor(Color.WHITE);
            mToolbar.setSubtitleTextColor(Color.WHITE);
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
*/
            rl_studInfo.setBackgroundColor(Assessment_Utility.selectedColor);
            student_name.setText(studentName);
            String subName = presenter.getSubjectName(examId);
            String topicName = presenter.getTopicName(examId);
            tv_topic.setText(topicName);
            tv_subject.setText(subName);
            ResultAdapter resultAdapter = new ResultAdapter(getActivity(), resultList, this);
            rv_question_answers.setAdapter(resultAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rv_question_answers.setLayoutManager(linearLayoutManager);
            resultAdapter.notifyDataSetChanged();

//        AppBarLayout mAppBarLayout = view.findViewById(R.id.app_bar);
/*            mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                //            boolean isShow = false;
                int scrollRange = -1;

                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (scrollRange == -1) {
                        scrollRange = appBarLayout.getTotalScrollRange();
                    }
                }
            });*/
        } else {
            rl_result.setVisibility(View.GONE);
//            mAppBarLayout.setVisibility(View.GONE);
            btn_done.setVisibility(View.GONE);
            Bundle bundle = new Bundle();
            bundle.putString("studentName", studentName);
            bundle.putString(SCORE_COUNT, marksObtained + "/" + outOfMarks);
            Assessment_Utility.showFragment(getActivity(), new ThankYouFragment_(), R.id.frame_thanks, bundle, ThankYouFragment.class.getName());


           /* rl_result.setVisibility(View.GONE);
            mAppBarLayout.setVisibility(View.GONE);
            rl_thanks.setVisibility(View.VISIBLE);
            btn_done.setVisibility(View.GONE);*/
        }
    }
  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }
*/
/*    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Toolbar mToolbar = view.findViewById(R.id.toolbar);
        ButterKnife.bind(this, view);
//        resultList = (List<ResultModalClass>) getIntent().getSerializableExtra("result");
        outerModalClass = (ResultOuterModalClass) getActivity().getIntent().getSerializableExtra("result");
        resultList = outerModalClass.getResultList();
        outOfMarks = outerModalClass.getOutOfMarks();
        marksObtained = outerModalClass.getMarksObtained();
        studentId = outerModalClass.getStudentId();
        examStartTime = outerModalClass.getExamStartTime();
        examEndTime = outerModalClass.getExamEndTime();
        examId = outerModalClass.getExamId();
        subjectId = outerModalClass.getSubjectId();
        paperId = outerModalClass.getPaperId();
        tv_marks_obtained.setText(marksObtained);
        tv_out_of_marks.setText(outOfMarks);

   *//*     Bundle bundle = new Bundle();
        bundle.putSerializable("result", outerModalClass);
        Assessment_Utility.showFragment(getActivity(), new CertificateFragment(), R.id.certificate_frame, bundle, CertificateFragment.class.getSimpleName());
*//*
        btn_done.setVisibility(View.GONE);

        presenter = new ResultPresenter(getActivity());
        String studentName = presenter.getStudent(studentId);
        mToolbar.setTitle(studentName);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setSubtitleTextColor(Color.WHITE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

        String subName = presenter.getSubjectName(examId);
        String topicName = presenter.getTopicName(examId);
        tv_topic.setText(topicName);
        tv_subject.setText(subName);
        ResultAdapter resultAdapter = new ResultAdapter(getActivity(), resultList, this);
        rv_question_answers.setAdapter(resultAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_question_answers.setLayoutManager(linearLayoutManager);
        resultAdapter.notifyDataSetChanged();

        AppBarLayout mAppBarLayout = view.findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            //            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
            }
        });
    }*/


    @Click({R.id.btn_done, R.id.btn_ok})
    public void onDoneClick() {

        AssessmentPaperPattern paperPattern = AppDatabase.getDatabaseInstance(getActivity()).getAssessmentPaperPatternDao().getAllAssessmentPaperPatternsBySubIdAndExamId(subjectId, examId);

        if (!FastSave.getInstance().getBoolean(Assessment_Constants.SUPERVISED, false)) {
            if (paperPattern.getNoofcertificateq() != null) {
                if (paperPattern.getNoofcertificateq().equalsIgnoreCase("") || Integer.parseInt(paperPattern.getNoofcertificateq()) == 0) {
                    sendResult();
                } else {
                    AssessmentPaperForPush assessmentPaperForPush = AppDatabase.getDatabaseInstance(getActivity()).getAssessmentPaperForPushDao().getAssessmentPapersByPaperId(paperId);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("assessmentPaperForPush", assessmentPaperForPush);
                    Assessment_Utility.showFragment(getActivity(), new CertificateFragment_(), R.id.certificate_frame, bundle, CertificateFragment.class.getSimpleName());
                }
            } else {
                sendResult();
            }
        } else {
            sendResult();
        }
    }

    private void sendResult() {
        Intent intent = new Intent();
        intent.putExtra(SCORE_COUNT, outerModalClass.getMarksObtained() + "/" + outerModalClass.getOutOfMarks());
        Objects.requireNonNull(getActivity()).setResult(Activity.RESULT_OK, intent);
        Objects.requireNonNull(getActivity()).finish();
    }

    @Override
    public void showDone(boolean visibility) {
        if (visibility)
            btn_done.setVisibility(View.VISIBLE);
        else btn_done.setVisibility(View.GONE);

    }
}
