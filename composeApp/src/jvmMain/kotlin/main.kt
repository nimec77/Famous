import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import ru.comrade77.App
import ru.comrade77.core.database.getDatabaseBuilder
import ru.comrade77.core.database.getRoomDatabase
import ru.comrade77.core.di.InjectProvider

fun main() = application {
    Window(
        title = "Famous",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)

        val appDatabase = getRoomDatabase(
            getDatabaseBuilder()
        )

        InjectProvider.addDependency(InjectProvider.DATABASE, appDatabase)

        App()
    }
}