from controller.main_controller import Main_controller

if __name__ == "__main__":
    saldo_compartilhado = [0]
    e = Main_controller(saldo_compartilhado)
    e.autorizar_vendas()
