package oi.com.opa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/conta")
@RestController
class ContaController {
    var saldo = 0.0
    var qtdOperacoes = 0

    fun contabilizarOperação(){
        qtdOperacoes++
    }

    @GetMapping
    fun home() : String{
        return "O pai ta online"
    }

    @GetMapping("/saldo")
    fun getSaldo() : String{
        return "O saldo é $saldo"
    }

    @GetMapping("/deposita/{valor}")
    fun depositar(@PathVariable("valor") valor: Int): String{
        saldo+=valor
        contabilizarOperação()
        return "O saldo é $saldo"
    }

    @GetMapping("/saca/{valor}")
    fun sacar(@PathVariable("valor") valor: Int): String{
        saldo-=valor
        contabilizarOperação()
        return "O saldo é $saldo"
    }

    @GetMapping("/operacoes")
    fun sacar(): String{
        return "foram executadas $qtdOperacoes operações"
    }
}