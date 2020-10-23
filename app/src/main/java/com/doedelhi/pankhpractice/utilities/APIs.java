package com.doedelhi.pankhpractice.utilities;

public class APIs {
    private APIs() {
    }

    public static final String village = "village";
    public static final String CRL = "CRL";
    public static final String Group = "Groups";
    public static final String Student = "Student";

    //Azure APIs

//    public static String baseAzureURL = "http://delhigovt.centralindia.cloudapp.azure.com:8081/";
    public static String baseAzureURL = "http://52.172.149.226/";
    public static String AssessmentLanguageAPI = baseAzureURL + "api/language/GetLanguage";
    public static String AssessmentSubjectAPI = baseAzureURL + "api/subject/GetSubjectv2?languageid=";
    public static String AssessmentQuestionAPI = baseAzureURL + "api/question/GetQuestion?";
    public static String AssessmentExamAPI = baseAzureURL + "api/subjectexam/GetExamV2?subjectid=";
    public static String AssessmentEnrollmentNoExamAPI = baseAzureURL + "api/exampaper/GetStudentExamListV2?studentid=";
    public static String AssessmentPaperPatternAPI = baseAzureURL + "api/exampattern/GetExamPattern?examid=";
    public static String pullCertificateByStudIdAPI = baseAzureURL + "api/certificate/GetCertificate?studentid=";
    public static String pullCertificateByDeviceIdAPI = baseAzureURL + "api/certificate/GetCertificateByDeviceID?deviceid=";

    public static String pullStudentByEnrollmentNoAPI = "http://delhigovt.centralindia.cloudapp.azure.com:8083/api/StudentEnrollment?enrollmentno=";



}
