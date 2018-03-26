package com.imageslider;

import retrofit2.Call;
import retrofit2.http.POST;


/**
 * Created by android3 on 26/8/16.
 */
public interface Service {

    @POST("clubapp/web/news.php")
    Call<MyBean> signin_Service();

/*    @POST("/login")
    Call<Login_Response> login_Service(@Body LoginModal loginModal);

    @POST("/change_password")
    Call<Event_Response> changepassword_Service(@Header("token") String token, @Body ChangePasswordModal loginModal);

    @POST("/login")
    Call<Login_Response> login_Service_for_social_network(@Body LoginModalforSocialnetwork loginModal);

    @POST("/events")
    Call<Event_Response> event_Service(@Body EventModal eventModal);

    @POST("/login_events")
    Call<Event_Response> event_Service(@Header("token") String token, @Body EventModal eventModal);

    @POST("/forgot-password")
    Call<Login_Response> password_Change_Service(@Body PasswordModal passwordModal);

    @GET("maps/api/directions/json")
    Call<MyPojo> getDistance(@Query("origin") String origin,
                             @Query("destination") String destination,
                             @Query("sensor") boolean sensor, @Query("mode") String mode);

    @GET("maps/api/geocode/json?")
    Call<GeocoderResponse> getName(@Query("latlng") String origin, @Query("sensor") boolean sensor);

    @POST("/report_spam")
    Call<Event_Response> report_Problem_Service(@Header("token") String token, @Body ReportaProblemModal eventModal);

    @POST("/hashtags")
    Call<HashTagResponse> get_Hashtag_Service(@Header("token") String token, @Body Language language);

    @POST("/add_hashtags")
    Call<Event_Response> add_Hashtag_Service(@Header("token") String token, @Body AddHashTagModal addHashTagModal);
    @POST("/add_to_list")
    Call<Event_Response> add_to_going_Service(@Header("token") String token, @Body AddToGoingModal addToGoingModal);
    @POST("/my_profile")
    Call<Profile> get_profile_data(@Header("token") String token, @Body Language language);
    @POST("/contact_us")
    Call<Profile> contact_us_data(@Header("token") String token, @Body ContactUsModal contactUsModal);
    @Multipart
    @POST("/profile_photo")
    Call<ImageResponse> add_profile_image(@Header("token") String token, @Part MultipartBody.Part part);
    @POST("/invitation")
    Call<AppInviteResponse> inviteFriendsToApp(@Header("token") String token, @Body AppInvite appInvite);*/
}
