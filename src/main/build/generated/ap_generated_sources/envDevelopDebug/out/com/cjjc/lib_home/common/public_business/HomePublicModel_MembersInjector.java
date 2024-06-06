package com.cjjc.cjjc_business_cjjc.common.public_business;

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
public final class HomePublicModel_MembersInjector implements MembersInjector<HomePublicModel> {
  private final Provider<IApplication> appProvider;

  private final Provider<IDB> dbProvider;

  public HomePublicModel_MembersInjector(Provider<IApplication> appProvider,
      Provider<IDB> dbProvider) {
    this.appProvider = appProvider;
    this.dbProvider = dbProvider;
  }

  public static MembersInjector<HomePublicModel> create(Provider<IApplication> appProvider,
      Provider<IDB> dbProvider) {
    return new HomePublicModel_MembersInjector(appProvider, dbProvider);
  }

  @Override
  public void injectMembers(HomePublicModel instance) {
    BaseModel_MembersInjector.injectApp(instance, appProvider.get());
    BaseModel_MembersInjector.injectDb(instance, dbProvider.get());
  }
}
