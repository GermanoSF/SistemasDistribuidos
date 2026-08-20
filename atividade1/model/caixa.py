class Caixa:
    def __init__(self,saldo_compartilhado):
        self.saldo_compartilhado = saldo_compartilhado

    def vender_fichas(self):
        for i in range(1000):
            with threading.Lock():
                self.saldo_compartilhado[0] +=10