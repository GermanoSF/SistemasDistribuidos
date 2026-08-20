from ..model import caixa
from ..view import main_view

import threading

class Main_controller:
    def __init__(self,saldo_compartilhado):
        self.saldo_compartilhado = saldo_compartilhado
    
    def autorizar_vendas(self):
        for i in range(5):
            caixa[i]=Caixa(self.saldo_compartilhado)
            t[i]=threading.Thread(target=caixa[i].vender_fichas())
            t[i].start()
        for thread in t:
            thread.join() 
        main_view.informar_saldo(self.saldo_compartilhado)
