package com.cjjc.cjjc_business_cjjc.page.home;

import com.cjjc.lib_base_view.call.hilt.IApplication;
import com.cjjc.lib_base_view.call.hilt.IDB;
import com.cjjc.lib_base_view.view.BaseModel_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class HomeModel_MembersInjector implements MembersInjector<HomeModel> {
  private final Provider<IApplication> appProvider;

  private final Provider<IDB> dbProvider;

  public HomeModel_MembersInjector(Provider<IApplication> appProvider, Provider<IDB> dbProvider) {
    this.appProvider = appProvider;
    this.dbProvider = dbProvider;
  }

  public static MembersInjector<HomeModel> create(Provider<IApplication> appProvider,
      Provider<IDB> dbProvider) {
    return new HomeModel_MembersInjector(appProvider, dbProvider);
  }

  @Override
  public void injectMembers(HomeModel instance) {
    BaseModel_MembersInjector.injectApp(instance, appProvider.get());
    BaseModel_MembersInjector.injectDb(instance, dbProvider.get());
  }
}
