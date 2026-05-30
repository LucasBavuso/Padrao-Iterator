package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IteratorTest {

    @Test
    @DisplayName("Cenário 1: Deve percorrer todos os elementos do carrinho na ordem correta")
    public void devePercorrerElementos() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(5);
        carrinho.adicionarItem("Pizza");
        carrinho.adicionarItem("Refrigerante");
        carrinho.adicionarItem("Batata Frita");

        Iterator iterator = carrinho.criarIterator();

        assertTrue(iterator.temProximo());
        assertEquals("Pizza", iterator.proximo());

        assertTrue(iterator.temProximo());
        assertEquals("Refrigerante", iterator.proximo());

        assertTrue(iterator.temProximo());
        assertEquals("Batata Frita", iterator.proximo());

        assertFalse(iterator.temProximo());
    }

    @Test
    @DisplayName("Cenário 2: Deve funcionar corretamente se a coleção estiver vazia")
    public void deveFuncionarComColecaoVazia() {
        CarrinhoDeCompras carrinhoVazio = new CarrinhoDeCompras(3);
        Iterator iterator = carrinhoVazio.criarIterator();

        assertFalse(iterator.temProximo(), "Um carrinho vazio não deve ter próximo elemento.");
    }
}