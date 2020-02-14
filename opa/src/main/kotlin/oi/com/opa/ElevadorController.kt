package oi.com.opa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ElevadorController {
    var pesoLimite = 0.0
    var pesoAtual = 0.0

    @GetMapping("/configurar/{peso}")
    fun configPeso(@PathVariable("peso") peso: Double){
        pesoLimite = peso
    }

    @GetMapping("/subir/{quem}")
    fun subir(@PathVariable("quem") quem: String): String{
        if (pesoLimite == 0.0) return "Primeiro configure o peso do elevador"
        try {
            val novoPeso = pesoAtual + tipoPessoa.valueOf(quem.toUpperCase()).peso
            if (novoPeso >= pesoLimite) return "Não pode" else pesoAtual = novoPeso

        } catch (ex : Exception) {
            return "Valor inválido, digite m, f ou c"
        }
        return ""
    }
}

enum class tipoPessoa(val peso: Double) {
    M(90.0), F(70.0), C(40.0)
}