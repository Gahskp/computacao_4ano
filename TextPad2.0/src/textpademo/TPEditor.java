/**
 * TPEditor.java
 *
 * Ejemplo de un editor básico para documentos de texto plano utilizando la biblioteca gráfica Swing.
 * Funciona desde Java SE 5.0 en adelante.
 */
 
package textpademo;
 
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.undo.UndoManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
 * Clase principal donde se construye la GUI del editor.
 *
 * @author Dark[byte]
 */
public class TPEditor extends Applet implements ActionListener, KeyListener{
 
    private JFrame jFrame;            //instancia de JFrame (ventana principal)
    private JMenuBar jMenuBar;        //instancia de JMenuBar (barra de menú)
    private JToolBar jToolBar;        //instancia de JToolBar (barra de herramientas)
    private JTextPane jTextPane;      //instancia de JTextPane (área de edición)
    private JPopupMenu jPopupMenu;    //instancia de JPopupMenu (menú emergente)
    private JPanel statusBar;         //instancia de JPanel (barra de estado)
 
    private JCheckBoxMenuItem itemLineWrap;         //instancias de algunos items de menú que necesitan ser accesibles
    private JCheckBoxMenuItem itemShowToolBar;
    private JCheckBoxMenuItem itemFixedToolBar;
    private JCheckBoxMenuItem itemShowStatusBar;
    private JMenuItem mbItemUndo;
    private JMenuItem mbItemRedo;
    private JMenuItem mpItemUndo;
    private JMenuItem mpItemRedo;
 
    private JButton buttonUndo;    //instancias de algunos botones que necesitan ser accesibles
    private JButton buttonRedo;
 
    private JLabel sbFilePath;    //etiqueta que muestra la ubicación del archivo actual
    private JLabel sbFileSize;    //etiqueta que muestra el tamaño del archivo actual
    private JLabel sbCaretPos;    //etiqueta que muestra la posición del cursor en el área de edición
 
    private boolean hasChanged = false;    //el estado del documento actual, no modificado por defecto
    private File currentFile = null;       //el archivo actual, ninguno por defecto
 
    private final EventHandler eventHandler;          //instancia de EventHandler (la clase que maneja eventos)
    private final ActionPerformer actionPerformer;    //instancia de ActionPerformer (la clase que ejecuta acciones)
    private final UndoManager undoManager;            //instancia de UndoManager (administrador de edición)
 
    private Timer timer;
    
    private final String palavrasReservadas[]={"break","do","else","elseif","end","false","for","function","if","in","local","nil","repeat","return","then","true","until","while"};
    
    /**
     * Punto de entrada del programa.
     *
     * Instanciamos esta clase para construir la GUI y hacerla visible.
     *
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        //construye la GUI en el EDT (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                
                TPEditor tpe = new TPEditor();
                tpe.addKeyListener(tpe);
                tpe.jFrame.setVisible(true);    //hace visible la GUI creada por la clase TPEditor
                //new TPEditor().jFrame.setVisible(true);    //hace visible la GUI creada por la clase TPEditor
                
            }
        });
    }
 
    /**
     * Constructor de la clase.
     *
     * Se construye la GUI del editor, y se instancian clases importantes.
     */
    public TPEditor() {
        try {    //LookAndFeel nativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println(ex);
        }
 
        //construye un JFrame con título
        jFrame = new JFrame("Editor LFC - Sem nome");
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
 
        //asigna un manejador de eventos para el cierre del JFrame
        jFrame.addWindowListener(new WindowAdapter() {
 
            @Override
            public void windowClosing(WindowEvent we) {
                actionPerformer.actionExit();    //invoca el método actionExit()
            }
        });
 
        eventHandler = new EventHandler();              //construye una instancia de EventHandler
        actionPerformer = new ActionPerformer(this);    //construye una instancia de ActionPerformer
        undoManager = new UndoManager();                //construye una instancia de UndoManager
        undoManager.setLimit(50);                       //le asigna un límite al buffer de ediciones
 
        buildTextPane();     //construye el área de edición, es importante que esta sea la primera parte en construirse
        buildMenuBar();      //construye la barra de menú
        buildToolBar();      //construye la barra de herramientas
        buildStatusBar();    //construye la barra de estado
        buildPopupMenu();    //construye el menú emergente
 
        jFrame.setJMenuBar(jMenuBar);                              //designa la barra de menú del JFrame
        Container c = jFrame.getContentPane();                     //obtiene el contendor principal
        c.add(jToolBar, BorderLayout.NORTH);                       //añade la barra de herramientas, orientación NORTE del contendor
        c.add(new JScrollPane(jTextPane), BorderLayout.CENTER);    //añade el area de edición en el CENTRO
        c.add(statusBar, BorderLayout.SOUTH);                      //añade la barra de estado, orientación SUR
 
        //configura el JFrame con un tamaño inicial proporcionado con respecto a la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setSize(pantalla.width / 2, pantalla.height / 2);
 
        //centra el JFrame en pantalla
        jFrame.setLocationRelativeTo(null);
        
/*        
        Thread th1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    //System.out.print(jTextPane.getText());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    colorirTexto();
                }
            }
        };     
        th1.start();
*/        
        
       jTextPane.addKeyListener(this);
       jTextPane.setText(" ");
      // timer = new Timer(50,this);
      //timer.start();
    }
 
