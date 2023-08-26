package com.saberspringcore.test.services.impl;

import com.saberspringcore.test.services.KeyHelper;
import com.saberspringcore.test.services.LockOpener;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service(value = "abstractLockOpener")
public abstract class AbstractLockOpener implements LockOpener {
    @Override
    @Lookup(value = "keyHelper")
    public abstract KeyHelper getMyKeyOpener() ;

    @Override
    public void openLock() {
        getMyKeyOpener().open();
    }
}
