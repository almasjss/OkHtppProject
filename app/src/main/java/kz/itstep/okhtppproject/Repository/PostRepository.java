package kz.itstep.okhtppproject.Repository;

import java.util.List;

import kz.itstep.okhtppproject.ApiService.ApiService;
import kz.itstep.okhtppproject.Model.Post;
import retrofit2.Call;

public class PostRepository {
    private final ApiService apiService;

    public PostRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Call<List<Post>> getPosts(){
        return apiService.getPosts();
    }
}
