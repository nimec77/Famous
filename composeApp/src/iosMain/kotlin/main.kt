import androidx.compose.ui.window.ComposeUIViewController
import ru.comrade77.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
