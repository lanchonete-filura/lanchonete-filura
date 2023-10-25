package br.com.fiap.lanchonetefilura.core.applications.usecases.implementateion

import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterClienteInputToClienteModel
import br.com.fiap.lanchonetefilura.adapter.driver.api.converters.converterFindAllClientesToArrayList
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequest
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.adapter.driven.infra.repository.ClienteRepository
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun findAllClientes(): ArrayList<ClienteModel> {
        val response = repository.findAll()
        return converterFindAllClientesToArrayList(response)
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteModel {
        return repository.save(converterClienteInputToClienteModel(clienteRequest))
    }
}