package com.aca.andrewott.tagd;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andrewott on 11/4/16.
 */

public interface XboxApiService {

    @GET("/v2/xuid/{gamertag}")
    Call<Xuid> getXuid(@Path("gamertag") String gamertag);

}
