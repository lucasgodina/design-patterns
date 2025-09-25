# Ventajas de aplicar este patrón:
# 1. Desacoplamiento: El control remoto (Invoker) no necesita conocer los detalles
#  de cómo se ejecuta un comando. Solo interactúa con la interfaz Command.
# 2. Extensibilidad: Se pueden añadir nuevos comandos para controlar otros dispositivos
#  (como un equipo de sonido o un ventilador) sin modificar la clase ControlRemoto.
# 3. Flexibilidad: Los comandos pueden ser almacenados, encolados o revertidos, lo que
#  permite implementar funcionalidades avanzadas como "deshacer".
# 4. Encapsulación: Cada comando encapsula una solicitud completa, incluyendo el método
#  a llamar y los parámetros necesarios, en un único objeto.

from abc import ABC, abstractmethod


# Clase de la televisión (Receiver)
class Television:
    def encender(self):
        print("Televisión encendida")

    def apagar(self):
        print("Televisión apagada")


# Interfaz Comando
class Command(ABC):
    @abstractmethod
    def ejecutar(self):
        pass


# Interfaces concretas de comandos
class EncenderTelevisionCommand(Command):
    def __init__(self, televisor):
        self.televisor = televisor

    def ejecutar(self):
        self.televisor.encender()


class ApagarTelevisionCommand(Command):
    def __init__(self, televisor):
        self.televisor = televisor

    def ejecutar(self):
        self.televisor.apagar()


# Clase del control remoto (Invoker)
class ControlRemoto:
    def __init__(self):
        self._command = None

    def set_command(self, command: Command):
        self._command = command

    def presionar_boton(self):
        if self._command:
            self._command.ejecutar()
        else:
            print("No hay comando asignado")


def main():
    # 1. Crear el receptor
    television = Television()

    # 2. Crear los comandos concretos, pasándoles el receptor
    encender_command = EncenderTelevisionCommand(television)
    apagar_command = ApagarTelevisionCommand(television)

    # 3. Crear el invocador
    control_remoto = ControlRemoto()

    # 4. Asignar y ejecutar comandos
    control_remoto.set_command(encender_command)
    control_remoto.presionar_boton()

    control_remoto.set_command(apagar_command)
    control_remoto.presionar_boton()


if __name__ == "__main__":
    main()
