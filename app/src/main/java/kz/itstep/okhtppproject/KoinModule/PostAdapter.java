package kz.itstep.okhtppproject.KoinModule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Ref;
import kz.itstep.okhtppproject.Model.Post;
import kz.itstep.okhtppproject.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postsList = new ArrayList<>();

    public PostAdapter(){}

    public PostAdapter(List<Post> posts) {
        if (postsList != null) {
            this.postsList = posts;
        }
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item_xml,
                    viewGroup, false);
            return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        Post post = postsList.get(i);
        postViewHolder.tvTitle.setText(post.getTitle());
        postViewHolder.tvBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
    public void setPosts(List<Post> posts){
        this.postsList = posts;
        notifyDataSetChanged();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvBody;

        public PostViewHolder(@NonNull View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
        }
    }

}
