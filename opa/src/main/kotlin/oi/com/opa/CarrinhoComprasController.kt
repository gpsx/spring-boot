package oi.com.opa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/carrinho")
class CarrinhoComprasController {
    val carrinho = mutableListOf<ItemCarrinho>()

    @GetMapping("/comprar/{item}/{valor}/{quantidade}")
    fun addItem(
            @PathVariable("item") item: String,
            @PathVariable("valor") valor: Double,
            @PathVariable("quantidade") quantidade: Int
    ){
       carrinho.add(ItemCarrinho(item, valor, quantidade))
    }

    @GetMapping
    fun carrinho() : MutableList<ItemCarrinho>{
        return carrinho
    }

    @GetMapping("/total")
    fun totalCarrinho() :TotalCarrinho{
        return TotalCarrinho(carrinho)
    }
}

data class ItemCarrinho(
        val item: String,
        val valor: Double,
        val quantidade: Int
)

class TotalCarrinho(carrinho: List<ItemCarrinho>) {
    var totalCompra = 0.0
    var quantidadeItens =0

    init {
        carrinho.map {
            this.quantidadeItens += it.quantidade
            this.totalCompra += it.valor
        }
    }
}