    public void analisarTexto(){
        // Analisa todo o texto de jTextPane verificando se as cadeias encontradas devem ser coloridas ou não.
        // Utilizará AFD para analisar cada cadeia obtida.
        // Considera que sempre existem espaços em branco entre os elementos
        // (Ex: considera "a = 2" e não considera "a=2", pois os espaços são usados para a separação dos termos).
        // Conforme encontra elementos da linguagem, os colore adequadamente.
      
        
        String termosTextoProv[]; // Declara um vetor de string provisório que receberá as partes quebradas do jTextPane em função dos espaços encontrados.
        termosTextoProv=jTextPane.getText().split(" "); // Quebra o texto original em função dos espaços e armazena cada termo em uma posição do vetor termosTextoProv.
        
        int i=0; // declara e inicializa com qualquer valor (para o Java não reclamar)
        int j=0; 
        int k=0;
        int concatenacoes=0;
        int enters=0;
        // No for abaixo é feito o tratamento das strings (comentários com aspas) pois um comentário pode conter espaços e, assim, ter sido quebrado pelo split anterior
        // Após esse for cada comentário é remontado em uma única string 
        for (i=0;i<termosTextoProv.length;i++){
            System.out.println(termosTextoProv[i]);
            if (termosTextoProv[i].endsWith("\n")){
                enters++;
            }
            if (termosTextoProv[i].startsWith("\"")){ // Se é encontrado o início de uma string (termo que começa com ")
                if ((!termosTextoProv[i].endsWith("\"")&&(termosTextoProv[i].length()!=1))){ // e esse termo não termina com " (significa que a string possui espaço e foi quebrada pelo split, precisando ser remontada, ou nao será uma string por noa ter as outras aspas )
                    j=i+1;
                    while(j<termosTextoProv.length){ // controla o while para não exceder o vetor (pois a pessoa pode não ter colocado o segundo caracter ")
                        termosTextoProv[i]=termosTextoProv[i]+ " "+termosTextoProv[j];
                        concatenacoes++; // conta as concatenações
                        if (termosTextoProv[j].endsWith("\"")){ // ao encontrar o final da string (outro caracter final ") sai o while
                            j++;
                            break;
                        }
                        j++;
                    }

                    for (k=i+1;j<termosTextoProv.length;k++,j++){
                        termosTextoProv[k]=termosTextoProv[j];
                        termosTextoProv[j]="?"; // Apaga parte já deslocada
                    }
                    //if (j==termosTextoProv.length){ // -> Retirado pois estava errado (nao partmitia 2 strings com espacos internos) Desiste de montar a string pois atingiu o final do vetor (a pessoa não colocou o segundo caracter ")
                        //break; 
                    //}
                }
                else if((termosTextoProv[i].endsWith("\"")&&(termosTextoProv[i].length()==1))){ // a string comeca com espaco )
                    j=i+1;
                    while(j<termosTextoProv.length){ // controla o while para não exceder o vetor (pois a pessoa pode não ter colocado o segundo caracter ")
                        termosTextoProv[i]=termosTextoProv[i]+ " "+termosTextoProv[j];
                        concatenacoes++; // conta as concatenações
                        if (termosTextoProv[j].endsWith("\"")){ // ao encontrar o final da string (outro caracter final ") sai o while
                            j++;
                            break;
                        }
                        j++;
                    }

                    for (k=i+1;j<termosTextoProv.length;k++,j++){
                        termosTextoProv[k]=termosTextoProv[j];
                        termosTextoProv[j]="?"; // Apaga parte já deslocada
                    }
                }

            }
        }
        System.out.println(enters);
                
        // No for abaixo cada um dos termos encontrados no jTextPane são colocados em uma posicao do array de String termosTexto mas de modo que um comentário com aspas possa conter espaços.
        String termosTexto[];
        termosTexto = new String[termosTextoProv.length-concatenacoes]; 
        for(i=0;i<termosTexto.length;i++){
            termosTexto[i]=termosTextoProv[i];
        }
        
        
        
        jTextPane.setText(""); // Apaga conteúdo do jTextPane

        for (i=0;i<termosTexto.length;i++){ // Para cada termo do texto irá verificar se o mesmo deve ser colorido
            // Submente o termo atual ao método AFD (a ser implementado):
            /* O método AFD irá identificar o tipo de termo submetido, identificando seu tipo entre:  
                constante numérica(1), 
                string(2),
                operador aritmético(3), 
                operador lógico(4), 
                atribuição (5), 
                palavra reservada(6),
                identificador(7) ou 
                nenhum deles(0)
            e retornará o valor inteiro adequado (0 a 7).
            */
            
            //switch(metodoAFD(termosTexto[i])){ 
            switch(metodosAFD(termosTexto[i])){ // substituir pela linha acima após a implementacao do método AFD;
                case 1:     appendToPane(jTextPane, termosTexto[i]+" ", Color.gray); //constante numérica(1)
                            break;
                case 2:     appendToPane(jTextPane, termosTexto[i]+" ", Color.orange); //string(2)
                            break;
                case 3:     appendToPane(jTextPane, termosTexto[i]+" ", Color.pink); //operador aritmético(3) 
                            break;
                case 4:     appendToPane(jTextPane, termosTexto[i]+" ", Color.magenta); //operador lógico(4) (e relacional)
                            break;
                case 5:     appendToPane(jTextPane, termosTexto[i]+" ", Color.cyan); //atribuição (5)
                            break;
                case 6:     if (analisaPalavrasReservadas(termosTexto[i])){          // palavra reservada(6) (é preciso analisar se confere com a lista de palavras)
                                appendToPane(jTextPane, termosTexto[i]+" ", Color.blue);
                                break;
                            }
                            else{
                                appendToPane(jTextPane, termosTexto[i]+" ", Color.green); // se não for palavra reservada é, necessariamente, identificador
                                break;
                            }
                            
                case 7:     appendToPane(jTextPane, termosTexto[i]+" ", Color.green);    // identificador(7)
                            break;
                default:    appendToPane(jTextPane, termosTexto[i]+" ", Color.black); // nenhum dos identificáveis (não terminou em um estado final no AFD)(não colore)
                            break;

            }
                
        }
       
    }

