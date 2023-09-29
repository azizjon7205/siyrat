package uz.bismillah.siyrat.utils.fragment_toolbar

import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import uz.bismillah.siyrat.R

class ToolbarManager(
    toolbar: Toolbar?,
    navController: NavController,
    appBarConfiguration: AppBarConfiguration
) {
    init {
        if (toolbar != null) {
            val topLevelDestinations = appBarConfiguration.topLevelDestinations
            val currentDestination = navController.currentDestination

            toolbar.title = currentDestination?.label

            if (topLevelDestinations.contains(currentDestination?.id).not()) {
                toolbar.setNavigationIcon(R.drawable.ic_left_arrow)
                toolbar.setNavigationOnClickListener { navController.navigateUp(appBarConfiguration) }
            }
        }
    }
}