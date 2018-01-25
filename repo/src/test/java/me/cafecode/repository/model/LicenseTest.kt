package me.cafecode.repository.model

import com.google.gson.GsonBuilder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class LicenseTest {

    lateinit var repo: Repo

    @Before
    fun setUp() {
        val gson = GsonBuilder()
                .create()
        val json = this::class.java.getResource("/get_repository.json").readText()
        repo = gson.fromJson(json, Repo::class.java)
        assertNotNull(repo)
    }

    @Test
    fun license() {
        val license = repo.license!!
        assertEquals("mit", license.key)
        assertEquals("MIT License", license.name)
        assertEquals("MIT", license.spdxId)
        assertEquals("https://api.github.com/licenses/mit", license.url)
        assertEquals("http://choosealicense.com/licenses/mit/", license.htmlUrl)
    }

}