    public boolean analisaPalavrasReservadas(String s){
        // Verifica se a string fornecida eh uma palavra reservada.
        for (int i=0;i<palavrasReservadas.length;i++){
            if (palavrasReservadas[i].matches(s)){
                return true;
            }
        }
        return false;
    }
    
    public int metodosAFD(String s){
        // Método falso e provisório para testes. Apenas simula algumas das análises e respostas do AFD a ser implementado

        Pattern p1;
        Matcher m1;
        
        runAFD afd = new runAFD();
        
        // USANDO AFD
        if (afd.runAFDConstante(s)){
            return 1;
        };

        // USANDO EXPRESSÕES REGULARES
/*
        p1 = Pattern.compile("[0-9]+(.[0-9]*){1}");
        m1=p1.matcher(s);
        if (m1.matches()){
            return 1;  //constante
        }        
*/
/*
        p1 = Pattern.compile("\"(.|\\s)*\"");
        m1=p1.matcher(s);
        if (m1.matches()){
            return 2;  // string
        }
*/
        if (afd.runAFDString(s)){
            return 2;
        };
        
 /*
        if (s.matches("\\+") || s.matches("-") || s.matches("\\*") || s.matches("/") || s.matches("%")){
            return 3; // op. aritm.
        }
*/
        if (afd.runAFDAritmeticos(s)){
            return 3;
        };        

        if (afd.runAFDOpLog(s)){
            return 4;
        };        

        
/*        if (s.matches("and") || s.matches("or") || s.matches("not") || s.matches("^") || s.matches("<") || s.matches(">") || s.matches("<=")|| s.matches(">=") || s.matches("==") || s.matches("~=")){
            return 4;  // op. lóg.
        }
*/
/*
        if (s.matches("=")){ // atrib.
            return 5;
        }
*/
        if (afd.runAFDAtribuicao(s)){
            return 5;
        };

        
        // USANDO AFD:
        if (afd.runAFDParavrasReservadas(s)){
            return 6;
        };
/*        
        p1 = Pattern.compile("[a-z][a-z][a-z]+"); // Todas palavras reservadas tem pelo menos 3 letras e são escritas com letras minusculas.
        m1=p1.matcher(s);
        if (m1.matches()){
            return 6;
        }
*/        
        
        if (afd.runAFDIdentificadores(s)){
            return 7;
        };

/*      p1 = Pattern.compile("([a-z]|[A-Z]|_)(_|[a-z]|[A-Z]|[0-9])*");
        m1=p1.matcher(s);
        if (m1.matches()){ // identificadores
            return 7;
        }
*/

        
        return 0; // padrao de retorno provisorio
    }
    
    
    
    
    public void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
    
