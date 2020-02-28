package oi.com.opa

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/eleicao")
class EleicaoController {
    var eleicao = Elicao()
    var podeVotar = false
    @GetMapping("/resultado")
    fun getSala(): Elicao{
        return eleicao
    }

    @PostMapping("/votar/{candidato}")
    fun vote(
            @PathVariable("candidato") candidato: Int
    ) : String{
        if (podeVotar){
            return when (candidato) {
                1 -> {
                    podeVotar = false
                    eleicao.votosCandidato1++
                    "candidato 1 foi Votado"
                }
                2 -> {
                    podeVotar = false
                    eleicao.votosCandidato2++
                    "candidato 2 foi Votado"
                }
                else -> {
                    "candidato invalido"
                }
            }
        }
        return "Não pode votar"
    }

    @PostMapping("/registrar-eleitor/{idade}")
    fun setEleitor(
            @PathVariable("idade") idade: Int
    ) : String{
        if (idade >= 16){
            podeVotar = true
            return "eleitor foi adicionado"
        }else{
            return "Não pode votar"
        }

    }


}
