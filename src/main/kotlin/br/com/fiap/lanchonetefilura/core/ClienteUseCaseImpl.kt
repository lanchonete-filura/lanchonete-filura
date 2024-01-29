package br.com.fiap.lanchonetefilura.core

import br.com.fiap.lanchonetefilura.domain.exceptions.cliente.ClienteJaExisteException
import br.com.fiap.lanchonetefilura.domain.exceptions.cliente.ClienteNaoEncontradoException
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Component

@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun getClientes(): List<ClienteModel>? {

        return repository.getClientes()
    }

    override fun getClienteByCpf(cpf: String): ClienteModel? {

        val cliente: ClienteModel? = repository.getClienteByCpf(cpf = cpf)

        cliente?.let {} ?: throw ClienteNaoEncontradoException()

        return cliente
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteModel? {

        val clienteByCpf: ClienteModel? = repository.getClienteByCpf(cpf = clienteRequest.cpf)

        clienteByCpf?.let {
            logger.error("Cliente já estava cadastrado na base")
            throw ClienteJaExisteException(it)
        }

        return repository.saveCliente(clienteRequest)
    }
}