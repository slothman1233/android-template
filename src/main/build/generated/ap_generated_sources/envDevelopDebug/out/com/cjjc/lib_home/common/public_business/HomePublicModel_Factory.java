package com.cjjc.cjjc_business_cjjc.common.public_business;

import com.cjjc.lib_base_view.call.hilt.IApplication;
import com.cjjc.lib_base_view.call.hilt.IDB;
import com.cjjc.lib_base_view.view.BaseModel_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomePublicModel_Factory implements Factory<HomePublicModel> {
  private final Provider<IApplication> appProvider;

  private final Provider<IDB> dbProvider;

  public HomePublicModel_Factory(Provider<IApplication> appProvider, Provider<IDB> dbProvider) {
    this.appProvider = appProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public HomePublicModel get() {
    HomePublicModel instance = newInstance();
    BaseModel_MembersInjector.injectApp(instance, appProvider.get());
    BaseModel_MembersInjector.injectDb(instance, dbProvider.get());
    return instance;
  }

  public static HomePublicModel_Factory create(Provider<IApplication> appProvider,
      Provider<IDB> dbProvider) {
    return new HomePublicModel_Factory(appProvider, dbProvider);
  }

  public static HomePublicModel newInstance() {
    return new HomePublicModel();
  }
}
