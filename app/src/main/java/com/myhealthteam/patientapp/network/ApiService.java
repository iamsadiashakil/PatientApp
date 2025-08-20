package com.myhealthteam.patientapp.network;

import com.myhealthteam.patientapp.models.*;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

// ApiService.java
public interface ApiService {
    @POST("api/auth/login")
    Call<AuthResponse> login(@Body AuthRequest request);

    @GET("api/proxies/patient/vitals-summary")
    Call<VitalsSummaryDto> getVitalsSummary(@Header("Authorization") String token);

    @GET("api/proxies/patient/allergies")
    Call<List<AllergyDto>> getAllergies(@Header("Authorization") String token);

    /*@POST("api/auth/register")
    Call<AuthResponse> register(@Body RegistrationRequest request);

    @POST("api/auth/forgot-password")
    Call<Void> forgotPassword(@Query("email") String email);

    @GET("api/proxies/profile")
    Call<HealthcareProxy> getProfile(@Header("Authorization") String token);

    @GET("api/proxies/patient")
    Call<Patient> getAssignedPatient(@Header("Authorization") String token);



    @GET("api/patients/{patientId}/allergies")
    Call<List<AllergyRecord>> getAllergies(@Path("patientId") Long patientId,
                                           @Header("Authorization") String token);

    @GET("api/patients/{patientId}/vitals/{type}")
    Call<List<VitalsRecord>> getVitals(@Path("patientId") Long patientId,
                                       @Path("type") String type,
                                       @Header("Authorization") String token);

    @GET("api/proxies/patient/conversations")
    Call<List<Chat>> getConversations(@Header("Authorization") String token);

    @GET("api/patients/{patientId}/messages")
    Call<List<Message>> getMessages(@Path("patientId") Long patientId,
                                    @Query("staffId") String staffId,
                                    @Header("Authorization") String token);

    @POST("api/proxies/patient/messages")
    Call<Message> sendMessage(@Query("staffId") Long staffId,
                              @Body Message message,
                              @Header("Authorization") String token);*/
}