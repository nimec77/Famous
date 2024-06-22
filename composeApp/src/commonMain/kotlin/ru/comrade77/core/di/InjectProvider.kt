package ru.comrade77.core.di

import ru.comrade77.core.database.AppDatabase

object InjectProvider {
    public val DATABASE = "database"
    
    private val dependencies: HashMap<String, Any> = hashMapOf()
    
    fun addDependency(key: String, dependency: Any) {
       dependencies[key] = dependency 
    }
    
    fun <T> getDependency(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return dependencies.get(key) as T
    }
    
    fun getDatabase(): AppDatabase = getDependency<AppDatabase>(DATABASE)
    
    
}

