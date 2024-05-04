package tad.interfaces;
@SuppressWarnings("ALL")

// Interface genérica para uma lista de elementos
public interface Lista<T> {
    // Adiciona um elemento ao final da lista
    void adicionarFim(T elemento);
    // Adiciona um elemento ao início da lista
    void adicionarInicio(T elemento);
    // Remove um elemento da lista
    void remover(T elemento);
    // Imprime a lista
    void imprimir();
}


