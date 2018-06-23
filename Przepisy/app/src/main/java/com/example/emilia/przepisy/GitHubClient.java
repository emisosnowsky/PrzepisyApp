package com.example.emilia.przepisy;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
    @GET("/users/{user}/repos")
    retrofit2.Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}