package agiletool.msc.bme.hu.agiletoolandroidclient.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.util.Date;

import javax.inject.Singleton;

import agiletool.msc.bme.hu.agiletoolandroidclient.helper.RuntimeTypeAdapterFactory;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.BacklogItem;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Bug;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Task;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.UserStory;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.followRedirects(false);
        builder.addInterceptor(new AddCookiesInterceptor());
        builder.addInterceptor(logging);
        OkHttpClient httpClient = builder.build();

        RuntimeTypeAdapterFactory<BacklogItem> adapterFactory = RuntimeTypeAdapterFactory
                .of(BacklogItem.class, "type")
                .registerSubtype(Bug.class, "BUG")
                .registerSubtype(Task.class, "TASK")
                .registerSubtype(UserStory.class, "USER_STORY");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(adapterFactory)
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .create();

        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    public LoginApi provideArtistsApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }

    @Provides
    @Singleton
    public ProjectApi provideProjectApi(Retrofit retrofit) {
        return retrofit.create(ProjectApi.class);
    }

    @Provides
    @Singleton
    public DashboardApi provideDashboardApi(Retrofit retrofit) {
        return retrofit.create(DashboardApi.class);
    }

    @Provides
    @Singleton
    public BacklogApi provideBacklogApi(Retrofit retrofit){
        return retrofit.create(BacklogApi.class);
    }
}
