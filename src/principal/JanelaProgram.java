package principal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaProgram extends JFrame{

    public JanelaProgram() {
        this.setSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar barrMenuBar = new JMenuBar();
        this.setJMenuBar(barrMenuBar);

        JMenu arquivo = new JMenu("Arquivo");
        JMenu xenomorfos = new JMenu("Xenomorfos");
        barrMenuBar.add(arquivo);
        barrMenuBar.add(xenomorfos);

        JMenuItem novaSimulacao = new JMenuItem("Nova Simulação");
        novaSimulacao.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        arquivo.add(novaSimulacao);


        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        arquivo.add(sair);

        JMenuItem listaXenomorfo = new JMenuItem("Lista de Xenomorfos");
        listaXenomorfo.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        xenomorfos.add(listaXenomorfo);
    }
}
