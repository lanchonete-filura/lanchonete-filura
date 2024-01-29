package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.PedidoJpaRepository
import org.springframework.stereotype.Repository

@Repository
class PedidoRepositoryImpl(private val repository: PedidoJpaRepository) : PedidoRepository {
    /*override fun getPedidos(): List<PedidoDTO>? {

        return repository.findAll()
    }

    override fun getPedidoById(pedidoId: UUID): PedidoDTO? {

        return repository.findById(pedidoId).get()
    }

    override fun savePedido(pedidoModel: PedidoDTO): PedidoDTO? {

        return repository.save(pedidoModel)
    }

    override fun updateEtapaPedido(pedidoModel: PedidoDTO): PedidoDTO? {

        return repository.save(pedidoModel)
    }

    override fun updateStatusPagamentoPedido(pedidoModel: PedidoDTO): PedidoDTO? {

        return repository.save(pedidoModel)
    }*/
    override fun listarPedidos(): List<PedidoDTO> {
        return repository.findAll()
    }
}