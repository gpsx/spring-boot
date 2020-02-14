package oi.com.opa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class HomeController {

    @GetMapping
    fun getFraseInicial(): String? {
        return "É nóis no Spring Boot!"
    }

    @GetMapping("/cumprimentar")
    fun cumprimentar(): String? {
        return "Boa noite, meu querido!"
    }


    @GetMapping("/beijar/{quem}")
    fun beijar(@PathVariable("quem") quem: String): String? {
        return "Beijo, $quem!!!"
    }


    @GetMapping("/multiplicar/{n1}/{n2}")
    fun multiplicar(@PathVariable("n1") n1: Double, @PathVariable("n2") n2: Double): String? {
        return "A multiplicação dá: " + n1 * n2
    }

    @GetMapping("/calcular/{nome}/{nota1}/{nota2}")
    fun calcular(
            @PathVariable("nome") nome: String,
            @PathVariable("nota1") nota1: Double,
            @PathVariable("nota2") nota2: Double): String? {
        val media = (nota1 + nota2) / 2
        val resultado = if (media >= 5) "Aprovado(a)" else "Reprovado(a)"
        return "Olá, $nome, sua média foi $media e seu resultado foi $resultado"
    }

    @GetMapping("/meupet")
    fun getMeuPet(): Animal {
        return Animal("Xena", "Cachorro", 5)
    }

    @GetMapping("/variaspucta")
    fun getVariasPucta() : List<Animal>{
        return listOf(
                Animal("", "", 5),
                Animal("a", "a", 758)
        )
    }

}