package com.arynlyre.taskmanagement.data.mapper

abstract class DomainMapper<T, DomainModel> {
    abstract fun mapToDomainModel(dto: T): DomainModel
    abstract fun mapToDto(model: DomainModel): T

    fun mapToDomainList(dtos: List<T>): List<DomainModel> = dtos.map { mapToDomainModel(it) }
    fun mapToDtoList(domainModels: List<DomainModel>): List<T> = domainModels.map { mapToDto(it) }
}
