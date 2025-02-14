package domain.usecase

import domain.model.Carro
import domain.model.Marcha

class AlterarVelocidadeUseCase {
    fun executar(carro: Carro, variacao: Int) {

        if(!carro.ligado) {
            println("Erro: O carro está desligado. Ligue o carro antes. ")
            return
        }

        val velocidadeMinima = limites(carro).first
        val velocidadeMaxima = limites(carro).second

        when {
            variacao < 0 -> {

                println("Variacao")
                println("Velocidade Minima: $velocidadeMinima")
                println("Velocidade Máxima: $velocidadeMaxima")

                if (carro.velocidade == 0 ) {
                   println(" ⚠️ A velocidade mínima do carro foi atingida ")
                    return
                }

                repeat(variacao) {
                    carro.velocidade = carro.velocidade - 1
                    println("A velocidade reduziu em 1 km/h. Velocidade atual: ${carro.velocidade} km/h")
                    if (carro.velocidade == velocidadeMinima) {
                        println("⚠️ O carro atingiu o limite de velocidade mínima para a marcha")
                        println("Limite da Marcha ${carro.marcha} :")
                        println("De ${velocidadeMinima} km/h a ${velocidadeMaxima} km/h")
                        return
                    }
                }

                println("A velocidade foi reduzida para: ${carro.velocidade} km/h")
                return
            }

            variacao > 0 -> {
                println("Acelerando carro. Velocidade atual: ${carro.velocidade} km/h")

                repeat(variacao) {
                    carro.velocidade += 1
                    println("A velocidade aumentou em 1 para: ${carro.velocidade}")
                    if (carro.velocidade == velocidadeMaxima) {
                        println("⚠️ O carro atingiu o limite de velocidade máxima para a marcha")
                        println("Limite da Marcha ${carro.marcha}:")
                        println("De ${velocidadeMinima} km/h a ${velocidadeMaxima} km/h")
                        return
                    }
                }

                println("A velocidade foi aumentada para: ${carro.velocidade} km/h")
                return
            }
        }
        println("Velocidade atual: ${carro.velocidade} km/h")
    }

    fun limites(carro: Carro) : Pair<Int, Int> {
        when (carro.marcha) {
            Marcha.NEUTRO -> {
                return Pair(0,20)
            }
            Marcha.PRIMEIRA -> {
                return Pair(0,0)
            }
            Marcha.SEGUNDA -> {
                return Pair(21,40)
            }
            Marcha.TERCEIRA -> {
                return Pair(41,60)
            }
            Marcha.QUARTA -> {
                return Pair(61, 80)
            }
            Marcha.QUINTA -> {
                return Pair(81, 100)
            }
            Marcha.SEXTA -> {
                return Pair(101, 120)
            }
            else -> {
                return Pair(-1,-1)
            }
        }
    }

}