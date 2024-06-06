package com.cjjc.cjjc_business_cjjc.common.public_business;

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
public final class HomePublicPresenter_Factory implements Factory<HomePublicPresenter> {
  private final Provider<HomePublicInterface.Model> mModelProvider;

  public HomePublicPresenter_Factory(Provider<HomePublicInterface.Model> mModelProvider) {
    this.mModelProvider = mModelProvider;
  }

  @Override
  public HomePublicPresenter get() {
    return newInstance(mModelProvider.get());
  }

  public static HomePublicPresenter_Factory create(
      Provider<HomePublicInterface.Model> mModelProvider) {
    return new HomePublicPresenter_Factory(mModelProvider);
  }

  public static HomePublicPresenter newInstance(HomePublicInterface.Model mModel) {
    return new HomePublicPresenter(mModel);
  }
}
