package domain.model

enum class Marcha(val numero: Int) {
    NEUTRO(0),
    PRIMEIRA(1),
    SEGUNDA(2),
    TERCEIRA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6);

    fun proxima(): Marcha? {
        val proximaMarcha = this.ordinal + 1
        return if (proximaMarcha < entries.size) entries[proximaMarcha] else null
    }

    fun anterior(): Marcha? {
        val marchaAnterior = this.ordinal - 1
        return if (marchaAnterior >= 0) entries[marchaAnterior] else null
    }
}