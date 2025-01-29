package principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import xenomorfo.Xenomorfo;
import xenomorfo.Memoria;
import localizacoes.Localizacoes;
import xenomorfo.Visao;

public class JanelaProgram extends JFrame {

    private JTextField textFieldNumeroXenos;
    private JTextField[] textFieldNomesXenos;
    private JButton buttonConfirmar;
    private JTextArea areaTexto;
    private Localizacoes mapa;

    public JanelaProgram() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar barrMenuBar = new JMenuBar();
        this.setJMenuBar(barrMenuBar);

        JMenu arquivo = new JMenu("Arquivo");
        JMenu xenomorfos = new JMenu("Xenomorfos");
        barrMenuBar.add(arquivo);
        barrMenuBar.add(xenomorfos);

        JMenuItem novaSimulacao = new JMenuItem("Nova Simulação");
        novaSimulacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSimulacao();
            }
        });
        arquivo.add(novaSimulacao);

        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        arquivo.add(sair);

        // Título e campo para definir o número de xenomorfos
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel labelNumeroXenos = new JLabel("Quantos xenomorfos você irá começar a simulação?");
        textFieldNumeroXenos = new JTextField(5);
        
        panel.add(labelNumeroXenos);
        panel.add(textFieldNumeroXenos);

        // Botão para confirmar o número de xenomorfos
        buttonConfirmar = new JButton("Confirmar");
        buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberXeno = Integer.parseInt(textFieldNumeroXenos.getText());
                if (numberXeno > 1) {
                    textFieldNomesXenos = new JTextField[numberXeno];
                    for (int i = 0; i < numberXeno; i++) {
                        JPanel panelNome = new JPanel();
                        panelNome.add(new JLabel("Nome do Xenomorfo " + (i + 1) + ":"));
                        textFieldNomesXenos[i] = new JTextField(10);
                        panelNome.add(textFieldNomesXenos[i]);
                        panel.add(panelNome);
                    }
                } else {
                    // Apenas um Xenomorfo
                    JPanel panelNome = new JPanel();
                    panelNome.add(new JLabel("Nome do Xenomorfo:"));
                    textFieldNomesXenos = new JTextField[1];
                    textFieldNomesXenos[0] = new JTextField(10);
                    panelNome.add(textFieldNomesXenos[0]);
                    panel.add(panelNome);
                }
                panel.revalidate();
                panel.repaint();
            }
        });
        panel.add(buttonConfirmar);

        // Definir uma área de texto para mostrar informações da simulação
        areaTexto = new JTextArea(10, 40);
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        panel.add(scrollPane);

        // Define o conteúdo da janela
        this.add(panel);
    }

    private void iniciarSimulacao() {
        // Pega o número de xenomorfos
        int numberXeno = Integer.parseInt(textFieldNumeroXenos.getText());
        String[] nomesXeno = new String[numberXeno];

        // Pega os nomes dos xenomorfos
        for (int i = 0; i < numberXeno; i++) {
            nomesXeno[i] = textFieldNomesXenos[i].getText();
        }

        // Criação do mapa
        mapa = new Localizacoes(10, 10);  // Mapa de 10x10
        mapa.gerarEstruturasAleatorias(3);  // Gerar algumas estruturas aleatórias no mapa

        // Criando os xenomorfos e posicionando-os no mapa
        Xenomorfo[] xenomorfos = new Xenomorfo[numberXeno];
        for (int i = 0; i < numberXeno; i++) {
            xenomorfos[i] = new Xenomorfo(i, nomesXeno[i], getTitle(), i + 1, i, i, i, i, i, i, i, i, rootPaneCheckingEnabled);  // Assumindo ID incremental
        }

        // Adicionar entidades no mapa
        mapa.posicionarEntidadesAleatorias(xenomorfos);

        // Exibir a visão dos xenomorfos
        Memoria memoria = new Memoria(mapa.getLargura(), mapa.getAltura());
        Visao visao = new Visao(5, 5);  // Exemplo de visão de um xenomorfo
        visao.atualizarVisao(mapa);
        memoria.atualizarMemoria(visao);

        // Exibir o estado inicial da simulação
        areaTexto.setText("Simulação Iniciada!\n");
        areaTexto.append("Mapa Inicial:\n");
        mapa.imprimirMapa();

        areaTexto.append("\nVisão do Xenomorfo (5,5):\n");
        areaTexto.append(visao.toString());
        areaTexto.append("\nMapa Mental:\n");
        memoria.imprimirMapaMental();
    }

    public static void main(String[] args) {
        new JanelaProgram().setVisible(true);
    }
}
