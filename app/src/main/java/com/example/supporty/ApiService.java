package com.example.supporty;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("/user/signup") //회원가입 라우트. 해당 경로로 서버에 POST 요청 보냄
    // 파라미터로 data 보내고 요청은 SignupRes 클래스의 콜백함수로...
    Call<SignupRes> signupRequest(@Body SignupData data);
    @GET("/user/checkId") //아이디 중복확인 라우트
    Call<Boolean> checkId(@Query("id")String id);

    @POST("/user/login") //로그인 라우트
    //로그인은 LoginRes 클래스의 콜백함수로 받음
    Call<LoginRes> loginRequest(@Body SignupData data);

    @DELETE("/user/delete") // 회원탈퇴 라우트
    Call<Void> deleteRequest(@Query("id") String id);

    @GET("diary/feelings/big") //큰 감정 가져오기
    Call<List<BigFeel>> getBigFeelings();

    @GET("diary/feelings/mid") //중간 감정 가져오기
    Call<List<MidFeel>> getMidFeelings(@Query("big_feeling") String bigFeeling);

    @GET("diary/feelings/small") //작은 감정 가져오기
    Call<List<SmallFeel>> getSmallFeelings(@Query("mid_feeling") String midFeeling);

    @POST("/diary/posting") //일기 등록
    Call<Void> postDiary(@Body DiaryData diary);

    @POST("/diary/editPosting")
    Call<Void> editDiary(@Body DiaryData diary);

    @GET("/diary/postingList")
    Call<List<DiaryData>> getDiaries(@Query("id") String id);

    @DELETE("/diary/delete")
    Call<Void> deleteDiary(@Query("id") String id, @Query("diary_date") String diaryDate);

}

