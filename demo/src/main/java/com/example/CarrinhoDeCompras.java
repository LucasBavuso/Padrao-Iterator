package com.example;

public class CarrinhoDeCompras {
    private final String[] itens;
    private int quantidade = 0;

    public CarrinhoDeCompras(int capacidade) {
        this.itens = new String[capacidade];
    }

    public void adicionarItem(String item) {
        if (quantidade < itens.length) {
            itens[quantidade] = item;
            quantidade++;
        }
    }

    public Iterator criarIterator() {
        return new CarrinhoIterator();
    }

    private class CarrinhoIterator implements Iterator {
        private int indice = 0;
        @Override
        public boolean temProximo() {
            return indice < quantidade && itens[indice] != null;
        }

        @Override
        public String proximo() {
            String item = itens[indice];
            indice++;
            return item;
        }
    }
}