    private void buildTextPane() {
        jTextPane = new JTextPane();    //construye un JTextPane
 
        //se configura por defecto para que se ajusten las líneas al tamaño del área de texto ...
 
        //asigna el manejador de eventos para el cursor
        jTextPane.addCaretListener(eventHandler);
        //asigna el manejador de eventos para el ratón
        jTextPane.addMouseListener(eventHandler);
        //asigna el manejador de eventos para registrar los cambios sobre el documento
        jTextPane.getDocument().addUndoableEditListener(eventHandler);
 
        //remueve las posibles combinaciones de teclas asociadas por defecto con el JTextPane
        jTextPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK), "none");    //remueve CTRL + X ("Cortar")
        jTextPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK), "none");    //remueve CTRL + C ("Copiar")
        jTextPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK), "none");    //remueve CTRL + V ("Pegar")
    }
    
    /**
     * Construye la barra de menú.
     */
    private void buildMenuBar() {
        jMenuBar = new JMenuBar();    //construye un JMenuBar
 
        //construye el menú "Archivo", a continuación se construyen los items para este menú
        JMenu menuFile = new JMenu("Arquivo");
 
        //construye el item "Nuevo"
        JMenuItem itemNew = new JMenuItem("Novo");
        //le asigna una conbinación de teclas
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        //le asigna un nombre de comando
        itemNew.setActionCommand("cmd_new");
 
        JMenuItem itemOpen = new JMenuItem("Abrir");
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        itemOpen.setActionCommand("cmd_open");
 
        JMenuItem itemSave = new JMenuItem("Salvar");
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        itemSave.setActionCommand("cmd_save");
 
        JMenuItem itemSaveAs = new JMenuItem("Salvar como...");
        itemSaveAs.setActionCommand("cmd_saveas");
        itemSaveAs.addActionListener(eventHandler);
 
        JMenuItem itemPrint = new JMenuItem("Imprimir");
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
        itemPrint.setActionCommand("cmd_print");
 
        JMenuItem itemExit = new JMenuItem("Sair");
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        itemExit.setActionCommand("cmd_exit");
 
        menuFile.add(itemNew);    //se añaden los items al menú "Archivo"
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemSaveAs);
        menuFile.addSeparator();
        menuFile.add(itemPrint);
        menuFile.addSeparator();
        menuFile.add(itemExit);
        //----------------------------------------------
 
        //construye el menú "Editar", a continuación se construyen los items para este menú
        JMenu menuEdit = new JMenu("Editar");
 
        mbItemUndo = new JMenuItem("Desfaz");
        mbItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        mbItemUndo.setEnabled(false);
        mbItemUndo.setActionCommand("cmd_undo");
 
        mbItemRedo = new JMenuItem("Refaz");
        mbItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        mbItemRedo.setEnabled(false);
        mbItemRedo.setActionCommand("cmd_redo");
 
        JMenuItem itemCut = new JMenuItem("Recortar");
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        itemCut.setActionCommand("cmd_cut");
 
        JMenuItem itemCopy = new JMenuItem("Copiar");
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        itemCopy.setActionCommand("cmd_copy");
 
        JMenuItem itemPaste = new JMenuItem("Colar");
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        itemPaste.setActionCommand("cmd_paste");
 
        JMenuItem itemSearch = new JMenuItem("Localizar");
        itemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        itemSearch.setActionCommand("cmd_search");
 
        JMenuItem itemSearchNext = new JMenuItem("Localizar próxima");
        itemSearchNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        itemSearchNext.setActionCommand("cmd_searchnext");
 
        JMenuItem itemGotoLine = new JMenuItem("Ir para a linha...");
        itemGotoLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        itemGotoLine.setActionCommand("cmd_gotoline");
 
        JMenuItem itemSelectAll = new JMenuItem("Selecionar tudo");
        itemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        itemSelectAll.setActionCommand("cmd_selectall");
 
        menuEdit.add(mbItemUndo);    //se añaden los items al menú "Editar"
        menuEdit.add(mbItemRedo);
        menuEdit.addSeparator();     //añade separadores entre algunos items
        menuEdit.add(itemCut);
        menuEdit.add(itemCopy);
        menuEdit.add(itemPaste);
        menuEdit.addSeparator();
        menuEdit.add(itemSearch);
        menuEdit.add(itemSearchNext);
        menuEdit.add(itemGotoLine);
        menuEdit.addSeparator();
        menuEdit.add(itemSelectAll);
        //----------------------------------------------
 
        //construye el menú "Opciones", a continuación se construyen los items para este menú
        JMenu menuTools = new JMenu("Opções");
 
        itemLineWrap = new JCheckBoxMenuItem("Ajuste de linha");
        itemLineWrap.setSelected(true);
        itemLineWrap.setActionCommand("cmd_linewrap");
 
        itemShowToolBar = new JCheckBoxMenuItem("Ver barra de ferramentas");
        itemShowToolBar.setSelected(true);
        itemShowToolBar.setActionCommand("cmd_showtoolbar");
 
        itemFixedToolBar = new JCheckBoxMenuItem("Fixar barra de ferramentas");
        itemFixedToolBar.setSelected(true);
        itemFixedToolBar.setActionCommand("cmd_fixedtoolbar");
 
        itemShowStatusBar = new JCheckBoxMenuItem("Ver barra de estado");
        itemShowStatusBar.setSelected(true);
        itemShowStatusBar.setActionCommand("cmd_showstatusbar");
 
        JMenuItem itemFont = new JMenuItem("Fonte");
        itemFont.setActionCommand("cmd_font");
 
        JMenuItem itemFontColor = new JMenuItem("Cor da fonte");
        itemFontColor.setActionCommand("cmd_fontcolor");
 
        JMenuItem itemBackgroundColor = new JMenuItem("Cor de fundo");
        itemBackgroundColor.setActionCommand("cmd_backgroundcolor");
 
        menuTools.add(itemLineWrap);    //se añaden los items al menú "Opciones"
        menuTools.add(itemShowToolBar);
        menuTools.add(itemFixedToolBar);
        menuTools.add(itemShowStatusBar);
        menuTools.addSeparator();
        menuTools.add(itemFont);
        menuTools.add(itemFontColor);
        menuTools.add(itemBackgroundColor);
 
        //construye el menú "Ayuda", a continuación se construye el único item para este menú
        JMenu menuHelp = new JMenu("Ajuda");
 
        JMenuItem itemAbout = new JMenuItem("Sobre");
        itemAbout.setActionCommand("cmd_about");
 
        menuHelp.add(itemAbout);     //se añade el único item al menú "Ayuda"
        //----------------------------------------------
 
        jMenuBar.add(menuFile);    //se añaden los menúes construidos a la barra de menú
        jMenuBar.add(Box.createHorizontalStrut(5));    //añade espacios entre cada menú
        jMenuBar.add(menuEdit);
        jMenuBar.add(Box.createHorizontalStrut(5));
        jMenuBar.add(menuTools);
        jMenuBar.add(Box.createHorizontalStrut(5));
        jMenuBar.add(menuHelp);
 
        /** itera sobre todos los componentes de la barra de menú, se les asigna el mismo
        manejador de eventos a todos excepto a los separadores */
        for (Component c1 : jMenuBar.getComponents()) {
            //si el componente es un menú
            if (c1.getClass().equals(javax.swing.JMenu.class)) {
                //itera sobre los componentes del menú
                for (Component c2 : ((JMenu) c1).getMenuComponents()) {
                    //si el componente no es un separador
                    if (!c2.getClass().equals(javax.swing.JPopupMenu.Separator.class)) {
                        ((JMenuItem) c2).addActionListener(eventHandler);
                    }
                }
            }
        }
    }
 
    /**
     * Construye la barra de herramientas.
     */
    private void buildToolBar() {
        jToolBar = new JToolBar();       //construye un JToolBar
        jToolBar.setFloatable(false);    //se configura por defecto como barra fija
 
        //construye el botón "Nuevo"
        JButton buttonNew = new JButton();
        //le asigna una etiqueta flotante
        buttonNew.setToolTipText("Novo");
        //le asigna una imagen ubicada en los recursos del proyecto
        buttonNew.setIcon(new ImageIcon(getClass().getResource("/res/tp_new.png")));
        //le asigna un nombre de comando
        buttonNew.setActionCommand("cmd_new");
 
        JButton buttonOpen = new JButton();
        buttonOpen.setToolTipText("Abrir");
        buttonOpen.setIcon(new ImageIcon(getClass().getResource("/res/tp_open.png")));
        buttonOpen.setActionCommand("cmd_open");
 
        JButton buttonSave = new JButton();
        buttonSave.setToolTipText("Salvar");
        buttonSave.setIcon(new ImageIcon(getClass().getResource("/res/tp_save.png")));
        buttonSave.setActionCommand("cmd_save");
 
        JButton buttonSaveAs = new JButton();
        buttonSaveAs.setToolTipText("Salvar como...");
        buttonSaveAs.setIcon(new ImageIcon(getClass().getResource("/res/tp_saveas.png")));
        buttonSaveAs.setActionCommand("cmd_saveas");
 
        JButton buttonPrint = new JButton();
        buttonPrint.setToolTipText("Imprimir");
        buttonPrint.setIcon(new ImageIcon(getClass().getResource("/res/tp_print.png")));
        buttonPrint.setActionCommand("cmd_print");
 
        buttonUndo = new JButton();
        buttonUndo.setEnabled(false);
        buttonUndo.setToolTipText("Desfaz");
        buttonUndo.setIcon(new ImageIcon(getClass().getResource("/res/tp_undo.png")));
        buttonUndo.setActionCommand("cmd_undo");
 
        buttonRedo = new JButton();
        buttonRedo.setEnabled(false);
        buttonRedo.setToolTipText("Refaz");
        buttonRedo.setIcon(new ImageIcon(getClass().getResource("/res/tp_redo.png")));
        buttonRedo.setActionCommand("cmd_redo");
 
        JButton buttonCut = new JButton();
        buttonCut.setToolTipText("Recortar");
        buttonCut.setIcon(new ImageIcon(getClass().getResource("/res/tp_cut.png")));
        buttonCut.setActionCommand("cmd_cut");
 
        JButton buttonCopy = new JButton();
        buttonCopy.setToolTipText("Copiar");
        buttonCopy.setIcon(new ImageIcon(getClass().getResource("/res/tp_copy.png")));
        buttonCopy.setActionCommand("cmd_copy");
 
        JButton buttonPaste = new JButton();
        buttonPaste.setToolTipText("Colar");
        buttonPaste.setIcon(new ImageIcon(getClass().getResource("/res/tp_paste.png")));
        buttonPaste.setActionCommand("cmd_paste");
 
        jToolBar.add(buttonNew);    //se añaden los botones construidos a la barra de herramientas
        jToolBar.add(buttonOpen);
        jToolBar.add(buttonSave);
        jToolBar.add(buttonSaveAs);
        jToolBar.addSeparator();    //añade separadores entre algunos botones
        jToolBar.add(buttonPrint);
        jToolBar.addSeparator();
        jToolBar.add(buttonUndo);
        jToolBar.add(buttonRedo);
        jToolBar.addSeparator();
        jToolBar.add(buttonCut);
        jToolBar.add(buttonCopy);
        jToolBar.add(buttonPaste);
 
        /** itera sobre todos los componentes de la barra de herramientas, se les asigna el
        mismo margen y el mismo manejador de eventos unicamente a los botones */
        for (Component c : jToolBar.getComponents()) {
            //si el componente es un botón
            if (c.getClass().equals(javax.swing.JButton.class)) {
                JButton jb = (JButton) c;
                jb.setMargin(new Insets(0, 0, 0, 0));
                jb.addActionListener(eventHandler);
            }
        }
    }
 
    /**
     * Construye la barra de estado.
     */
    private void buildStatusBar() {
        statusBar = new JPanel();    //construye un JPanel
        //se configura con un BoxLayout
        statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.LINE_AXIS));
        //le añade un borde compuesto
        statusBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
 
        //construye la etiqueta para mostrar la ubicación del archivo actual
        sbFilePath = new JLabel("...");
        //construye la etiqueta para mostrar el tamaño del archivo actual
        sbFileSize = new JLabel("");
        //construye la etiqueta para mostrar la posición del cursor en el documento actual
        sbCaretPos = new JLabel("...");
 
        /** se añaden las etiquetas construidas al JPanel, el resultado es un panel
        similar a una barra de estado */
        statusBar.add(sbFilePath);
        statusBar.add(Box.createRigidArea(new Dimension(10, 0)));
        statusBar.add(sbFileSize);
        statusBar.add(Box.createRigidArea(new Dimension(10, 0)));
        statusBar.add(Box.createHorizontalGlue());
        statusBar.add(sbCaretPos);
    }
 
    /**
     * Construye el menú emergente.
     */
    private void buildPopupMenu() {
        jPopupMenu = new JPopupMenu();    //construye un JPopupMenu
 
        //construye el item "Deshacer"
        mpItemUndo = new JMenuItem("Desfaz");
        //se configura desactivado por defecto
        mpItemUndo.setEnabled(false);
        //le asigna un nombre de comando
        mpItemUndo.setActionCommand("cmd_undo");
 
        mpItemRedo = new JMenuItem("Refaz");
        mpItemRedo.setEnabled(false);
        mpItemRedo.setActionCommand("cmd_redo");
 
        JMenuItem itemCut = new JMenuItem("Recortar");
        itemCut.setActionCommand("cmd_cut");
 
        JMenuItem itemCopy = new JMenuItem("Copiar");
        itemCopy.setActionCommand("cmd_copy");
 
        JMenuItem itemPaste = new JMenuItem("Colar");
        itemPaste.setActionCommand("cmd_paste");
 
        JMenuItem itemGoto = new JMenuItem("Ir para a linha...");
        itemGoto.setActionCommand("cmd_gotoline");
 
        JMenuItem itemSearch = new JMenuItem("Localizar");
        itemSearch.setActionCommand("cmd_search");
 
        JMenuItem itemSearchNext = new JMenuItem("Localizar próxima");
        itemSearchNext.setActionCommand("cmd_searchnext");
 
        JMenuItem itemSelectAll = new JMenuItem("Selecionar tudo");
        itemSelectAll.setActionCommand("cmd_selectall");
 
        jPopupMenu.add(mpItemUndo);    //se añaden los items al menú emergente
        jPopupMenu.add(mpItemRedo);
        jPopupMenu.addSeparator();     //añade separadores entre algunos items
        jPopupMenu.add(itemCut);
        jPopupMenu.add(itemCopy);
        jPopupMenu.add(itemPaste);
        jPopupMenu.addSeparator();
        jPopupMenu.add(itemGoto);
        jPopupMenu.add(itemSearch);
        jPopupMenu.add(itemSearchNext);
        jPopupMenu.addSeparator();
        jPopupMenu.add(itemSelectAll);
 
        /** itera sobre todos los componentes del menú emergente, se les asigna el mismo
        manejador de eventos a todos excepto a los separadores */
        for (Component c : jPopupMenu.getComponents()) {
            //si el componente es un item
            if (c.getClass().equals(javax.swing.JMenuItem.class)) {
                ((JMenuItem) c).addActionListener(eventHandler);
            }
        }
    }
 
    /**
     * Hace visible el menú emergente.
     *
     * @param me evento del ratón
     */
    private void showPopupMenu(MouseEvent me) {
        if (me.isPopupTrigger() == true) {    //si el evento es el desencadenador de menú emergente
            //hace visible el menú emergente en las coordenadas actuales del ratón
            jPopupMenu.show(me.getComponent(), me.getX(), me.getY());
        }
    }
 
    /**
     * Actualiza el estado de las opciones "Deshacer" y "Rehacer".
     */
    void updateControls() {
        //averigua si se pueden deshacer los cambios en el documento actual
        boolean canUndo = undoManager.canUndo();
        //averigua si se pueden rehacer los cambios en el documento actual
        boolean canRedo = undoManager.canRedo();
 
        //activa o desactiva las opciones en la barra de menú
        mbItemUndo.setEnabled(canUndo);
        mbItemRedo.setEnabled(canRedo);
 
        //activa o desactiva las opciones en la barra de herramientas
        buttonUndo.setEnabled(canUndo);
        buttonRedo.setEnabled(canRedo);
 
        //activa o desactiva las opciones en el menú emergente
        mpItemUndo.setEnabled(canUndo);
        mpItemRedo.setEnabled(canRedo);
    }
 
    /**
     * Retorna la instancia de EventHandler, la clase interna que maneja eventos.
     *
     * @return el manejador de eventos.
     */
    EventHandler getEventHandler() {
        return eventHandler;
    }
 
    /**
     * Retorna la instancia de UndoManager, la cual administra las ediciones sobre
     * el documento en el área de texto.
     *
     * @return el administrador de edición.
     */
    UndoManager getUndoManager() {
        return undoManager;
    }
 
    /**
     * Retorna el estado del documento actual.
     *
     * @return true si ah sido modificado, false en caso contrario
     */
    boolean documentHasChanged() {
        return hasChanged;
    }
 
    /**
     * Establece el estado del documento actual.
     *
     * @param hasChanged true si ah sido modificado, false en caso contrario
     */
    void setDocumentChanged(boolean hasChanged) {
        this.hasChanged = hasChanged;
    }
 
    /**
     * Retorna la instancia de JTextPane, el área de edición.
     *
     * @return retorna el área de edición.
     */
    JTextPane getJTextPane() {
        return jTextPane;
    }
 
    /**
     * Retorna la instancia de JFrame, la ventana principal del editor.
     *
     * @return la ventana principal del editor.
     */
    JFrame getJFrame() {
        return jFrame;
    }
 
    /**
     * Retorna la instancia de File, el archivo actual.
     *
     * @return el archivo actual
     */
    File getCurrentFile() {
        return currentFile;
    }
 
    /**
     * Establece el archivo actual.
     *
     * @param currentFile el archivo actual
     */
    void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }
 
    /**
     * Retorna la instancia de la etiqueta sbFilePath, donde se muestra la ubicación
     * del archivo actual.
     *
     * @return la instancia de la etiqueta sbFilePath
     */
    JLabel getJLabelFilePath() {
        return sbFilePath;
    }
 
    /**
     * Retorna la instancia de la etiqueta sbFileSize, donde se muestra el tamaño
     * del archivo actual
     *
     * @return la instancia de la etiqueta sbFileSize
     */
    JLabel getJLabelFileSize() {
        return sbFileSize;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
      //if (e.getKeyCode() == KeyEvent.VK_SPACE) {
       //   analisarTexto();  
          //colorirTexto();  
          
     // }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
      if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
          analisarTexto();  
          //colorirTexto();  
          
      }
    }
 
    /**
     * Clase interna que extiende e implementa las clases e interfaces necesarias para
     * atender y manejar los eventos sobre la GUI principal del editor.
     */
    class EventHandler extends MouseAdapter implements ActionListener,
                                                       CaretListener,
                                                       UndoableEditListener {
 
        /**
         * Atiende y maneja los eventos de acción.
         *
         * @param ae evento de acción
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            String ac = ae.getActionCommand();    //se obtiene el nombre del comando ejecutado
 
            if (ac.equals("cmd_new") == true) {    //opción seleccionada: "Nuevo"
                actionPerformer.actionNew();
            } else if (ac.equals("cmd_open") == true) {    //opción seleccionada: "Abrir"
                actionPerformer.actionOpen();
            } else if (ac.equals("cmd_save") == true) {    //opción seleccionada: "Guardar"
                actionPerformer.actionSave();
            } else if (ac.equals("cmd_saveas") == true) {    //opción seleccionada: "Guardar como"
                actionPerformer.actionSaveAs();
            } else if (ac.equals("cmd_print") == true) {    //opción seleccionada: "Imprimir"
                actionPerformer.actionPrint();
            } else if (ac.equals("cmd_exit") == true) {    //opción seleccionada: "Salir"
                actionPerformer.actionExit();
            } else if (ac.equals("cmd_undo") == true) {    //opción seleccionada: "Deshacer"
                actionPerformer.actionUndo();
            } else if (ac.equals("cmd_redo") == true) {    //opción seleccionada: "Rehacer"
                actionPerformer.actionRedo();
            } else if (ac.equals("cmd_cut") == true) {    //opción seleccionada: "Cortar"
                //corta el texto seleccionado en el documento
                jTextPane.cut();
            } else if (ac.equals("cmd_copy") == true) {    //opción seleccionada: "Copiar"
                //copia el texto seleccionado en el documento
                jTextPane.copy();
            } else if (ac.equals("cmd_paste") == true) {    //opción seleccionada: "Pegar"
                //pega en el documento el texto del portapapeles
                jTextPane.paste();
            } else if (ac.equals("cmd_gotoline") == true) {    //opción seleccionada: "Ir a la línea..."
                actionPerformer.actionGoToLine();
            } else if (ac.equals("cmd_search") == true) {    //opción seleccionada: "Buscar"
                actionPerformer.actionSearch();
            } else if (ac.equals("cmd_searchnext") == true) {    //opción seleccionada: "Buscar siguiente"
                actionPerformer.actionSearchNext();
            } else if (ac.equals("cmd_selectall") == true) {    //opción seleccionada: "Seleccionar todo"
                jTextPane.selectAll();
            } else if (ac.equals("cmd_linewrap") == true) {    //opción seleccionada: "Ajuste de línea"
                //si esta propiedad esta activada se desactiva, o lo inverso
   //             jTextPane.setLineWrap(!jTextPane.getLineWrap());
   //             jTextPane.setWrapStyleWord(!jTextPane.getWrapStyleWord());
            } else if (ac.equals("cmd_showtoolbar") == true) {    //opción seleccionada: "Ver barra de herramientas"
                //si la barra de herramientas esta visible se oculta, o lo inverso
                jToolBar.setVisible(!jToolBar.isVisible());
            } else if (ac.equals("cmd_fixedtoolbar") == true) {    //opción seleccionada: "Fijar barra de herramientas"
                //si esta propiedad esta activada se desactiva, o lo inverso
                jToolBar.setFloatable(!jToolBar.isFloatable());
            } else if (ac.equals("cmd_showstatusbar") == true) {    //opción seleccionada: "Ver barra de estado"
                //si la barra de estado esta visible se oculta, o lo inverso
                statusBar.setVisible(!statusBar.isVisible());
            } else if (ac.equals("cmd_font") == true) {    //opción seleccionada: "Fuente de letra"
                actionPerformer.actionSelectFont();
            } else if (ac.equals("cmd_fontcolor") == true) {    //opción seleccionada: "Color de letra"
                actionPerformer.actionSelectFontColor();
            } else if (ac.equals("cmd_backgroundcolor") == true) {    //opción seleccionada: "Color de fondo"
                actionPerformer.actionSelectBackgroundColor();
            } else if (ac.equals("cmd_about") == true) {    //opción seleccionada: "Acerca de"
                //presenta un dialogo modal con alguna informacion
                JOptionPane.showMessageDialog(jFrame,
                                              "Editor LFC. Adaptado de TexPad Demo de Dark[byte]",
                                              "Sobre",
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        }
 
        /**
         * Atiende y maneja los eventos del cursor.
         *
         * @param ce evento del cursor
         */
        @Override
        public void caretUpdate(CaretEvent e) {
            final int caretPos;  //valor de la posición del cursor sin inicializar
            int y = 1;           //valor de la línea inicialmente en 1
            int x = 1;           //valor de la columna inicialmente en 1
 
  //          try {
                //obtiene la posición del cursor con respecto al inicio del JTextPane (área de edición)
  //              caretPos = jTextPane.getCaretPosition();
                //sabiendo lo anterior se obtiene el valor de la línea actual (se cuenta desde 0)
 //               y = jTextPane.getLineOfOffset(caretPos);
 
                /** a la posición del cursor se le resta la posición del inicio de la línea para
                determinar el valor de la columna actual */
   //             x = caretPos - jTextPane.getLineStartOffset(y);
 
                //al valor de la línea actual se le suma 1 porque estas comienzan contándose desde 0
   //             y += 1;
  //          } catch (BadLocationException ex) {    //en caso de que ocurra una excepción
   //             System.err.println(ex);
   //         }
 
            /** muestra la información recolectada en la etiqueta sbCaretPos de la
            barra de estado, también se incluye el número total de lineas */
  //          sbCaretPos.setText("Linhas: " + jTextPane.getLineCount() + " - Y: " + y + " - X: " + x);
        }
 
        /**
         * Atiende y maneja los eventos sobre el documento en el área de edición.
         *
         * @param uee evento de edición
         */
        @Override
        public void undoableEditHappened(UndoableEditEvent uee) {
            /** el cambio realizado en el área de edición se guarda en el buffer
            del administrador de edición */
            undoManager.addEdit(uee.getEdit());
            updateControls();    //actualiza el estado de las opciones "Deshacer" y "Rehacer"
 
            hasChanged = true;
        }
 
        /**
         * Atiende y maneja los eventos sobre el ratón cuando este es presionado.
         *
         * @param me evento del ratón
         */
        @Override
        public void mousePressed(MouseEvent me) {
            showPopupMenu(me);
        }
 
        /**
         * Atiende y maneja los eventos sobre el ratón cuando este es liberado.
         *
         * @param me evento del ratón
         */
        @Override
        public void mouseReleased(MouseEvent me) {
            showPopupMenu(me);
        }
        
    }
}