package com.toast.core.base.repository

/**
 * @author toast
 * @date 2020/4/22 17:59
 * @description
 */

class BaseRepositoryBoth<T: IRemoteDataSource, R: ILocalDataSource>(
    val remoteDataSource: T,
    val localDataSource: R
): IRepository

class BaseRepositoryLocal<T: ILocalDataSource>(
    val localDataSource: T
): IRepository

class BaseRepositoryRemote<T: IRemoteDataSource>(
    val remoteDataSource: T
): IRepository