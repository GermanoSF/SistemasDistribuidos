from model.caixa import Caixa
from view.main_view import Main_view

import threading

class Main_controller:
    def __init__(self,saldo_compartilhado):
        self.saldo_compartilhado = saldo_compartilhado
    
    def autorizar_vendas(self):
        t = []
        for i in range(5):
            c =Caixa(self.saldo_compartilhado)
            t.append(threading.Thread(c.vender_fichas()))
            t[i].start()
        for thread in t:
            thread.join() 
        Main_view.informar_saldo(self.saldo_compartilhado)
