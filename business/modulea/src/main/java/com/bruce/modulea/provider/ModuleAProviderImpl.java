package com.bruce.modulea.provider;

import com.andrew.architecture.services.modulea.ModuleAProvider;

/**
 * @Description: Java类作用描述
 * @CreateDate: 2020/11/4 2:55 PM
 */
class ModuleAProviderImpl implements ModuleAProvider {
    @Override
    public String getModuleName() {
        return "In Module A";
    }
}
