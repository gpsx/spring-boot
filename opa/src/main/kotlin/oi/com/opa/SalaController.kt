package oi.com.opa

import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
class SalaController {
    val salas = mutableListOf<Sala>()

    @GetMapping("/sala")
    fun getSala(): MutableList<Sala>{
        return salas
    }

    @PostMapping("/Adiciona/{nome}/{capacidade}")
    fun postSala(
            @PathVariable("nome") nome: String,
            @PathVariable("capacidade") capacidade: Int
    ) : String{
        salas.add(Sala(nome, capacidade))
        return "$nome foi adicionado"
    }

    @DeleteMapping("/deleta/{index}")
    fun deleteSala(@PathVariable("index") i: Int) : Sala{
        salas.removeAt(i)
        return salas[i]
    }

    @PutMapping("/deleta/{index}/{nome}/{capacidade}")
    fun updateSala(
            @PathVariable("index") i: Int,
            @PathVariable("nome") nome: String,
            @PathVariable("capacidade") capacidade: Int
    ) : Sala{
        salas[i].apply {
            this.nome = nome
            this.capacidade = capacidade
        }
        return salas[i]
    }
}
