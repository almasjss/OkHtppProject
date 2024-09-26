package kz.itstep.okhtppproject.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kz.itstep.okhtppproject.Model.Post;
import kz.itstep.okhtppproject.Repository.PostRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private final PostRepository postRepository;
    private final MutableLiveData<List<Post>> postLiveData = new MutableLiveData<>();

    public PostViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
        getPosts();

    }

    public LiveData<List<Post>> getPosts(){
        postRepository.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()){
                    postLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable throwable) {

            }


        });
        return postLiveData;
    }
}
