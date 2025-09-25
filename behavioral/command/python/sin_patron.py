# El problema en esta implementación sin patrón es que la clase ControlRemoto
# está fuertemente acoplada a la clase Television.
# Si se desea cambiar la funcionalidad del control remoto o agregar nuevos dispositivos,
# se tendría que modificar esta clase directamente.
# Esto viola el principio de abierto/cerrado, ya que la clase ControlRemoto no está
# abierta para extensión sin modificación.


# Clase de la televisión (Receiver)
class Television:
    def encender(self):
        print("Televisión encendida")

    def apagar(self):
        print("Televisión apagada")


class ControlRemoto:
    def __init__(self, television):
        self.television = television

    def presionarBotonEncender(self):
        self.television.encender()

    def presionarBotonApagar(self):
        self.television.apagar()


def main():
    television = Television()
    control_remoto = ControlRemoto(television)

    control_remoto.presionarBotonEncender()
    control_remoto.presionarBotonApagar()


if __name__ == "__main__":
    main()
