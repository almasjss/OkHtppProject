package kz.itstep.okhtppproject.View;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kz.itstep.okhtppproject.ApiService.ApiService;
import kz.itstep.okhtppproject.KoinModule.AppModule;
import kz.itstep.okhtppproject.KoinModule.PostAdapter;
import kz.itstep.okhtppproject.Model.Post;
import kz.itstep.okhtppproject.R;
import kz.itstep.okhtppproject.Repository.PostRepository;
import kz.itstep.okhtppproject.ViewModel.PostViewModel;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private PostViewModel postViewModel;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter(null);
        postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);

        ApiService apiService = AppModule.getRetrofitInstance().create(ApiService.class);
        PostRepository postRepository = new PostRepository(apiService);

        postViewModel = new PostViewModel(postRepository);
        postViewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postAdapter.setPosts(posts);
            }
        });
    }
}