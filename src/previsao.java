import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class previsao extends JPanel {
	private JComboBox cbDias;
	private JList listLocal;
	private JScrollPane spLocal;
	private ImageIcon imgFundo, imgNublado, imgEnsolarado, imgChuvoso;
	private JLabel lFundo, tituloDia, tituloEstado, graus, dia, nublado, ensolarado, chuvoso;
	private JButton prever;	

	public previsao() {
		inicializarComponentes();
		definirEventos();	
	}

	private void inicializarComponentes() {
		setLayout(null);
		String[] cbDiasItens = { "Segunda", "Terça", "Quarta" };
		String[] listLocalItens = {"São Paulo", "Rio de Janeiro", "Bahia", "Santa Catarina"};
		cbDias = new JComboBox(cbDiasItens);
		listLocal = new JList(listLocalItens);
		spLocal = new JScrollPane(listLocal);
		imgFundo = new ImageIcon("Fundo.gif");
		lFundo = new JLabel(imgFundo);
		imgNublado = new ImageIcon("nublado.png");
		nublado = new JLabel(imgNublado);
		imgEnsolarado = new ImageIcon("Ensolarado.png");
		ensolarado = new JLabel(imgEnsolarado);
		imgChuvoso = new ImageIcon("chuvoso.png");
		chuvoso = new JLabel(imgChuvoso);
		tituloDia = new JLabel("Dias: ");
		tituloEstado = new JLabel("Estados: ");
		prever = new JButton("Prever");
		graus = new JLabel();
		dia = new JLabel("");
		
		add(cbDias);
		add(spLocal);
		add(tituloDia);
		add(tituloEstado);
		add(nublado);
		nublado.setVisible(false);
		add(ensolarado);
		ensolarado.setVisible(false);
		add(chuvoso);
		chuvoso.setVisible(false);
		add(prever);
		add(graus);
		add(dia);
		add(lFundo);

		lFundo.setBounds(0, 0, 548, 720);
		tituloDia.setBounds(150, 460, 50, 25);
		tituloDia.setFont(new Font("Arial", Font.BOLD, 14));
		tituloEstado.setBounds(50, 460, 80, 25);
		tituloEstado.setFont(new Font("Arial", Font.BOLD, 14));
		cbDias.setBounds(150, 480, 90, 25);
		cbDias.setFont(new Font("Arial", Font.BOLD, 14));
		cbDias.setBackground(new Color(255,255,255, 1));
		spLocal.setBounds(50, 480, 100, 67);
		listLocal.setFont(new Font("Arial", Font.BOLD, 12));
		listLocal.setBackground(new Color(255,255,255, 1));
		prever.setBounds(245, 500, 90, 30);
		prever.setContentAreaFilled(false);
		prever.setFocusable(false);
		nublado.setBounds(190, 10, 128, 128);
		ensolarado.setBounds(190, 10, 128, 128);
		chuvoso.setBounds(190, 10, 128, 128);
		graus.setBounds(210, 110, 130, 100);
		graus.setFont(new Font("Arial", Font.BOLD, 50));
		dia.setBounds(218, 145, 120, 100);
		dia.setFont(new Font("Arial", Font.BOLD, 20));
	}

	private void definirEventos() {
		int random[] = new int[12];
		int randomN[] = new int[12];
		int temp[] = new int[12];
		int clima[] = new int[12];
		
		for(int i = 0; i < 12 ; i++) {
			random[i] = (int) (Math.random()*30);
			randomN[i] = (int) (Math.random()*-10);
			temp[i] = randomN[i] + random[i];
			clima[i] = (int) (Math.random()*3); 
		}
		
		prever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nublado.setVisible(false);
				ensolarado.setVisible(false);
				chuvoso.setVisible(false);
				if(listLocal.getSelectedIndex()==-1){
					JOptionPane.showMessageDialog(null,"Selecione um item da lista: ");
					return;
				}
			
				if(listLocal.getSelectedIndex()== 0 && cbDias.getSelectedIndex()== 0){
					graus.setText(temp[0]+"°C");    
					defClima(clima[0]);
				}                                 
				                                 
				if(listLocal.getSelectedIndex()== 0 && cbDias.getSelectedIndex()== 1){
					graus.setText(temp[1]+"°C");  
					defClima(clima[1]);
				}                                
				                                 
				if(listLocal.getSelectedIndex()== 0 && cbDias.getSelectedIndex()== 2){
					graus.setText(temp[2]+"°C");  
					defClima(clima[2]);
				}                                  
				                                   
				if(listLocal.getSelectedIndex()== 1 && cbDias.getSelectedIndex()== 0){
					graus.setText(temp[3]+"°C");  
					defClima(clima[3]);      
				}                                 
				                                   
				if(listLocal.getSelectedIndex()== 1 && cbDias.getSelectedIndex()== 1){
					graus.setText(temp[4]+"°C");  
					defClima(clima[4]);
				}                                 
				                                  
				if(listLocal.getSelectedIndex()== 1 && cbDias.getSelectedIndex()== 2){
					graus.setText(temp[5]+"°C");   
					defClima(clima[5]);
				}                                  
				                                   
				if(listLocal.getSelectedIndex()== 2 && cbDias.getSelectedIndex()== 0){
					graus.setText(temp[6]+"°C");  
					defClima(clima[6]);
				}                                   
				                                    
				if(listLocal.getSelectedIndex()== 2 && cbDias.getSelectedIndex()== 1){
					graus.setText(temp[7]+"°C");  
					defClima(clima[7]);
				}                                   
				                                  
				if(listLocal.getSelectedIndex()== 2 && cbDias.getSelectedIndex()== 2){
					graus.setText(temp[8]+"°C");     
					defClima(clima[8]);
				}
				
				if(listLocal.getSelectedIndex()== 3 && cbDias.getSelectedIndex()== 0){
					graus.setText(temp[9]+"°C");  
					defClima(clima[9]);
				}
				
				if(listLocal.getSelectedIndex()== 3 && cbDias.getSelectedIndex()== 1){
					graus.setText(temp[10]+"°C");  
					defClima(clima[10]);
				}
				
				if(listLocal.getSelectedIndex()== 3 && cbDias.getSelectedIndex()== 2){
					graus.setText(temp[11]+"°C");  
					defClima(clima[11]);
				}
				
				
				
				
				
				
				dia.setText(""+cbDias.getSelectedItem());
				
				
			}
		});
	}
	
	public void defClima(int clima) {
		if(clima == 1) {
			nublado.setVisible(true);
		}else if(clima == 2) {
			ensolarado.setVisible(true);
		}else {
			chuvoso.setVisible(true);
		}
	}
	
	

	public static void main(String args[]) {
		JFrame frame = new JFrame("Previsão do tempo - 3SIT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new previsao());
		frame.setBounds(450, 5, 548, 720);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
