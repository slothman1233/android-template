package com.cjjc.cjjc_business_cjjc.page.home;

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
public final class HomePresenter_Factory implements Factory<HomePresenter> {
  private final Provider<HomeInterface.Model> mModelProvider;

  public HomePresenter_Factory(Provider<HomeInterface.Model> mModelProvider) {
    this.mModelProvider = mModelProvider;
  }

  @Override
  public HomePresenter get() {
    return newInstance(mModelProvider.get());
  }

  public static HomePresenter_Factory create(Provider<HomeInterface.Model> mModelProvider) {
    return new HomePresenter_Factory(mModelProvider);
  }

  public static HomePresenter newInstance(HomeInterface.Model mModel) {
    return new HomePresenter(mModel);
  }
}
