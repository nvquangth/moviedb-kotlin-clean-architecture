package com.clean.data.model.base

import com.example.domain.model.base.Model

interface EntityMapper<M : Model, ME : ModelEntity> {

    fun mapToDomain(entity: ME): M

    fun mapToData(model: M): ME
}