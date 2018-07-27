package com.smadmin.multiscreenapp.navigator;

import ru.terrakok.cicerone.Navigator;

public final class NavigatorManager {

    private BaseNavigator baseNavigator;

    public NavigatorManager(BaseNavigator baseNavigator) {
        this.baseNavigator = baseNavigator;
    }

    public BaseNavigator getBaseNavigator() {
        return baseNavigator;
    }

    public Navigator getNavigator() {
        return baseNavigator.getCiceroneNavigator();
    }
}
