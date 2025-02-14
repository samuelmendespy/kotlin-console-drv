package domain.model

class Carro (
    var ligado: Boolean = false,
    var velocidade: Int = 0,
    var direcao: String = "",
    var marcha: Marcha = Marcha.NEUTRO)