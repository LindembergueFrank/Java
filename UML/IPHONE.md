classDiagram
    class ReprodutorMusical {
        +void reproduzirMusica(String faixa)
        +void pausarMusica()
        +void pararMusica()
        +void adicionarFaixa(String faixa)
    }

    class AparelhoTelefonico {
        +void fazerChamada(String numero)
        +void receberChamada()
        +void encerrarChamada()
    }

    class NavegadorInternet {
        +void abrirPagina(String url)
        +void fecharAba()
        +void atualizarPagina()
    }

    class iPhone {
        +void reproduzirMusica(String faixa)
        +void pausarMusica()
        +void pararMusica()
        +void adicionarFaixa(String faixa)
        +void fazerChamada(String numero)
        +void receberChamada()
        +void encerrarChamada()
        +void abrirPagina(String url)
        +void fecharAba()
        +void atualizarPagina()
    }

    ReprodutorMusical <|-- iPhone
    AparelhoTelefonico <|-- iPhone
    NavegadorInternet <|-- iPhone
