package ru.comrade77.core.network

interface HttpClient {
    fun makeRequest(isError: Boolean): String
}

class DemoHttpClient : HttpClient {
    override fun makeRequest(isError: Boolean): String {
        println("Make Resuest")
        return if (isError) "Error" else "Success"
    }

}