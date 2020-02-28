package oi.com.opa

import java.lang.Double.sum

class Elicao{
    var votosCandidato1 = 0
    var votosCandidato2 = 0
    var votosInvalidos = 0
    val totalVotos
        get() = votosCandidato1 + votosCandidato2 + votosInvalidos
}

//{
//    "votosCandidato1": 25,
//    "votosCandidato2": 9,
//    "votosInvalidos": 1,
//    "totalVotos": 35
//}