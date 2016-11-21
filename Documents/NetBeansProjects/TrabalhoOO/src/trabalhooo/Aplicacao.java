/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;



import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 *
 * @author user
 */
public class Aplicacao extends Application{

    /**
     * @param args the command line arguments
     */
    public static String simulacao = "";
    private static TextArea textArea = new TextArea();
    private static Button btnSimulacao = new Button("Simulacao");
    private static Button btnCelulares = new Button("Celulares");
    private static Button btnAntenas = new Button("Antenas");
    private static Button btnCentral = new Button("Central");
    private static Button btnTela = new Button("Simulacao Tela");
    private static Button btnArquivo = new Button("Simulacao Arquivo");
    private static Map<String, Celular> mapCelulares = new HashMap<String, Celular>();
    private static Map<String, Antena> mapAntenas = new HashMap<String, Antena>();
    private static Map<String, Central> mapCentral = new HashMap<String, Central>(); 
    private static Central central = new Central(mapCelulares, mapAntenas, 4);
    
    public static void main(String[] args) throws InterruptedException {
        
        
        mapCentral.put("Central", central);
        String mensagem1 = "Seja bem vindo!";
        String mensagem2 = "Clique em Simulacao Tela para rodar simulacao na tela";
        String mensagem3 = "Clique em Simulacao Arquivo para salvar simulacao em um arquivo log";
        String mensagem4 = "Clique em Celulares para imprimir dados dos Celulares";
        String mensagem5 = "Clique em Antenas para imprimir dados das Antenas";
        String mensagem6 = "Clique em Central para imprimir dados da Central";
        String interfaceUsuario = mensagem1 + "\n" + mensagem2 + "\n" + mensagem3 + "\n" + mensagem4 + "\n" + mensagem5 + "\n" + mensagem6;
        textArea.setText(interfaceUsuario);
        launch(args);
        
    }  
    
    public static void interfaceComUsuario() throws InterruptedException{
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Seja bem vindo!");
        textArea.setText("Seja bem vindo!");
        System.out.println("Por favor, insira o numero do comando desejado:");
        System.out.println("Clique em Simulacao Tela para rodar simulacao na tela");
        System.out.println("Clique em Simulacao Arquivo para salvar simulacao em um arquivo log");
        System.out.println("3 - Imprimir dados das Antenas");
        System.out.println("4 - Imprimir dados da Central");
        
        String texto = entrada.next();
        System.out.println(texto);
        
        switch(texto){
            case "1": rodarSimulacao();
            case "2": imprimirDadosCelulares();
            break;
            case "3": imprimirDadosAntenas();
            break;
            case "4": imprimirDadosCentral();
            break;  
        }
    }
    
    public static void rodarSimulacao() throws InterruptedException{
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Insira o numero do comando desejado:");
        System.out.println("1 - Mostrar resultado na interface");
        System.out.println("2 - Salvar resultado em um arquivo texto");
        
        String texto = entrada.next();
        System.out.println(texto);
        
        switch(texto){
            case "1": rodarEmInterface();
            break;
            case "2": escreverArquivoTexto();
            break;
            case "3":
                System.out.println("Desculpe, comando invalido");
                rodarSimulacao();
                break;
        }
    }
    
    public static void rodarEmInterface() throws InterruptedException{
        Arquivos a = new Arquivos();
        a.leituraArquivo(central.getMapAntenas());
        a.leituraArquivoCelular(central.getMapCelulares(), central.getMapAntenas());
        central.iniciarCronometro();
        a.leituraArquivoEventos(central.getMapCelulares(), mapCentral);
        sleep(60000);
        central.interromperCronometro();
        resultadoSimulacao(central);
        textArea.setText(simulacao);
    }
    
    public static void escreverArquivoTexto() throws InterruptedException{
        Arquivos a = new Arquivos();
        a.escritaArquivo();
        a.leituraArquivo(central.getMapAntenas());
        a.leituraArquivoCelular(central.getMapCelulares(), central.getMapAntenas());
        a.leituraArquivoEventos(central.getMapCelulares(), mapCentral);
        central.iniciarCronometro();        
        sleep(60000);
        resultadoSimulacao(central);
        central.interromperCronometro();        
    }
    
