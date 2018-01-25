package me.cafecode.repository.api

import com.google.gson.GsonBuilder
import okhttp3.Headers
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GithubApiTest {

    lateinit var api: GithubApi
    val mockWebServer = MockWebServer()

    @Before
    fun setUp() {
        val gson = GsonBuilder().create()
        api = Retrofit.Builder()
                .baseUrl(mockWebServer.url("/test/"))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GithubApi::class.java)
    }

    @Test
    fun getRepositories() {
        val json = this::class.java.getResource("/get_repositories.json").readText()
        val mockResponse = MockResponse().setBody(json).setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val testSubscriber = api.getRepositories().test()

        testSubscriber.assertComplete()
        assertNotNull(testSubscriber.values()[0])
    }

    @Test
    fun getNextPageRepositories() {
        val json = this::class.java.getResource("/get_repositories_since_368.json").readText()
        val mockResponse = MockResponse().setBody(json)
                .setHeaders(Headers.of(hashMapOf("https://api.github.com/repositories?since=368" to "next")))
        mockWebServer.enqueue(mockResponse)

        val testSubscriber = api.getNextPageRepositories("368").test()

        testSubscriber.assertComplete()
        assertNotNull(testSubscriber.values()[0])
    }

    @Test
    fun getRepository() {
        val json = this::class.java.getResource("/get_repository.json").readText()
        val mockResponse = MockResponse().setBody(json).setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val testSubscriber = api.getRepository("octocat", "Hello-World").test()

        testSubscriber.assertComplete()
        assertNotNull(testSubscriber.values()[0])
    }
}
