package kz.itstep.okhtppproject.ApiService;

import java.util.List;

import kz.itstep.okhtppproject.Model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/posts")
    Call<List<Post>> getPosts();
}