    public static void imprimirDadosCelulares() throws InterruptedException{
        Arquivos a = new Arquivos();
        a.leituraArquivo(central.getMapAntenas());
        a.leituraArquivoCelular(central.getMapCelulares(), central.getMapAntenas());
        String textoCelulares = "";
        for(Map.Entry<String,Celular> celularHash : mapCelulares.entrySet()){
            Celular celular = celularHash.getValue();
            textoCelulares = textoCelulares + celular.getString() + "\n";
        }
        textArea.setText(textoCelulares);
    }
    
    public static void imprimirDadosAntenas() throws InterruptedException{
        Arquivos a = new Arquivos();
        a.leituraArquivo(central.getMapAntenas());
        a.leituraArquivoCelular(central.getMapCelulares(), central.getMapAntenas());
        String textoAntenas = "";
        for(Map.Entry<String,Antena> antenaHash : mapAntenas.entrySet()){
            Antena antena = antenaHash.getValue();
            textoAntenas = textoAntenas + antena.getString() + "\n";
        }
        textArea.setText(textoAntenas);
    }
    
    public static void imprimirDadosCentral(){
        String textoCentral = "";
        for(Map.Entry<String,Central> centralHash : mapCentral.entrySet()){
            Central central = centralHash.getValue();
            textoCentral = textoCentral + central.getString() + "\n";
        }
        textArea.setText(textoCentral);
    }
    
    public static void resultadoSimulacao(Central central){
        double mensagensDisparadas = (double)central.getMensagens().size();
        double mensagensDeErro = (double)central.getMensagensDeErro().size();
        double mensagensNaoEnviadas = (double)central.getMensagensNaoEnviadas().size();
        System.out.println("Mensagens disparadas por celulares: " + mensagensDisparadas);
        simulacao = simulacao + "Mensagens disparadas por celulares: " + mensagensDisparadas +"\n";
        System.out.println("Mensagens de erro disparadas pelo sistema: " + mensagensDeErro);
        simulacao = simulacao + "Mensagens de erro disparadas pelo sistema: " + mensagensDeErro + "\n";
        System.out.println("Mensagens nao enviadas: " + mensagensNaoEnviadas);
        simulacao = simulacao + "Mensagens nao enviadas: " + mensagensNaoEnviadas + "\n";
        
        System.out.println("Tempo medio de entrega das mensagens: " + central.getTempoMedioMensagens());
        simulacao = simulacao + "Tempo medio de entrega das mensagens: " + central.getTempoMedioMensagens() + "\n";
        double taxaDeSucesso = (mensagensDisparadas - mensagensDeErro - mensagensNaoEnviadas)/mensagensDisparadas;
        double taxaFalhasNotificadas = mensagensDeErro/mensagensDisparadas;
        double taxaFalhasNaoNotificadas = (mensagensNaoEnviadas/mensagensDisparadas);
        System.out.println("Percentual de mensagens enviadas com sucesso: " + taxaDeSucesso);
        simulacao = simulacao + "Percentual de mensagens enviadas com sucesso: " + taxaDeSucesso + "\n";
        System.out.println("Percentual de mensagens de falha enviadas: " + taxaFalhasNotificadas);
        simulacao = simulacao + "Percentual de mensagens de falha enviadas: " + taxaFalhasNotificadas + "\n";
        System.out.println("Percentual de mensagens nao enviadas: " + taxaFalhasNaoNotificadas);
        simulacao = simulacao + "Percentual de mensagens nao enviadas: " + taxaFalhasNaoNotificadas + "\n";
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Trabalho POO");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        grid.add(textArea, 0, 3, 6, 1);
        grid.add(btnTela, 0, 7);
        grid.add(btnArquivo, 2, 7 );
        grid.add(btnCelulares, 0, 8);
        grid.add(btnAntenas, 2, 8);
        grid.add(btnCentral, 4, 8);
        btnCelulares.setOnAction(e -> {
            try {
                imprimirDadosCelulares();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnAntenas.setOnAction(e -> {
            try {
                imprimirDadosAntenas();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnCentral.setOnAction(e -> {
            imprimirDadosCentral();
        });
        
        btnTela.setOnAction(e -> {
            try {
                rodarEmInterface();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnArquivo.setOnAction(e -> {
            try {
                escreverArquivoTexto();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//
}
